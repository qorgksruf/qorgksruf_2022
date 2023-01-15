/*alert('js작동') // 연동 확인용*/

let 도서목록 = [ '혼자공부하는자바' , '이것이자바다' , '열혈 C언어'  ]
let 대여목록 = [ '혼자공부하는자바' ]


console.log('1.addContent() 함수 작동')

function rental(){
	
	console.log('rental함수 실행;')

		let sno = document.querySelector('.sno').value;
		
			let snoValue = sno.value;
				console.log('5번체크 : '+  snoValue ) 
					
					let sIndex =  도서목록.indexOf( snoValue )
						console.log('6번체크 : ' + sIndex )
						
							if(sIndex >= 0){
								document.querySelector('.resultbox').innerHTML="대여가능합니다"
								alert('대여되었습니다')
							 }	
						 	else if( sIndex == -1){
								document.querySelector('.resultbox').innerHTML="대여불가합니다" 
								alert('대여불가합니다')		
							}
							else{document.querySelector('.resultBox').innerHTML = "없는 책 입니다" }
								alert('없는 책입니다')
}



function derental(){
	
	console.log('derental함수 실행;')

		let sno = document.querySelector('.sno').value;
		
			let snoValue = sno.value;
				console.log('5번체크 : '+  snoValue ) 
					
					let sIndex =  도서목록.indexOf( snoValue )
						console.log('6번체크 : ' + sIndex )
						
							if(sIndex >= 0){
								document.querySelector('.resultbox').innerHTML="대여가능합니다"
								alert('대여되었습니다')
							 }	
						 	else if( sIndex == -1){
								document.querySelector('.resultbox').innerHTML="대여불가합니다" 
								alert('대여불가합니다')		
							}
							else{document.querySelector('.resultBox').innerHTML = "없는 책 입니다" }
								alert('없는 책입니다')
}


