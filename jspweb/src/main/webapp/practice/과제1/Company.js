

//회원탈퇴
//function delete(){} //이미 사용중인키워드라 사용불가
function setbye(){
	console.log('setDelete()함수 열림')
	$.ajax({
		url : "/jspweb/company" , 
		method : "get" , 
		data : { 
				"cname": document.querySelector('.cname').value,
				"cedate" : document.querySelector('.cedate').value ,	
				"cecontent" : document.querySelector('.cecontent').value } ,
				 
		success : (r)=>{	console.log( '통신' ); console.log(r);
			if( r == 'true'){
				alert('사표처리되었습니다');
			/*	location.href="/jspweb/practice/Company.jsp"; // 로그아웃 처리 */
			}else{ alert('사표처리불가합니다.'); }
		}
	})
}





//첨부파일
function premimg( object ){
	console.log( '첨부파일 바뀜'+object );
	console.log( object.files[0] );	
	console.log( document.querySelector('.mimg').files[0] )
	// 1. JS 파일클래스 선언  
	let file = new FileReader();	
	file.readAsDataURL( object.files[0] )	
	file.onload = (e)=>{ 
		console.log( e.target.result )	
		document.querySelector('.premimg').src = e.target.result;
	}
}


//회원등록
function getbtn(){
	console.log('등록버튼열림')
	let regi = document.querySelectorAll('.regi')[0];
			
	let regiData = new FormData(regi);
		console.log(regiData);
	
	$.ajax({
		url : "/jspweb/company",				// 서블릿 주소 
		method : "post",					// 첨부파일은 무조건 post/put
		data : regiData , // FormData 객체 전송 
		// 첨부파일 있을때 추가되는 속성 
		contentType : false ,			
		processData : false ,			
		success : (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				memberinfo=r;
				alert('등록성공')
				
			}else{ alert('회원가입실패') }
		}
	})	
	 
}