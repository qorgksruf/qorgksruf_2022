alert('js열림')

/*
유효성검사 이전에 
	js 정규표현식: 문자의 특정 규칙, 패턴, 집합 표현시 사용되는 언어
		-- 문법
		
			/^	: 정규표현식 시작
			$/	: 정규표현식 끝
			[a-z]: 소문자 a-z 패턴
			[A-Z]: 대문자 A-Z패턴
			[0~9]: 숫자 0~9 패턴
			[가-힣]: 한글 패턴
			{최소길이,최대길이}: 문자열 길이 패턴
			--------
			[a-zA-Z]: 영문 입력 
			
			[a-zA-Z0-9] 영문+숫자 입력
			
			[a-zA-Z0-9가-힣] 영문+숫자+한글 입력 			
			--패턴 검사함수
			정규표현식.test(데이터)	: 패턴이 적합하면 true / 아니면 false
			ex) 
			/^[a-z]$/.test(qwe) --> true
			/^[a-z]$/.test (QWE)  --> false
			
 */

//2.아이디 유효성검사[1.문자체크 2.중복검사]
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
	
	//아이디 중복검사 [js->서블릿->dao 에게 해당 아이디 검색 select ]
		
		$.ajax({
			url:"/jspweb/mconfirm",
			method:"get",
			data:{ "mid" : mid },
			sucess:(r)=>{
				console.log('ajax통신');
				console.log(r)
				if(r=='true'){
					document.querySelector('.idcheckconfirm').innerHTML='사용 중인 아이디입니다';
				}else{
					document.querySelector('.idcheckconfirm').innerHTML='사용 가능한 아이디';
				}
			}
			
		})
	
	}else{	//정규표현식 패턴이 false일때마다
		document.querySelector('.idcheckconfirm').innerHTML = '영소문자+숫자 조합 5~30사이로 입력해주세요'
	}
	
}



//1.회원가입
function signup(){
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
	
	
}