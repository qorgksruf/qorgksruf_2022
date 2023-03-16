console.log('js 열림')

//*pageObject :현재 페이지,검색,전송타입 보관된 객체
let pageObject={
	page:1,	
	key:"",
	keyword:"",
	type:1,//1.전체출력 2.개별출력
	cno:document.querySelector('.cno').value, //카테고리 번호
	listsize: 3
}

// -- 카테고리 제목 넣어주기
let cnameHTML="";
if(pageObject.cno==1){cnameHTML='공지사항';}
if(pageObject.cno==2){cnameHTML='커뮤니티';}
if(pageObject.cno==3){cnameHTML='QNA';}
if(pageObject.cno==4){cnameHTML='노하우';}
document.querySelector('.cname').innerHTML=cnameHTML;

//게시물 호출
getBoardList(1); //js 열릴때 페이지1 기본값 설정
function getBoardList(page){
	//해당 함수로부터 페이징번호 받기 = page
	console.log('해당페이지를주세요'+page);
	pageObject.page = page;//인수로 받은 현재페이지를 객체에 대입
	console.log(pageObject)
	$.ajax({
		url:"/jspweb/board/info",
		method:"get",
		data: pageObject , //1.전체출력 2.개별출력
		success:(r)=>{
			console.log('통신');
			console.log(r);
			//-------------------------테이블출력--------------------------------//
			let html=`
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일/th>
					<th>조회수</th>
					<th>좋아요</th>
					<th>싫어요</th>
				</tr>
			`
			 r.boardList.forEach((o,i )=>{	 
				 html+=`
				<tr>
					<td>${o.bno}</td>
					<td><a href="/jspweb/js/board/view.jsp?bno=${o.bno}">${o.btitle}</a></td>
					<td>${o.mid}</td>
					<td>${o.bdate}/td>
					<td>${o.bview}</td>
					<td>${o.bup}</td>
					<td>${o.bdown}</td>
				</tr>				 
				 `
			 })
			 document.querySelector('.boardtable').innerHTML=html;
			 //-------------------페이징 버튼 출력----------------------------//
			
			html='';//기존에 들어있던 내용 제거
			//이전[만약에 이전 페이지가 1이하 이면 이전페이지 없음 ]
				html+=page <= 1 ?
					`<button onclick="getBoardList(${ page })" type="button"> 이전 </button>`
					:
					` <button onclick="getBoardList(${ page-1 })" type="button"> 이전 </button> `
							
			
			//페이징 번호 버튼 들
			for(let i=r.startbtn;  i<=r.endbtn; i++){	//시작번호버튼 부터 마지막 버튼번호까지 버튼 생성
				
				html+=`
					<button onclick="getBoardList(${i})" type="button">${i}</button>
				`
			}
			//다음
			html += page >= r.totalpage ?
					`<button onclick="getBoardList(${ page })" type="button"> 다음 </button>`
					:
					`<button onclick="getBoardList(${ page+1 })" type="button"> 다음 </button>`
			
			
			document.querySelector('.pagebox').innerHTML=html;
			//게시물수 출력
			document.querySelector('.seachcount').innerHTML=`게시물 수: ${r.totalsize} `
		}//success end
		
	})//ajax e
	
}//method e

function getsearch(){
	console.log("onsearch()함수열림")
	//입력받은 데이터를 전역변수 필드에 대입
	pageObject.key = document.querySelector('.key').value
	pageObject.keyword =document.querySelector('.keyword').value
	getBoardList(1);
}


/*
	- 클릭한pk[식별자] 이동하는 경우의수
		1.HTTP get메소드 방식의 a테그 이용한 PK 이동
			<a href="/jspweb/board/view.jsp?변수명=데이터>
			<a href="/jspweb/board/view.jsp?변수명=데이터&>
*/


function setsearch(){
	pageObject.key='';//검색 없애기
	pageObject.keyword='';
	getBoardList(1);//재호출
}

//4.
function setlistsize(){
	//1.select 에서 선택된 값 가져오기
	let listsize=
			document.querySelector('.listsize').value;
		console.log(listsize);	
	//2.pageObject 필드에 대입	
	pageObject.listsize=listsize;
	
	getBoardList(1);	//재호출
}
