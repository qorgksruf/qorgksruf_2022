console.log('열림')

if(memberinfo.mid==null){
	alert('로그인하고오세요');
	location.href="/jspweb/member/login.jsp"
}

document.querySelector('.mid').innerHTML = memberinfo.mid
	console.log(memberinfo.mid)
document.querySelectorAll('.memail').value = memberinfo.memail
document.querySelector('.mimg').src 
		= `/jspweb/member/pimg/${memberinfo.mimg == null ? 'default.webp' :  memberInfo.mimg }`
	
function setUpdate(){
	//첨부파일이 있을때 전송하는법
	let updateForm = document.querySelectorAll('.updateForm')[0];
	let updateFormDate = new FormData(updateForm);
	//폼에 데이터 추가
			//1. 체크박스 체크여부 확인
			let defaultimg = document.querySelector('.defaultimg').checked
			updateFormDate.set("defaultimg", defaultimg );

	
	$.ajax({
		url:"/jspweb/member",
		method:"put",
		data:updateFormDate,
		contentType: false,
		processData: false,
		success:(r)=>{
			console.log('통신');
			console.log(r);
			if(r=='true'){
				alert('수정성공 다시 로그인')
				location.href="/jspweb/member/logout.jsp"
			}else{
				alert('수정실패 기존 비밀번호가 틀렸습니다');
				
			}
		}
	})
}
	
/*	
	let info={
		'mpwd':document.querySelector('.mpwd').value,
		'newmpwd':document.querySelector('.newmpwd').value,
		'memail':document.querySelector('.memail').value
	};console.log(info);
	*/