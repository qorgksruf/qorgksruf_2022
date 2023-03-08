alert('js열림')

function signup(){
	console.log('signup함수열림');
	//입력받은 값 모두 가져와서 객체화
	let info={
		mid: document.querySelector(".mid").value,
		mpwd: document.querySelector(".mpwd").value,
		mpwdconfirmed: document.querySelector(".mpwdconfirmed").value,
		memail: document.querySelector(".memail").value,
		mimg: document.querySelector(".mimg").value,
	}
	console.log(info);
	
	//ajax 통신을 이용한 서블릿에게 데이터 보내고 응답받기
	
	$.ajax({
		url : "/jspweb/member", 
		method:"post",
		data:info,
		success: (r)=>{
			console.log('ajax응답');
			console.log(r);
			if(r=='true'){
				location.href="/jspweb/index.jsp";	//해당패이지로 이동
			}else{
				alert('회원가입실패')
			}
		}
		
	})
	
	
}