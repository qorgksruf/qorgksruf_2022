console.log('js열림');


let memberinfo=null;

// 로그인한 회원정보 호출 
getLogin();
function getLogin(){
		$.ajax({
				url:"/jspweb/login",
				async:false,// 비동기에서 동기화 변경함
				method:"get",
				success	: (r)=>{ 
					console.log('통신성공');
					console.log(r);	//Dto1개회원-->r객체1개 회원
					memberinfo=r;//응답 결과를 전역변수로 옮기기[왜? 다른함수에서 쓸려고 예를들면 info.js에서 사용하고있음]
					//html 구성
					let html ='';	//html 구성
					if(r.mid==null){	//로그인 안했으면
						
						html+=`<a href="/jspweb/member/signup.jsp">회원가입</a>`;
						html+=`<a href="/jspweb/member/login.jsp">로그인</a>`;
					}else{	//로그인했으면
						html +=`
						<div class="dropdown">
							<button class="hpimghtn" type="button" data-bs-toggle="dropdown">
								<img class="hpimg" src="/jspweb/member/pimg/${r.mimg==null ? 'default.webp': r.mimg}" class="hpimg">
							</button>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="/jspweb/member/info.jsp">내프로필</a></li>
								<li><a class="dropdown-item" href="#">친구목록</a></li>
								<li><a class="dropdown-item" href="/jspweb/member/logout.jsp">로그아웃</a></li>
							</ul>
					</div><!--드룹다운 e  -->
					${r.mid}
					<a href="#">쪽지함</a>
					<a href="${r.mpoint}">포인트</a>					
						`
						if(r.mid=='admin'){//관리자이면
							html+=`<a href="/jspweb/admin/info.jsp">관리자페이지</a>`;
						}	

					}
					console.log(html);
					document.querySelector(".submemu").innerHTML =html;
				}		
		})	
}//end

let 알림용소켓 = null;
if(memberinfo.mid == null){
}else{
	//js실행주체=클라이언트//JAVA = 서버
	//1.JS: [클라이언트소켓 생성]에서
	알림용소켓= new WebSocket('ws://localhost:8080/jspweb/alarm/'+memberinfo.mid )
	//2.클라이언트 소켓내 필드의 이벤트 메소드 대입
	알림용소켓.onopen=(e)=>{
		console.log('알림용 서버소켓에 들어옴');
	}
	알림용소켓.onclose=(e)=>{
		console.log('알림용 서버소켓에 나감');
	}
	알림용소켓.onerror=(e)=>{
		console.log('알림용 서버소켓 오류');
	}
	알림용소켓.onmessage=(e)=>{
		onalarm(e)
	}
}

function onalarm(e){
	
	let msgbox = document.querySelector('.msgbox')
	msgbox.style.bottom="50px";
	
	setTimeout( ()=>{msgbox.style.bottom="-100px";} ,4000)
	
	//여러명이 채팅 요청하면 Dao 메소드 충돌이 발생가능함
		//Dao 메소드에 sysnchronized 키워드 사용
		//스레드1 해당 메소드를 사용하고 있을때[return 전 ]다른 스레드2 해당 메소드에 대기상태
		//멀티스레드:
	getcontent();
}


/*					<!--bs: 드룹다운  -->
					<div class="dropdown">
							<button class="hpimghtn" type="button" data-bs-toggle="dropdown">
								<img class="hpimg" src="/jspweb/member/pimg${r.ming==null ? 'default.webp': r.ming}" class="hpimg">/default.webp">
							</button>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">내프로필</a></li>
								<li><a class="dropdown-item" href="#">친구목록</a></li>
								<li><a class="dropdown-item" href="/jspweb.member/logout.jsp">로그아웃</a></li>
							</ul>
					</div><!--드룹다운 e  -->
					${r.mid}
					<a href="#">쪽지함</a>
					<a href="#">포인트</a>
					
						if(r.mid=='admin'){//관리자이면
							html+=`<a href="/jspweb/admin/info.jsp">관리자페이지</a>`;
						}					
					*/