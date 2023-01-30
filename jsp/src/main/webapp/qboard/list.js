/**
 * 
 */
board_print( null,null);

function board_print( keyword , key ){

	if( keyword == null && key == null){// 1. 검색이 없는경우
		/*alert('검색 없는 게시물 출력')*/
		// JAVA에게 검색[조건] 이 없는 게시물들을 요청 
	}else{
		/*alert('검색이 있는 게시물 출력')*/
		// JAVA에게 keyword , key 보내서 검색[조건] 이 있는 게시물들을 요청
	}
	
	let boardlist = [
		  { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , question : '완료' , deadline  : '2023-01-30'  } , 
		  { no : 4 , title : '안녕하세요B' , writer : '강호동', date : '2023-01-27' , view:123 ,  question  :'완료' ,deadline  : '2023-01-30'},  
		  { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , question : '완료' , deadline : '2023-01-25'  } , 
		  { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , question : '완료' ,deadline : '2023-01-25'  } , 
		  { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , question : '완료' ,deadline : '2023-01-25'  } 
	]
	let html=''	
	
	for( let i = 0 ; i<boardlist.length ; i++ ){
		html +=`<tr>
						<td>${ boardlist[i].no }</td>
						<td> <a href="/jsp/qboard/view.html">${ boardlist[i].title }</a></td>
						<td>${ boardlist[i].writer }</td><td>${ boardlist[i].date }</td>
						<td>${ boardlist[i].view }</td>	
						<td>${ boardlist[i].question }</td>	
						<td>${ boardlist[i].deadline }</td>	
				</tr>`
	} 
	document.querySelector('.boardlist').innerHTML=html;
}	
// 2. 검색 버튼을 클릭했을때 검색 	
	document.querySelector('.searbtn').addEventListener('click' , (e) =>{
		console.log('검색 클릭')
		// 1. 키워드
		let keyword=document.querySelector('.keyword').value
		// 2. 검색어 
		let key=document.querySelector('.key').value
		
		console.log( 'keyword:'+ keyword); console.log('key:'+ key);
		// 3. 유효성검사 생략 
		// 4. 게시물출력 함수에게 키워드,검색어 전달 [ 백엔드 ]		
		board_print( keyword, key)
	} )

//문의 버튼 함수	//js열렸을때 // 요청 들어올때 /
/*question_in();	
function question_in(){
	console.log( '버튼확인' );
	
	
}document.querySelector('.table text-center').innerHTML = html;



	orderList.forEach( ( order , i) => { // 주문리스트 회전/반복
		order.items.forEach( ( burger , j ) => {	// 각 주문마다의 버거리스트 회전/반복 
			let time = order.time.getHours()+':'+order.time.getMinutes();
			if( order.state == false ){ // 만약에 주문완료 이면 / 주문완료시간 존재 하면 완료시간 같이 표기 +=
				time += ' / ' + order.complete.getHours()+':'+order.complete.getMinutes();
			}
			html += `<tr>
						<th> ${ order.no } </th>
						<th> ${ burger.name } </th>
						<th> ${ order.state ? "주문요청" : "주문완료" } </th>
						<th> ${ time }</th>
						<th>
							${	order.state ? 
								'<button onclick="onComplete( '+i+' )">주문완료</button>' : ''
							}
						</th>
					<tr>`
		})
	})

}
// 6. 주문상태 변경 [ state 상태 / complete 완료시간 ]
function onComplete( i ){ console.log( i );
	orderList[i].state = false; // 주문완료 
	orderList[i].complete = new Date(); // 현재시간 대입 [ 주문완료 시간 ]
	order_print(); // 주문현황테이블 렌더링
}
	*/