
console.log( 'js실행') //테스트

//1번 실행결과 누적여	부
let 테이블행 ='<tr> <th> j </th> <th> i </th> </tr>';

let i=prompt ("내용입력")
let j =Number(prompt("번호"))

for(let i of regi){
		console.log("방명록:"+i)
	
	테이블행 ='<tr> <th>j </th> <th>i</th> </tr>';
}


document.querySelector("._table").innerHTML = 테이블행	


function addcontent(){
	console.log('클릭했다.');//3.확인
	
		let regi=document.querySelector(".regi").value


for(let i of regi){
		console.log("방명록:"+i)
	
	테이블행 ='<tr> <th>j</th> <th>i</th> </tr>';
}

}


document.querySelector("._table").innerHTML = 테이블행	


