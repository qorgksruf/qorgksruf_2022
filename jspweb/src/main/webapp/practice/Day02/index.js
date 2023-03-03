alert('js열림')

//1.js열렸을때
//document.querySelector(".data1").value

//2. 특정 행동 [이벤트] 있을때 코드 집합소 실행
function ex1(){	//함수정의하는 곳임 함수실행은 jsp임

	//변수10개--->객체{ } 1개로 묶어버려 { 필드명 : 값 , 필드명 : 값 , 필드명 : 값 ,}
	let info = {
	data1:	document.querySelector('.data1').value,
	data2:	document.querySelector('.data2').value,
	data3:	document.querySelector('.data3').value,
	data4:	document.querySelector('.data4').value,
	data5:	document.querySelector('.data5').value,
	data6:	document.querySelector('.data6').value,
	data7:	document.querySelector('input[name="data7"]:checked').value,	//radio 에서 선택된 버튼의 value값
	data8:	document.querySelector('.data8').checked,						//check 여부 true/false
	data9:	document.querySelector('.data9').value,
	data10:	document.querySelector('.data10').value
	}
	console.log(info)	//data7외 모두 문자열임....[추후 형 변환]
	//비동기 통신
      $.ajax({			//1.jquery 라이브러리 필수!!	
         url : "/jspweb/Ex2" , 	//1.서블릿 주소 [/프로젝트명/서블릿주소/@]
         method : "post" ,  //2. 메소드 방식
         data : info , 	//3. 보낼 데이터 위에 객체말하는거임
         success : function( result ){ //받을데이터
         	if(result==true){
				 alert('등록성공');
			 }else{
				  alert('등록실패');
			 }
         	
          }	//4. 받을 데이터
   
          
      })
	
}// 함수1 e

getDate();
function getDate(){
      $.ajax({			//1.jquery 라이브러리 필수!!	
         url : "/jspweb/Ex2" , 	//1.서블릿 주소 [/프로젝트명/서블릿주소/@]
         method : "get" ,  //2. 메소드 방식
         success : function( result ){ //받을데이터
         	//console.log(result);
         	//document.querySelector(".ex_box").innerHTML = result;
         	
         	let html = `
         				<table border="1">
         					<tr>
         						<th>data1</th>
         						<th>data2</th>
         						<th>data3</th>
         						<th>data4</th>
         						<th>data5</th>
         						<th>data6</th>
         						<th>data7</th>
         						<th>data8</th>
         						<th>data9</th>
         						<th>data10</th>
         					</tr>
         					`
         	result.forEach((o,i )=>{	//객체명.forEach((반복변수,반복인덱스))
			
				html +=`
						<tr>
         						<th>${o.data1}</th>
         						<th>${o.data2}</th>
         						<th>${o.data3}</th>
         						<th>${o.data4}</th>
         						<th>${o.data5}</th>
         						<th>${o.data6}</th>
         						<th>${o.data7}</th>
         						<th>${o.data8}</th>
         						<th>${o.data9}</th>
         						<th>${o.data10}</th>
							</tr>
						`

			 } )
         	html +=`</table>`
         	document.querySelector(".ex1_box").innerHTML = html;
         	
          }	

          
      })
}







