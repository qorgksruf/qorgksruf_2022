
console.log("memberinfo"+memberinfo);
if(memberinfo.mid==null){
	alert('회원제 기능입니다 로그인후 작성해주세요');
	location.href="/jspweb/member/login.jsp"
}


function bwrite(){
	// 폼가져오기-> 이렇게쓰면 문자열로 가져오게됨 
	let writeForm = document.querySelector('.writeForm')
	console.log("write.js writeForm:::"+ writeForm);
	
	// 폼가져오기2	-> 객체로 가져오게됨
	let writeFormAll = document.querySelectorAll('.writeForm');
	console.log( writeFormAll );
	
	//폼 객체 --> new FormData 클래스 [form 전송객체]
	let writeFormData = new FormData(writeFormAll[0]);
	console.log(writeFormData)
	
	//4.
	$.ajax({
		url:"/jspweb/board/info",
		method:"post",
		data:writeFormData,
		//첨부파일
		contentType: false,
		processData: false,
		success:(r)=>{
			console.log('통신');
			console.log(r);
			if(r=='true'){
					alert('글쓰기성공');
			}else{
				alert('글쓰기실패');
			}
		}
	})
	
}

