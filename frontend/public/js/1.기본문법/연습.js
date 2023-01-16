console.log('js실행합니다')


let boardArray=[] //큰 아파트 만듦

function 작성(){
	let 작성자 = document.querySelector('.작성자').value;
	let 내용= document.querySelector('.내용').value;
	let 비밀번호=document.querySelector('.비밀번호').value;
	
	let board = { writer: 작성자, content: 내용, password: 비밀번호}
	
	boardArray.push(board)
	출력();
}


function 삭제(i){
	
	let 비밀번호= prompt('게시물 비밀번호입력: ')
	
	if(비밀번호==boardArray[i].password){
		boardArray.splice(i,1);
		alert('게시물 삭제 성공');
		출력();
		
	}else{ alert('비밀번호가 일치하지 않습니다')}
	
	
}

function 수정(i){
		
		let	비밀번호=prompt('수정확인을위한 비밀번호입력:')
		
		if(비밀번호==boardArray[i].password){
			
			let 새로운내용=prompt('새로운 내용을 입력하세요')
			 boardArray[i].content=새로운내용;
			 alert('수정성공');
			 출력();
 
		}else{
			alert('비밀번호를 다시 입력하세요')
		}
	
	
}




function 출력(){

	let html =`<tr><th>번호</th><th>내용</th><th>작성자</th><th>비고</th></tr>`;
		
		for(let i=0; i<boardArray.length; i++ ){
			
				html += `<tr>
						<td> ${i+1} </td>
						<td> ${boardArray[i].content}</td>
						<td> ${boardArray[i].writer}</td>
						<td> 
							<button onclick="삭제( ${i} )">삭제</button>
							<button onclick="수정( ${i} )">수정</button>
						</td>
						</tr>`;
	}
			document.querySelector('._table').innerHTML= html;
}
