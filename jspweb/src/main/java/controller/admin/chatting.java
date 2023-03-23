package controller.admin;


import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.catalina.mapper.Mapper;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClietDto;
import model.dto.MemberDto;
import model.dto.MessageDto;

@ServerEndpoint("/chatting/{mid}")	//해당 클래스를 서버소켓[종착점]으로 만들기'
public class chatting {
	// ** 접속한 클라이언트 명단
	public static ArrayList<ClietDto>접속명단 = new ArrayList<>();
	
	//클라이언트 소켓이 접속했을떄의 실행되는 메소드/함수
	//URL 매개변수받을때:/경로/{매개변수1}/{매개변수2}		--> @PathParam("경로상의매개변수명") 타입 변수명
						//	/jspweb/chatting/gksruf
							//jspweb/chatting/{mid}
					//		@PathParam("mid") string 매개변수;
					//		매개변수 = gksruf
	
	@javax.websocket.OnOpen	//session [접속한 클라이소켓 객체]	//서버 엔드포인트의 Url 매개변수[@PathParam] 가져오기
	public void OnOpen(Session session, @PathParam("mid") String mid) {
		System.out.println("클라이언트 웹소켓이 들어왔다");
		System.out.println(session);
		//접속한 클라이언트소켓들을 보관-> 따로 필드 위에 만들게
		ClietDto clietDto = new ClietDto(session, mid);
		접속명단.add(clietDto);
		System.out.println(접속명단.toString());
		try {	
			OnMessage(session, "enter");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//
	@OnClose	//클라이언트소켓이 나갔을때 [F5 ]
	public void OnClose(Session session) throws Exception {
		System.out.println("클라이언트 웹소켓이 나갔습니다");
		//접속이 끊긴 세션의 dto찾아서 제외
		for(ClietDto dto : 접속명단) {
			//회원명단에서 세션과 접속이 끊긴 세션과 일치하면
			if(dto.getSession()==session) {
				접속명단.remove(dto);	//접속명단에서 제외 시키기
				
				//연결이 끊긴 클라이언트 소켓을 모든 접속명단에게 알림 메시지 보내기
				//1.문자열타입의 json 형식 직접 작성하기
					//{\"필드명\":"데이터","필드명2": "데이터2"}
				String msg = "{\"type\":\"alarm\",\"msgbox\":\""+dto.getMid()+"님이 채팅방에 나갔습니다.\"}";
				OnMessage(session, msg);
				//연결이 끊긴 클라이언트소켓 알림 메시지 보내기
				OnMessage(session, "enter");
				break;
			}
		}
				
	}
	
	
	//클라이언트 소켓이 메시지를 보냈을떄[서버가 메시지 받기]
	@OnMessage	//[Session[누가], string[내용물] ]
	public void OnMessage(Session session, String msg) throws Exception {
		System.out.println("클라이언트 웹소켓이 메시지를 보냈다");
		System.out.println(msg);
		
		
		ObjectMapper mapper = new ObjectMapper();
		String json =null;//메시지 받는 프로그램 : json 으로 형변환	

		
		//2.접속명단 알림
		if(msg.equals("enter")) {
			//회원명단[이미지,아이디]포함된 회원리스트 생성* 얘는 모든 접속자
			ArrayList<MessageDto>list = new ArrayList<>();
			for(ClietDto dto:접속명단) {
				list.add(new MessageDto(dto.getSession(), null) );
			}
			json=mapper.writeValueAsString(list);
		}else {
			//1.메시지
			//메시지 형식 구성**얘는 보낸사람의 정보 즉 객체 1개
			MessageDto messageDto = new MessageDto(session, msg);	
			System.out.println(messageDto );
			json=mapper.writeValueAsString(messageDto);
		}

		//**서버가 클라이언트 소켓에게 메시지를 보내기
		//현재 서버소켓과 연결된 클라이언트소켓 모두에게 서버가 받은 내용물 전달
		for(ClietDto dto: 접속명단) {
			dto.getSession().getBasicRemote().sendText(json);	//->onmessage 으로감
		}
	
	}
	
}
