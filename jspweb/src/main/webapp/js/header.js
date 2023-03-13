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