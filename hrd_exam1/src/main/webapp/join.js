function join(){

	console.log("join")
	//유효성검사
	if(document.joinform.custno.value==""){
		alert('custno 입력해주세요')
		document.joinform.custno.focus(); 
		return false;
	}	
	if(document.joinform.custname.value==""){
		alert('회원성명를 입력해주세요')
		document.joinform.custname.focus(); 
		return false;
	}
	if(document.joinform.phone.value==""){
		alert('회원전화 입력해주세요')
		document.joinform.phone.focus(); 
		return false;
	}
		
	if(document.joinform.address.value==""){
		alert('address 입력해주세요')
		document.joinform.address.focus(); 
		return false;
	}
	
	if(document.joinform.joindate.value==""){
		alert('address 입력해주세요')
		document.joinform.joindate.focus(); 
		return false;
	}
		
	if(document.joinform.grade.value==""){
		alert('grade 입력해주세요')
		document.joinform.grade.focus(); 
		return false;
	}
	
	if(document.joinform.city.value==""){
		alert('city 입력해주세요')
		document.joinform.city.focus(); 
		return false;
	}	

	//폼 전송
	document.joinform.submit();		
	alert('회원등록이 완료되었습니다')
	
}