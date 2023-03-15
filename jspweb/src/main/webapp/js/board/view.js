console.log('view js열림')

getBoard();
function getBoard(){
	console.log('함수실행')
	
	let bno = document.querySelector('.bno').innerHTML;
	console.log("view.js의 bno"+bno);
	
	$.ajax({
		url:"/jspweb/board/info",
		method:"get",
		data: {"type":2,"bno":bno},
		success:(r)=>{
			console.log('통신');
			console.log(r);
			
			let html =`${r.bdate} /
					   ${r.bview} /
					   ${r.bup} /
					   ${r.bdown} /
			`
			document.querySelector('.infobox').innerHTML=html;
			document.querySelector('.pimgbox').innerHTML=r.mid;
			document.querySelector('.btitle').innerHTML=r.btitle;
			document.querySelector('.bcontent').innerHTML=r.bcontent;
			
			if(r.bfile == null){//첨부파일 없을떄
				document.querySelector('.bfile').innerHTML='첨부파일없음';
			}else{//첨부파일 있을때
				html = ` ${r.bfile} <button onclick="bdownload( '${ r.bfile }' )" type="button"> 다운로드 </button> `
				document.querySelector('.bfile').innerHTML=html;	
			}
			
		}
	})//ajax e
	
}

// 다운로드[다운로드할 파일명을 인수로 받기]
function bdownload(bfile){
	console.log("선택한파일명"+ bfile);
/*	$.ajax({
		url:"/jspweb/filedownload",
		method:"get",
		data:{"bfile":bfile },
		success:(r)=>{
			console.log('통신');
			console.log(r);
		}
		
	})//ajax*/
	
	location.href="/jspweb/filedownload?bfile="+bfile;
}



/*
	1.onclick = 스크립트 작성가능
		1.download(짱구4.jpg)	: . 파일확장자가 아닌 . 접근연산자로 사용됨
		2.download('짱구4.jpg') : .접근 연산자들 파일확장자 구분기호
		
	<button onclick="bdownload( ${ r.bfile } )" type="type"> 
	<button onclick="bdownload( ${ 맹구.bfile } )" type="type">  => 자바에선 . 인식못함 
	
	<button onclick="bdownload( '${ r.bfile }' )" type="type">  => 그래서 이렇게써야함
	
	2.전송방법
		HTML	:	1.<form>		2.<a href="">
		js		:	1.location.href=""
		JQUERY	:	1.$.ajax({ })
		servlet	:	
				1.response.getWriter.print(문자데이터);
				2.response.sendRedirect('경로')
*/

