alert('js열림')

//첨부파일 이미지 미리보기	[업로드와 상관없음]
	//정책: 사용자[클라이언트js]에 운영체제[폴더경로] 접근불가
function premimg(object){ // 해당 함수를 실행시킨 태그 객체
	console.log('첨부파일바뀜'+object);
	// 1.js 파일 클래스 선언
	console.log(object.files[0]);	//현재 이벤트를 실행한  input의 등록한 파일명  호출
	//goekd class의 input의 등록한 파일명 호출
	console.log(document.querySelector('.mimg').files[0])
	
	// 그냥 이 세줄로 파일 대입 가능하다고 생각하삼 js파일클래스 선언
	let file = new FileReader();	//파일 읽기 클래스
	//2.해당 첨부된 파일 읽어오기(file.readAsDataURL(첨부파일)[0] : 첨부파일1개 )
	file.readAsDataURL(object.files[0])	//해당 파일 읽어오기
	//3.읽어온 파일 꺼내기 바이트
	file.onload = (e)=>{
		console.log(e.target.result)
		//4.이미지 태그에 대입
		document.querySelector('.premimg').src =e.target.result;
	}
}


/*
유효성검사 이전에 
	js 정규표현식: 문자의 특정 규칙, 패턴, 집합 표현시 사용되는 언어
		-- 문법
		
			/^	: 정규표현식 시작 //구글링: 회원가입 정규표현식 이런식으로하면 보임
			$/	: 정규표현식 끝
			[a-z]: 소문자 a-z 패턴
			[A-Z]: 대문자 A-Z패턴
			[0~9]: 숫자 0~9 패턴
			[가-힣]: 한글 패턴
			{최소길이,최대길이}: 문자열 길이 패턴
			+: 앞에 있는 패턴 1 개 이상반복
			
			--------
			[a-zA-Z]: 영문 입력 
			
			[a-zA-Z0-9] 영문+숫자 입력
			
			[a-zA-Z0-9가-힣] 영문+숫자+한글 입력 	
				(?=.*[패턴문자])	: 해당 패턴문자가 한개 이상 입력
			(?=.*[a-z]): 소문자 한개 이상 
			(?=.*[A-z]): 대문자 한개 이상
			(?=.*[0-9]): 숫자 한개 이상 입력
			(?=.*[!@#$%^&*]): 해당 하는 특수문자 한개 이상 입력
				
				/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
				--> 영대문자1개+ 영소문자1개+ 숫자1개+특정특수문자 1개 필수로 갖는 5~20글 사이  
					
			--패턴 검사함수
			정규표현식.test(데이터)	: 패턴이 적합하면 true / 아니면 false
			ex) 
			/^[a-z]$/.test(qwe) --> true
			/^[a-z]$/.test (QWE)  --> false
			
			
			
 */
//idcheckconfirm span 모두 가져오기 -> 여러개의 span이 배열/리스트 객체에 대입 
let idcheckconfirm = document.querySelectorAll('.idcheckconfirm')


//2.아이디 유효성검사[1.문자 패턴체크 2.중복검사]
function idcheck(){	//onkeuup : 키 누륵도 때었을때
	console.log('입력중');
	//1.입력할때마다 입력값 가져오기
	let mid = document.querySelector('.mid').value;
	console.log(mid);
	//2.정규표현식[영문(대소문자)+숫자 길이 5~30글자 ]
	let midj = /^[a-z0-9]{5,30}$/
	//3.정규표현식 검사
	console.log(midj.test(mid)) 
	if(midj.test(mid)){	//정규표현식 패턴이 true이면
	
		console.log("mid ::: " + mid)
	
	//아이디 중복검사 [js->서블릿->dao 에게 해당 아이디 검색 select ]
		
		$.ajax({
			url:"/jspweb/mconfirm",
			method:"get",
			data:{ "mid" : mid },
			success:(r)=>{
				console.log("ajax통신");
				console.log(r)
				if(r=="true"){
					idcheckconfirm[0].innerHTML='사용 중인 아이디입니다';
				}else{
					idcheckconfirm[0].innerHTML='O';
				}
			}
			
		})

	}else{	//정규표현식 패턴이 false일때마다
		idcheckconfirm[0].innerHTML = '영소문자+숫자 조합 5~30사이로 입력해주세요'
	}
	
}



//1.회원가입
function signup(){
	//유효성검사에 대한 체크
	let count =0;
	for(let i=0; i<idcheckconfirm.length; i++){
		if(idcheckconfirm[i].innerHTML =='O'){
			count++
		}
	}
	if(count != 3){
		alert('정상적으로 입력되지 않은 데이터가 있습니다');
		return;
	}
	
	console.log('signup함수열림');
	// 1.[첨부파일있을때] html 에 file input 직접적으로 조작 불가능
		//form 객체 가져오기
	let signupForm = document.querySelectorAll('.signupForm')[0];	//첫번째 form 가져오기
		//2.form 안에 있는 data 객체 호출
	let signupFormData = new FormData(signupForm);
		console.log(signupFormData);
	//ajax 통신을 이용한 서블릿에게 데이터 보내고 응답받기

	
	$.ajax({
		url : "/jspweb/member",			//서블릿주소 
		method:"post",	//첨부파일은 무조건  post 혹은 put 임 
		data:signupFormData,
		//첨부파일 있을때 추가되는 속성
		contentType: false,		//true [문자열 전송],매개변수형식의 문자열타입[기본값]
									//form-urlencoded 타입으로 전송
								//false: 해제
								//multipart/form형식으로 전송
		processData: false,		//false
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
} //end
	
	//입력받은 값 모두 가져와서 객체화
	// 1. 첨부파일 없을때 입력받은 값 모두 가져와서 객체화
/*	let info={
		mid: document.querySelector(".mid").value,
		mpwd: document.querySelector(".mpwd").value,
		mpwdconfirmed: document.querySelector(".mpwdconfirmed").value,
		memail: document.querySelector(".memail").value,
		mimg: document.querySelector(".mimg").value,
	}
	console.log(info);
*/	
/*	$.ajax({
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
		
	})*/




//비밀번호 유효성검사
function pwdcheck(){
	console.log('비번유효성')
	//입력받은 값 가져오기
	let mpwd= document.querySelector('.mpwd').value;
	console.log('mpwd:'+mpwd)
	//정규표현식: 영대소문자 + 숫자 조합 5~20글자
	let mpwdJ=/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/	//정규표현식
	console.log(mpwdJ.test(mpwd))
	if(mpwdJ.test(mpwd)){
		idcheckconfirm[1].innerHTML ='O';
		pwdconformcheck();
	}else{
		idcheckconfirm[1].innerHTML= '영대소문자+숫자 조합 5~20'
	}
}

//비번확인 유효성
function pwdconformcheck(){
	console.log('비번확인유효성')
	let mpwd= document.querySelector('.mpwd').value;	//위에 비밀번호도 가져온다 
	let mpwdconfirmed = document.querySelector('.mpwdconfirmed').value;	//비밀번호 확인과의 동일성 체크를 위해
		console.log('mpwdconfirmed')
	let mpwdJ=/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	//제어 
	if(mpwdJ.test(mpwdconfirmed) ){
		//두 비밀번호간의 동일성 체크 [두 비밀번호가 서로 다르면]
		if(mpwd!= mpwdconfirmed){
			idcheckconfirm[1].innerHTML ='두 비밀번호가 일치하지 않습니다'
		}else{//같으면
			idcheckconfirm[1].innerHTML ='O'
		}
	}else{//틀리면
		idcheckconfirm[1].innerHTML ='영대소문자+ 숫자 조합 5~20글자'
	}
}//비밀번호확인함수 e


//이메일체크
function emailcheck(){
		console.log('emailcheck()함수 열림')
	let memail = document.querySelector('.memail').value;
		console.log('memail:'+memail);
	let memailj =/^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
		console.log(memailj.test(memail) );
		if(memailj.test(memail)){
			idcheckconfirm[2].innerHTML ='O'
		}else{
			idcheckconfirm[2].innerHTML ='이메일 형식으로 입력해주세요'
		}

		//아이디구역
		//[a-zA-Z0-9_]			:영문+숫자
		// [a-zA-Z0-9_-]		:영문+숫자+_+-
		//+@					:아이디와 도메인 사이의  @ 
		//도메인구역
		//[a-zA-Z0-9-]			:영문+숫자+ -		naver
		//+\.					: 도메인 중간에 .	.
		//[a-zA-Z0-9-]			: 영문+숫자+ -		com	
		//+						: .1개 이상		naver.co.kr

}



	
