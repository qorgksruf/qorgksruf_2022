/*//alert('js열림!')

function doPOST(){
	alert('http post 메소드 열림!')
	$.ajax({
		url:"/jspweb/Ex03",
		method: "post",
		success: (result)=>{ }
	})
}

function doGET(){
	alert('http get 메소드 열림')
	$.ajax({
		url:"/jspweb/Ex03",
		method: "get",
		success: function(result){ }
	})
}

function doPUT(){
	alert('http put 메소드 열림')
	$.ajax({
		url:"/jspweb/Ex03",
		method: "put",
		success: (result)=>{ }
	})	
}

function doDELETE(){
	alert('http delete 메소드 열림')
	$.ajax({
		url:"/jspweb/Ex03",
		method: "delete",
		success: (result)=>{ }
	})		
}

//---------------------------- 쓰기
function onwrite(){
	console.log('onwrite 함수 실행됨')
	
	let info={
		content: document.querySelector('.content').value,
		writer: document.querySelector('.writer').value
	}
	
	console.log(info)
	
	$.ajax({
		url:"/jspweb/Ex03/Board",
		method: "post",
		data: info,
		success: (result)=>{
			console.log('ajax 응답성공');
			if(result=='true'){
				alert('등록성공');
				document.querySelector('.content').value='';
				document.querySelector('.writer').value='';
			}else{
				alert('등록실패');
			}
		 }
	})		
}


onlist();
function onlist(){
		$.ajax({
		url:"/jspweb/Ex03/Board",
		method: "get",
		success: (result)=>{
			console.log('get 응답성공');
			console.log(result);
			//테이블제목
			let html = 
					`<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>비고</th>
					</tr>`;
			//테이블 내용		
			result.forEach((o,i) =>{
				html+=
					`<tr>
						<td>${o.bno } </td>
						<td>${o.bcontent } </td>
						<td>${o.bwriter } </td>
						<td> 
								<button onclick="ondelete(${o.bno})" type="button"> 삭제 </button>
								<button onclick="onupdate(${o.bno})" type="button"> 수정 </button>
						 </td>
					</tr>`;				
			});
			
			document.querySelector('.boardtable').innerHTML = html;
		 }
	})		
}

//3. 특정 게시물 삭제
function ondelete(bno){
	console.log("ondelete()열림"+bno);
	$.ajax({
		url:"/jspweb/Ex03/Board",	
		method: "delete",
		data:{"bno":bno },
		success: (result)=>{
			console.log('delete 응답성공');
			console.log(result);	
			if(result==true){
				alert('삭제성공');
			}else{
				alert('삭제실패');
			}	
		}	
	});
}


function onupdate(bno){
	console.log("onupdate열림"+bno);
	let newContent = prompt('수정할 내용입력');
	$.ajax({
		url:"/jspweb/Ex03/Board",	
		method: "put",
		data:{"bno":bno,"newContent":newContent },
		success: (result)=>{
			console.log('put 응답성공');
			console.log(result);
			if(rsuult==true){
				alert('수정성공');
				onlist();	//초기화
			}else{
				alert('수정실패');
			}			
		}	
	});	
	
}
*/
/*과제시작------------------------------------------*/
/*제품등록함수실행*/
function onregi(){
	console.log('onregi 함수 실행됨')
	
	let info={
		pname: document.querySelector('.pname').value,
		pprice: document.querySelector('.pprice').value
	}
	
	console.log(info)
	
	$.ajax({
		url:"/jspweb/Product",
		method: "post",
		data: info,
		success: (result)=>{
			console.log('ajax 응답성공');
			if(result=='true'){
				alert('등록성공');
				document.querySelector('.pname').value='';
				document.querySelector('.pprice').value='';
			}else{
				alert('등록실패');
			}
		 }
	})		
}

/*-----테이블 출력하기--------*/
prolist();
function prolist(){
		$.ajax({
		url:"/jspweb/Product",
		method: "get",
		success: (result)=>{
			console.log('get 응답성공');
			console.log(result);
			//테이블제목
			let html = 
					`<tr>
						<th>번호</th>
						<th>이름</th>
						<th>가격</th>
					</tr>`;
			//테이블 내용		
			result.forEach((o,i) =>{
				html+=
					`<tr>
						<td>${o.pno } </td>
						<td>${o.pname } </td>
						<td>${o.pprice } </td>
						<td> 
								<button onclick="pdelete(${o.pno})" type="button"> 삭제 </button>
								<button onclick="proupdate(${o.pno})" type="button"> 수정 </button>
						 </td>
					</tr>`;				
			});
			
			document.querySelector('.pboardtable').innerHTML = html;
		 }
	})		
}


/*삭제하기*/
function pdelete(pno){
	console.log("product delete()열림"+pno);
	$.ajax({
		url:"/jspweb/Product",	
		method: "delete",
		data:{"pno":pno },
		success: (result)=>{
			console.log('delete 응답성공');
			console.log(result);	
			if(result){
				alert('삭제성공');
			}else{
				alert('삭제실패');
			}	
		}	
	});
}


/*수정하기*/

function proupdate(pno){
	console.log("proupdate열림"+pno);
	let newPname = prompt('수정할 제품명입력');
	let newPrice= prompt('수정할 가격입력');
	$.ajax({
		url:"/jspweb/Product",	
		method: "put",
		data:{"pno":pno,"newPname":newPname,"newPrice":newPrice },
		success: (result)=>{
			console.log('put 응답성공');
			console.log(result);
			
			if(result){
				alert('수정성공');
				prolist();
			}else{
				alert('수정실패');
			}			
		}	
	});	
	
}	
	

