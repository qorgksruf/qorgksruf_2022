alert('js열림')		
//1. 문서가 열렸을때 DOM객체 이벤트

/*document.addEventListener('DOMContentLoaded', ()=>{실행문;} )*/
document.addEventListener('DOMContentLoaded', ()=>{
	alert('HTML 열림')
	
	const h1= document.querySelector('h1')
	
	console.log(h1)
	console.log( typeof(h1)) //typeof( ) : 데이터형 확인() 즉 문자인지 함수인지 객체인지 등등
	
	h1.innerHTML='안녕'
	h1.style.color='red'
	h1.style.backgroundColor='blue'	
	h1.style.padding = '10px'
})

//2.
document.addEventListener('DOMContentLoaded', function(){ 
	const h1Array = document.querySelectorAll('h1')
	
	console.log(h1Array)
	console.log(typeof(h1Array))	//typeof( ): 데이터형 확인
	
	//* 배열내 데이터[요소]를 하나씩 꺼내는 방법
	//1.
	for(let i=0; i<h1Array.length; i++){	//i라는 임시변수를 인덱스처럼 반복문으로 사용
		h1Array[i].innerHTML='안녕'+i		
	}//for e
	//2.
	for(let index in h1Array){	//배열내 요소 모둔인덱스를 마지막까지 하나씩 반복변수에 대입시키는거
		h1Array[index].innerHTML='안녕'+index
	}
	//3.
	for(let object of h1Array){	//배열내 요소 모든 데이터를 마지막까지 하나씩 반복변수에 대입
		object.innerHTML='안녕'	
	}//for end
	
	//4. 여긴 일단 몰라도됨;;;;;;;;;;;;;;;
	h1Array.forEach((object)=> {object.innerHTML='안녕~~' })
		//배열명.forEach(화살표함수)
		//배열명.forEach( (인수)=> {실행문;})
		//배열명.forEach( (요소값)=> {실행문;})
	h1Array.forEach((object)=> console.log(object))
		//배열명.forEach((요소값,인덱스)=> {실행문;})
	h1Array.forEach((object,index)=> {console.log(object); console.log (index); })
	
	h1Array.forEach((object, index, array)=>{
		console.log(object); console.log(index); console.log( array )
	})	
})
// 배열명.forEach((object)=> { })
// 배열명.forEach((object.index)=> { })
// 배열명.forEach((object.index.parentArray)=> { })
/*배열과 반복문 */













