package controller.admin;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dao.MemberDao;
import model.dto.ClietDto;

@ServerEndpoint("/alarm/{mid}")
public class Alarm {
	
	private static ArrayList<ClietDto>알림명단 = new ArrayList<>();
	
	@OnOpen		 //클라이언트 소켓이 들어왔을때
	public void 서버입장(Session session, @PathParam("mid")String mid ) {
		알림명단.add(new ClietDto(session,mid)); }
	@OnClose	//클라이언트 소켓이 나갔을때
	public void 서버나가기(Session session){
		for(ClietDto c: 알림명단) {
			if(c.getSession()==session) {
				알림명단.remove(c);
			}
		}
					
	}
	@OnError	//클라이언트 소켓이 에러가 발생했을떄
	public void 서버오류(Session session, Throwable e){
		System.out.println(session); }
	
	@OnMessage	//클라이언트 소켓이 메시지를  보냇을때 매핑[연결] 필수로 정의할 인수
	public static void 서버메시지(Session session, String msg) throws Exception {
		
		int tomno =Integer.parseInt(msg.split(",")[0] ); 
		
		String tomsg = msg.split(",")[1];
		
		for(ClietDto c: 알림명단) {
			
			int cmno=MemberDao.getInstance().getMember(c.getMid()).getMno();
			if(cmno==tomno) {//받는 회원번호가 알림명단에 존재하면
				c.getSession().getBasicRemote().sendText(tomsg);
			}
		}
	}
}


/*
 * 
 * Session session: 요청한 클라이언트 소켓
 * Throwable e: 에러 발생시 에러이유가 저장된 변수
 * String msg: 요청받은 메시지 내용
 * 
 * 	서버소켓 
 * 1.@ServerEndpoint("서버소켓경로")
 * 2.@OnOpen 		필수 매개변수 : Session session
 * 3.@OnClose		필수 매개변수 : Session session
 * 4.@OnError		필수 매개변수 : Session session, Throwable e
 * 5.@OnMessage		필수 매개변수 : Session session, String s
 * 6.@PathParam("경로상의{매개변수명}")		: 경로상의 변수 요청
 * */
