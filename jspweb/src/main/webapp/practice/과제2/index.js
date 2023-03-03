//alert('성공'); 테스트

function ex1(){
	
	
	let info={
		data1 : document.querySelector('.data1').value ,
		data2 : document.querySelector('.data2').value ,
		data3 : document.querySelector('.data3').value ,
		data4 : document.querySelector('.data4').value ,
		data5 : document.querySelector('.data5').value ,
		data6 : document.querySelector('input[name="data6"]:checked').value ,
		data7 : document.querySelector('.data7').checked ,
		data8 : document.querySelector('.data8').value ,
		data9 : document.querySelector('.data9').value ,
	}
	console.log(info)
	
	$.ajax({							// *. jquery 라이브러리 필수!!
		url : "/jspweb/homework",			// 1. 서블릿 주소 [ /프로젝트명/서블릿주소(@WebServlet("/서블릿주소") ) ]
		method : "post",				// 2. 메소드 방식 [ doGet vs doPost ]
		data : info ,					// 3. 보낼 데이터 [ 객체 vs { } ]
		success : function(result){
			console.log( result );
			if( result == 'true' ){ alert('등록성공'); getData(); }
			else{ alert('등록실패');}
		} // 4.받을 데이터 
	})	

}

getDate();
function getDate(){
	$.ajax({
		url : "/jspweb/homework" ,
		method : "get" ,
		success : function( result ){
			console.log( result );
			let html = `
				<table border="1">
					<tr>
						<th>data1 </th>
						<th>data2 </th>
						<th>data3 </th>
						<th>data4 </th>
						<th>data5 </th>
						<th>data6 </th>
						<th>data7 </th>
						<th>data8 </th>
						<th>data9 </th>
					</tr>
			`
			result.forEach((o,i)=>{ 
				html += `
						<tr>
							<th> ${ o.data1 } </th>
							<th> ${ o.data2 } </th>
							<th> ${ o.data3 } </th>
							<th> ${ o.data4 } </th>
							<th> ${ o.data5 } </th>
							<th> ${ o.data6 } </th>
							<th> ${ o.data7 } </th>
							<th> ${ o.data8 } </th>
							<th> ${ o.data9 } </th>
						</tr>		
				`
			} ) 
			html += `<table>`
			document.querySelector(".ex2_box").innerHTML = html;
		}
	})	
}



