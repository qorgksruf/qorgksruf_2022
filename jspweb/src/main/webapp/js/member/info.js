console.log('열림')

console.log(memberinfo );

//회원정보.js : 만약에 로그인이 안되어 있으면 불가능[제어]
if(memberinfo.mid==null){
	alert('로그인하고오세요')
	location.href="/jspweb/member/login.jsp";
}
document.querySelector('.mid').innerHTML=memberinfo.mid;
document.querySelector('.memail').innerHTML=memberinfo.memail;
document.querySelector('.mimg').src=`/jspweb/member/pimg/${ memberinfo.mimg==null ? 'default.webp' : memberinfo.mimg}`
document.querySelector('.mpoint').innerHTML=memberinfo.mpoint;

//회원탈퇴
//function delete(){} //이미 사용중인키워드라 사용불가
function setDelete(){
	console.log('setDelete()함수 열림')
	$.ajax({
		url : "/jspweb/member" , 
		method : "delete" , 
		data : { "mpwd" : document.querySelector('.mpwd').value } ,
		success : (r)=>{	console.log( '통신' ); console.log(r);
			if( r == 'true'){
				alert('회원탈퇴성공');
				location.href="/jspweb/member/logout.jsp"; // 로그아웃 처리 
			}else{ alert('탈퇴할 계정의 비밀번호가 다릅니다.'); }
		}
	})
}

/*
function confirm(){
	prompt('회원의비밀번호를입력홰주세요');
	let mpwd = document.querySelector('.mpwd').value;
		console.log("mpwd"+mpwd);
	if(memberinfo.mpwd==mpwd){
		alert('회원탈퇴ㄹㅇ성공')
		location.href="/jspweb/member/logout.jsp";
	}else{
		alert('다시비밀번호를 확인해주세요')
	}
}*/