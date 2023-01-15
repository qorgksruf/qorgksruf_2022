/*alert('js작동') // 연동 확인용*/

let 도서목록 = [ '혼자공부하는자바' , '이것이자바다' , '열혈 C언어'  ]
let 대여목록 = [ '혼자공부하는자바' ]


console.log('1.addContent() 함수 작동')

function rental(){
	
	console.log('rental함수 실행;')

	let sno = document.querySelector('.sno').value;	// 책태그 정보
	
	console.log("sno의 태그값 ::: ");
	console.log(sno);
					
	let sIndex =  도서목록.indexOf( sno );
	console.log('6번체크 : ' + sIndex )
	
	if (sIndex >= 0) {
		console.log("해당 책이 존재합니다.")
		if(대여목록.indexOf(sIndex) >= 0) {
			alert("해당 책은 대여 중입니다.");
		} else {
			대여목록.push(sIndex);
			alert("해당 책을 대여 완료하였습니다.");
		}
	} else {
		alert("해당 책이 존재하지 않습니다.")
	}
	

}



function derental(){
	
	console.log('derental함수 실행');

	let sno = document.querySelector('.sno');
		
	let snoValue = sno.value;
	console.log('5번체크 : '+  snoValue );
					
	let sIndex =  도서목록.indexOf( snoValue );
	console.log('6번체크 : ' + sIndex );
	
	if (sIndex >= 0) {
		console.log("해당 책이 존재합니다.")
		if(대여목록.indexOf(sIndex) >= 0) {
			대여목록.splice(대여목록.indexOf(sIndex), 1);
			alert("해당 책을 반납 완료하였습니다.");
		} else {
			alert("해당 책은 현재 대여가능한 책으로 반납이 불가합니다.");
		}
	} else {
		alert("해당 책이 존재하지 않습니다.")
	}
	
	
}

		/* 대여상태부분 바뀌는거 못했습니다 splice이용해서 했던것같은데....*/
