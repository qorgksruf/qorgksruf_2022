//console.log('view js열림')
console.log(memberinfo);

//로그인이 안되어있으면
if(memberinfo.mid=null){
document.querySelector('.rcontent').disabled=true;
document.querySelector('.rcontent').value='로그인 후 작성가능합니다';
document.querySelector('."rwritebtn"').disabled=true;
}


//현재 보고 있는 게시물 번호
let bno = document.querySelector('.bno').value;

//1.해당게시물 호출
getBoard();
function getBoard(){
	console.log('함수실행')
	console.log("view.js의 bno"+bno);
	
	$.ajax({
		url:"/jspweb/board/info",
		method:"get",
		data: {"type":2,"bno":bno},
		success:(r)=>{
			console.log('통신');
			console.log(r);
			
			let html =``
			
			document.querySelector('.mimg').src=`/jspweb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg}`;
			document.querySelector('.mid').innerHTML = r.mid;
			document.querySelector('.bdate').innerHTML = r.bdate;
			document.querySelector('.bview').innerHTML = r.bview;
			document.querySelector('.bup').innerHTML = r.bup;		
			document.querySelector('.bdown').innerHTML = r.bdown;
			document.querySelector('.btitle').innerHTML=r.btitle;
			document.querySelector('.bcontent').innerHTML=r.bcontent;
			
			if(r.bfile == null){//첨부파일 없을떄

			}else{//첨부파일 있을때
				//html = ` ${r.bfile} <button onclick="bdownload( '${ r.bfile }' )" type="button"> 다운로드 </button> `
				html = `<a href="/jspweb/filedownload?bfile=${ r.bfile }" > 
							<i class="fas fa-download"></i>${ r.bfile } 
						</a>`				
				document.querySelector('.bfile').innerHTML=html;	
			}
			//-----------------------------------------
			//로그인된회원과 작성자가 일치하면 수정,삭제 가능하도록
			if(memberinfo.mid==r.mid){
				console.log(r.mid)
				html=`
				<button onclick="bdelete(${bno}, ${r.cno})" type="button">삭제</button>
				<button onclick="bupdate(${bno})" type="button">수정</button>
				`;
				document.querySelector('.btnbox').innerHTML=html;
			}
			getReplyList();
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

//3.조회수1 좋아요수2 싫어요수3 
bIncrease(1);	//해당스크립트가 열리는 순간 조회수증가
function bIncrease(type){
	//현재 게시물의 번호[증가할대상]
	let bno = document.querySelector('.bno').innerHTML; 
	console.log("bno"+bno);
	$.ajax({
		url:"/jspweb/board/view",
		method:"get",
		data:{"type":type ,"bno":bno },
		success:(r)=>{
			console.log('통신');
			console.log(r);
			getBoard();//새로고침
		}
	})
}

// 삭제
function bdelete(bno,cno){
	$.ajax({
		url:"/jspweb/board/info",
		method:"delete",
		data:{"bno":bno, "type":1},
		success:(r)=>{
			console.log('통신');
			console.log(r);
			if(r=='true'){
				alert('삭제성공')
				location.href="/jspweb/board/list.jsp?cno="+cno;
			}else{
				alert('삭제실패')
			}
			
		}
	})	
}
// 수정 페이지로 이동
function bupdate(bno){
	location.href="/jspweb/board/update.jsp?bno="+bno;
}


//6.댓글쓰기 rcontent
function rwrite(){
	console.log("rwrite함수열림")
	$.ajax({
		url:"/jspweb/board/Reply",
		method:"post",
		data:{
			"type":1,	//1.상위댓글 2.하위댓글
			"bno":bno, "rcontent":document.querySelector('.rcontent').value},
		success:(r)=>{
			console.log('통신');
			console.log(r);
			if(r=='true'){
				alert('댓글작성성공')
				document.querySelector('.rcontent').value='';
				
				//특정 div만 새로고침[랜더링]
				//$(".replylistbox").load(location.href+'.replylistbox');
				//현재페이지 새로고침[랜더링]
				location.reload();
				
			}else{
				alert('댓글작성실패')
			}
			
		}
	})	
}	
//	댓글출력
function getReplyList(){
	console.log("getReplyList();열림")
		$.ajax({
		url:"/jspweb/board/Reply",
		method:"get",
		data:{ "type":1,"bno":bno },
		success:(r)=>{
			console.log('통신');
			console.log(r);
			
			let html='';
			r.forEach((o,i)=>{
				html+=`
				<div>
					<span>${o.mimg}</span>
					<span>${o.mid}</span>
					<span>${o.rdate}</span>
					<span>${o.rcontent}</span>
					<button onclick="rereplyview(${o.rno})" type="button">답글보기</button>
					<div class="rereplybox${o.rno}"></div>
				</div>
				
				`
			})
			document.querySelector('.replylistbox').innerHTML=html;
		}	
		
			
		})

}//end


//하위 댓글 구역표시
function rereplyview(rno){

		$.ajax({
		url:"/jspweb/board/Reply",
		async: 'false',
		method:"get",
		data:{ "type":2, "rindex":rno, "bno":bno},
		success:(r)=>{
			console.log('통신');
			console.log(r);
			
			let html='';
			r.forEach((o)=>{
				html+=`-----------------------------------
				<div>
					<span>${o.mimg}</span>
					<span>${o.mid}</span>
					<span>${o.rdate}</span>
					<span>${o.rcontent}</span>
				</div>
								
				`

			});
		 html+=`
			<textarea class="rrcontent${rno}"> </textarea>
			<button type="type" onclick="rrwrite(${rno})">답글작성</button>	`
			
			document.querySelector('.rereplybox'+rno).innerHTML=html;
		
		}//success end
	})//ajax e	


	
}//end
//하위 댓글쓰기
function rrwrite(rno){
	//bno,mno,rrcontent,rindex(상위댓글번호)
		$.ajax({
		url:"/jspweb/board/Reply",
		method:"post",
		data:{"type":2, "bno":bno, "rindex":rno , 
			"rcontent":document.querySelector('.rrcontent'+rno).value},
		success:(r)=>{
			console.log('통신');
			console.log(r);
			alert('대댓글출력');
			location.reload();
			
		}
	})	
	
}
	


	

