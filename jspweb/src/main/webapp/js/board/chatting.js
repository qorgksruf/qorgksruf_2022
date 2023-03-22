/*

	코드 작성= 요리사		JS = 개발자
	코드 실행= 먹는 사람		JS =  유저

	소캣: 두 프로그램간의 양방향 통신 종착점[도착지]
	1.클라이언트에 종착지인 소캣만들기
	2.서버실에 종착지인 소캣만들기
	서버소켓: [JAVA]서버가 가지고 있는 소켓===> 얘가 배포함 
	클라이언트켓: [JS] 클라이언트가 가지고 있는 소켓[각 클라이언트마다 ]
	
	
	카카오톡유저						카카오톡 본사/서버실
	클라이언트							서버
	new WebSocket(서버소켓URL)			@ServerEndpoint("/서버소켓url")
		1.클라이언트소켓.onopen()---->	@OnOpen
		2.클라이언트소켓.send()-------> @OnMessage
		3.클라이언트소켓.onmessage <------보내기---세션객체.getbasicRemote().sendText()
		4.					<-----연결끊기-----@OnClose	
		
		
	유재석	안녕-------------------->	
	(소캣)	<----------------------안녕
	안산	
	
	
	강호동								(서버소캣) 단톡채팅방(유재석,강호동,신동엽)
	(소캣)	<----------------------안녕	제주도, 성남
	수원
	
	
	신동엽
	(소캣)	<----------------------안녕
	서울	
			
	JS webSocket
		1.JS에서 제공하는 클래스 webScoket(ws://URL); 
		2.소켓 객체 만들기
				 let 클라이언트소켓 =new wWebSocket(ws://ip:포트번호/프로젝트명/chatting);	여긴 안산이라고 생각하삼
		3. 소켓이 서버소켓과 연동
			1. webSocket 생성자에서 해당 서버소켓의 경로 확인 통신
			
			
		JAVA에 서버소켓 만들기
			1.임의의 클래스 생성
			2.서버소켓 만들기
				클래스위에 @ServerEndpoint("/서버소켓의경로url만들기") 카카오의 본사 제주도라고 생각하삼
					-@ServerEndpoint: 서버소켓의 url 만들기
					-@WebServlet	: HTTP의 URL 만들기
			3.클라이언트소켓이 서버소켓[엔드포인트]으로 접속했을때
				 @OnOpen: 클라이언트소켓이 접속했을때 매핑[연결]
			

*/


let contentbox=document.querySelector('.contentbox');

console.log("--------------------")
console.log(memberinfo)

let 클라이언트소켓=null;

let chattingbox=document.querySelector

if(memberinfo.mid==null){
	alert('로그인하고 들어오세요')
	location.href="/jspweb/member/login.jsp";
}else{
	//1.클라이언트소켓 생성과 서버소켓 연결[@onopen]
	 클라이언트소켓 =new WebSocket('ws://192.168.17.54:8080/jspweb/chatting/'+memberinfo.mid);	//종착점// new WebSocket('ws://localhost:8080/jspweb/chatting'/+로그인한 사람 아이디
	 클라이언트소켓.onopen=function(e){서버소켓연결(e)}
	 클라이언트소켓.onmessage =function(e){메시지받기(e)}
	 클라이언트소켓.onclose = function(e){연결해제(e)}
}



//2.클라이언트소켓이 접속했을때 이벤트/함수 정의 걍 오픈과 동시에 입장함수라고 생각하삼 없어도됨
function 서버소켓연결(e){
	contentbox.innerHTML+=`	
				<div class="alerm">
					<span> 채팅방입장하셨습니다 </span>
				</div>`
} //접속했을때 하고싶은 함수 정의





//3.클라이언트 소켓이 서버에게 메시지보내기@OnMessage
function 보내기(){
	console.log('send열림')
	let msgbox=document.querySelector('.msgbox').value;
	console.log(msgbox);
	//*서버소켓에게 메시지 전송하기
	클라이언트소켓.send(msgbox);//@OnMessage로감
	//전송 성공시 채팅창 초기화
	document.querySelector('.msgbox').value='';
}




//4.서버로부터 메시지가 왔을때 메시지 받기
function 메시지받기(e){//<-----<-e-----getBasicRemote().sendText(msg)\
	console.log(e)	
	console.log(e.data);				//얘는 문자열타임 
	console.log(JSON.parse(e.data) );	//문자열 json -> 객체 json 형변환 즉 얘는 객체타입
	
	let data= JSON.parse(e.data);
	
	//보낸
	if(data.frommid==memberinfo.mid){
		contentbox.innerHTML+=`
				<div class="secontent">
					<div class="date">${data.time}</div>
					<div class="content">${data.msg}</div>
				</div>
		`
	}else{//받은
		contentbox.innerHTML+=
		`
				<div class="tocontent">
					<div><img src="/jspweb/member/pimg/${data.mimg==null ? 'default.webp' : data.formmimg} class="hpimg"></div>
					<div class="rcontent">
						<div class="name">${ data.frommid }</div>
						<div class="contentdate">
							<div class="content">${data.msg}</div>
							<div class="date"> ${data.time}</div>
						</div>
					</div>
					
				</div>
		`	
	}	
	//---------------------스크롤 하단으로 내리기-----------------------
/*	let top =contentbox.scrollTop; //현재 스크롤의 상단 위치 좌표
		console.log(top);
	let height = contentbox.scrollHeight;	//현재 스크롤의 전체 높이 [기본 contentbox height ];
		console.log(height);*/
		
	//스크롤막대의 상단위치를 스크롤막대의 가장아래에 위치로 대입
	contentbox.scrollTop = contentbox.scrollHeight;
}


//5. 서버와 연결이 끊겼을떄[클라이언트 객체가 초기화될때 -> F5, 페이지 전환할때 등등]
function 연결해제(e){
	console.log("---------------------------------------")
	console.log('연결해제')
}

//엔터키를 눌렀을때
function enterkey(){
	//만약에 입력한 키 코드가 13[엔터]이면 메시지전송
	console.log(window.event.keycode)
	if(window.event.keyCode==13){
		보내기();
	}
}





/*
	클라이언트소켓 필드	
	얘네 원래 갖고있음
		onopen		=
		onclose		=
		onmessage 	=
		
		//통신결과
		onmessage=function(e)	//밑에 ajax랑 같은말임

	AJAX 필드
		//통신결과
		success: function(r){}
		success: (r)=>{ }



*/










