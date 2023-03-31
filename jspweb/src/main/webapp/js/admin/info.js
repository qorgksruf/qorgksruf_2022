
//Obect.keys(객체명): 객체내 모든 필드명/키 배열로 호출
//해당 객체의 값만 호출/추출
	//Obect.value(객체명): 객체내 모든 데이터를 배열로 추출
 const ctx = document.getElementById('myChart');
$.get("/jspweb/point",(r)=>{
	console.log(r);	
	console.log(Object.keys(r));
	console.log(Object.values(r));


  new Chart(ctx, {
    type: 'bar',//얘는 차트모양 bar:막대차트, line: 선 차트
    data: {
      labels:Object.keys(r),//가로축//날짜필드
      datasets: [
		 {
        label: '포인트충전내역',
        data: Object.values(r),//해당항목의 데이터//데이터값
        borderWidth: 1 // 1은 걍 깔끔함
      
      },

      ]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }

	})	
})	




//---------------------------chart.js 차트-----------------------------
	//new Chart('dom객체',{차트옵션} )
	//{type: '차트이름',data:{차트에 표시할 데이터},options:{차트옵션} }
		//labels: 가로축
	




//*pageObject :현재 페이지,검색,전송타입 보관된 객체
let pageObject={
	page:1,	
	key:"",
	keyword:"",
	type:1,//1.전체출력 2.개별출력
	listsize: 3
}


getmemberList(1);
function getmemberList(page){
	console.log('해당페이지를 주세요'+page)
	pageObject.page=page;
	console.log(pageObject)
	$.ajax({
		url : "/jspweb/member", 
		method:"get",
		data:pageObject,	//전체출력 //개별출력
		success: (r)=>{
			console.log('ajax응답');
			console.log(r);// 응답 결과 데이터 확인 
			// 1. 응답데이터 처리 
				// 1. 테이블 헤더 구성 
				let html = `<tr>				
									<th width="10%"> 번호 </th>
									<th width="10%"> 프로필 </th>
									<th width="10%"> 아이디 </th>
									<th width="10%"> 이메일주소</th>
									<th width="10%"> 비고 </th>
							</tr>`
				r.memberList.forEach((o,i)=>{
					//만약에 회원의 mimg 프로필이미지가 null이면 기본프로필 사용 아니면 mimg사용
					
					html +=`						
						<tr>
							<td> ${o.mno} </td>
							<td><img src="/jspweb/member/pimg/${o.mimg == null ? 'default.webp' : o.mimg}" width="100%"> </td>
							<td>${o.mid} </td>
							<td> ${o.memail}</td>
							<td> </td>
						</tr>`

				});
					// 3. 구성된html를 table 대입 
				document.querySelector('.mListTable').innerHTML = html;
				//---------------출력----------------------//
				html='';	//기존에 들어있던 내용제거
				html += `<button type="button" onclick="getMemberList(${1})"> << </button>` // 맨 앞으로 가는 버튼 ( 있어도되고 없어도되고 )
				html+=page <= 1 ?
					`<button onclick="getMemberList(${page})"type="button">이전</button>`
					:
					` <button onclick="getMemberList(${ page-1 })" type="button"> 이전 </button> `
				
				//페이징 번호 버튼 틀
				for(let i=r.startbtn; i<r.endbtn; i++){	//시작번호버튼부터 마지막버튼번호까지 버튼생성
				
						html += `<button type="button" onclick="getMemberList(${ i })"> ${ i } </button>`	
				}
				
				//다음
				html +=page>=r.totalpage ?
						`<button onclick="getMemberList(${ page })" type="button"> 다음 </button>`
						:
						`<button onclick="getMemberList(${ page+1 })" type="button"> 다음 </button>`
			
				document.querySelector('.pagebox').innerHTML=html;
				
				document.querySelector('.seachcount').innerHTML=`게시물수:${r.totalsize}`
		}
		
	})//ajax e	
}


function getsearch(){
	console.log("검색버튼 열림확인할것")
	pageObject.key=document.querySelector('.key').value;
	pageObject.keyword=document.querySelector('.keyword').value;

	getmemberList(1);
}


function setsearch(){
	console.log( 'allboard() 실행' );
	pageObject.key ='';
	pageObject.keyword='';
	getmemberList(1);
	
}



