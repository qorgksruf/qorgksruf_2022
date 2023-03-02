alert('js파일열림')
//js 함수
//function 함수명 (매개변수){실행코드 }

function 예제1(){

	let data = document.querySelector('.inputdata').value;
	console.log(data);
	
	$.ajax({
		url: "http://localhost:8080/jspweb/indextest",	//통신할 서블릿 주소
		method:"post" ,	//HTTP 메소드
		data : {"data" : data},	//데이터보내기 "data"라는 이름으로 위의 입력받은 데이터를 받는다
		sucess : function(result){
			console.log(result);
		}//데이터받기
	});
	
	
	//js --> 서블릿 이동
	//0.$ : jquery 표현식
	//1.ajax 매소드 사용 : $.ajax({ });
	//2.ajax 매개변수 [속성:객채형태]	: { }--> $.ajax({ })
	
	
	//3.속성
		//1.url : 통신할 경로 [서블릿 (클래스)주소: "/jspweb/(/indextest)" ]
		//2.method : http 메소드방식
		//3.data : 통신할떄 보낼 데이터
		//4.success : 통신 후 응답
	
		
		/* 프로젝트명 어쩌구 힘들면 그냥
		1방법 url:"http://localhost:8080/jspweb/indextest"
		2방법 url:"/jspweb/indextest"
		
		/*메소드 : http 메소드방식 
			get
			post
		*/ 
		/*
			data : 통신할때 데이터 보내기 
				js 객체령태 : {매개변수명1:데이터, 매개변수명 2: 데이터ㅏ }
		*/
		/*
			sucess : 통신후 응답 데이터 받기 
				1.sucess : function(매개변수){}
		*/
		
		
	//여기에 속성4가지 대입
	/* $.ajax({
			url:"", 
			method: "",
			data: {매개변수명 : 데이터},
			success : function(result){ 
			
			}	
		});
	*/
	
}
	//documemt :미리 만들어진 DOM 객체	
	//1.queryselector (식별자):tag 1개 -> 변수/객체에 저장
		//documemt.queryselector('.class')
		//documemt.queryselector('#id')
		//documemt.queryselector(.'tagname[name="namename"]')
	//2.queryselectorAll(식별자) : tag 여러개 -? 배열/리스크 에 저장
	
	//queryselector().속성명
		//1.queryselector().value : input ,select ,textarta [div x table x]
		//queryselector().innerHTML: div,span ,td 등