console.log( '글쓰기js 실행')

let 게시물임시저장소=[]

function board_write(){
	//1. 입력받은 데이터를 객체화한다
	let board = {
		btitle : document.querySelector('.btitle').value,
		bcontent : document.querySelector('.bcontent').value,
		bwriter : document.querySelector('.bwriter').value,
		bpassword : document.querySelector('.bpassword').value
		//첨부파일 x
	}; console.log( board )
	

		
	게시물임시저장소.push( board ); console.log( 게시물임시저장소 )
	//3. 결과에 따른 이벤트
	let result =true; //java로부터 전송결과
	if( result){alert('글쓰기 성공'); location.href = 'list.html';}
	else{ alert('글쓰기 실패');}
}
		/*
		페이지 전환 함수 js 함수
		*/


/*썸머노트 api실행*/
$(document).ready(function() {
  $('#summernote').summernote( { 
	  
	  height : 300 , 
	  lang: 'ko-KR'  
	  
	});
});
/*
	썸머노트 기능 속성 
	$('#summernote').summernote( { 속성명 : 값 , 속성명 :값 } )
		1. height : 		: 	높이
		2. lang: 'ko-KR'  	:	한글버전 [ <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"> ]

*/