console.log('js열림');
getLogin();
function getLogin(){
		$.ajax({
				url:"/jspweb/login",
				method:"get",
				success	: (r)=>{ 
					console.log('통신성공');
					console.log(r);	//Dto1개회원-->r객체1개 회원

					//html 구성
					let html ='';	//html 구성
					if(r==null){	//로그인 안했으면
						
						html+=`<a href="/jspweb/member/signup.jsp">회원가입</a>`;
						html+=`<a href="/jspweb/member/login.jsp">로그인</a>`;
					}else{	//로그인했으면
						if(r.mid=='admin'){//관리자이면
							html+=`<a href="/jspweb/admin/info.jsp">관리자페이지</a>`;
						}	

						html+=`<img src="/jspweb/member/pimg/${r.ming==null ? 'default.webp': r.ming}" class="hpimg">`
						html+=`${r.mid}님 안녕하세요`;
						html+=`<a href="/jspweb/member/logout.jsp">로그아웃</a>`;
					}
					console.log(html);
					document.querySelector(".header").innerHTML =html;
				}		
		})	
}