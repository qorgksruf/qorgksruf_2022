console.log('1.열림')

//*함수 밖에 만드는 이유: 전역변수: 모든 함수에서 동일한 메모리를 사용하는 것 
let contents=[ ]
onprint()
	

//1. 글 등록 함수
function onwrite(){
	console.log('2.onwrite함수 열림')

//1.입력받은 4개 데이터를 하나의 객체로 선언	
//(3)
 let info= {	//let 객체명(아무거나)={속성명:데이터, 속성명:데이터}
 	//(2)		//(1)
	bwriter: document.querySelector('.bwriter').value,
	bpassword:document.querySelector('.bpassword').value,
	btitle: document.querySelector('.btitle').value,
	bcontent:document.querySelector('.bcontent').value,
	bdate : new Date() ,	//현재 날짜와 시간을 반환해주는 함수
	bview: 0	//조회수
	}
	console.log(info)//객체 정보 출력시 연결연산자 금지
	
	//2.유횽성검사	//객체명. 속성명
		//1. 입력받은 데이터 길이 체크
	if(info.bwriter.length<=0	|| info.bpassword.length<=0 ||
	   info.btitle.length <=0	|| info.bcontent.length<=0 ){
		alert('작성이 안된 구역이 있습니다. 작성해주세요');
		return; //함수종료!!!! 
	}
	
	//3. 배열에 저장-> 맨 위 전역변수부터 만들고
	contents.push(info)
	alert('글 등록성공')
	onprint()
	console.log( contents)
	//초기화
	document.querySelector('.bwriter').value=''
	document.querySelector('.bpassword').value=''
	document.querySelector('.btitle').value=''
	document.querySelector('.bcontent').value=''
	
}

//2.
function onprint(){	//언제쓸래? // 1.js 열렸을때 2. 글 등록했을때 3. 글삭제 4.글수정
	console.log('onprint 열림')
	//1. 기본 html 구성
	let html=`<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>`
	//2. 내용 html 구성
	for(let i=0; i<contents.length; i++){
		
		
		let date= contents[i].bdate.getFullYear() + '년'+
				 (contents[i].bdate.getMonth()+1) + '월'+
				  contents[i].bdate.getDay() + '일'+	 
				  contents[i].bdate.getHours() + ':'+	
				  contents[i].bdate.getMinutes() + ':'+	
				  contents[i].bdate.getSeconds() 
				
		html +=`<tr onclick= "onview( ${i})">
				<th>${i+1}</th>
				<th>${contents[i].btitle}</th>
				<th>${contents[i].bwriter}</th>
				<th>${ date }</th>
				<ht>${ contents[i].bview }</th>
			</tr>`
		
	}
	//3. 마크업에 html 대입
	document.querySelector('.boardtable').innerHTML=html;
}


//3. 글 보기함수
function onview(i){	//실행조건 1.글목록에서 해당 줄을 클릭했을떄 
	contents[i].bview += 1; onprint()
	console.log(i)
	let html=`<div> 제목:${ contents[i].btitle} </div>
			  <div> 내용:${ contents[i].bcontents} </div>
			  <div> 작성자:${ contents[i].bwriter} </div>
			  <div> <button onclick="onDelete(${i})"> 삭제</button>	</div>
			`
		document.querySelector('.viewbox').innerHTML=html;
}


// 글 삭제 함수
function onDelete( i ){ // f s 
	let password = prompt('비밀번호:')
	if( password==contents[i].bpassword){
		alert('삭제성공')
		contents.splice( i, 1)
		onprint();
		document.querySelector('.viewbox').innerHTML='';	//글 삭제시 공백처리함
	}else{
	alert('삭제실패')
	
	
	}
	
} 


