/*

	반복문 : 코드를 반복
		1.for 
			1.for( 1.초기값; 2.조건문; 3.증감식){4.실행문}
				1.초기값: 반복변수 처음값
				2.조건문: 조건이 true면 실행 아니면 실행x
				3.증감식: 반복변수 증가/감소 단위
				4.실행문: 만약에 조건이 true이면 실행되는 구역
				
				
			2. * 배열/리스트 
			
				1. for(초기값; 배열.length; 증감식){ 실행문; }
				2. for( 반복변수 of 배열/리스트){ 실행문;}
				3. for(반복변수 in 배열/리스트){ 실행문;}
				
		2.while
		   1.형태
		   		1.while(true){실행문;}	: 무한루프
		   		
				2. 조건이 true 이면 {} 안으로 들어감 [상수 조건 조심!!]
					while(조건) {}
				3. * 순서에 따른 반복
				
					let i=0; 		//1. 반복변수 선언
					while( i<10 ){  //2. 조건문 
						실행문
						i++;		//3. 증감식[반복변수에 증감]
						실행문		//4. 실행문
				}		
				
			3. 증감식
				i++ vs i+=1 vs i=i+1 : 1씩증가	
				ㅑ+=3 vs i=i+3 		 : 3씩증가
				예) i=1 일때 	i+=2	 : 홀수만 반복
				예) i=0 일떄 i+=3		 :3배수
				
 */
// 1.while의 무한루프
//while(true){ alert('반복실행'); }

//2.while	[조건이 상수이면 반복]
//while(10>5){ alert('실행문');}	//10이 5보다 크니까 반복실행

//3.while
let 입력=prompt('입력:')		
while(입력 !='exit'){		//조건) 입력된 값이 exit가 아니면 아래 코드 실행
	console.log('실행중')
	입력=prompt('입력')	// 반복적으로 입력받기
} //while 종료되는 조건: 입력된 값이 exit 이면 종료	

//4.while[순서 대로 반복]
let i =0; //반복 순서 번호 변수 [반복 몇번 되었는지 체크 함수]
while (i < 10){ //종료조건: i가 10이면 [false] 종료
	//i는 0부터 9까지 1씩 증가 반복=10회 반복
	i++;
	console.log('실행중2:' +i);
	 //i변수[반복변수]1 증가

}

//중요****/ 1. for문 [ ] 위에꺼랑 똑같음 주로 for 많이 씀

for(let j=0; j<10; j++ ){//for문 시작
	//i는 0부터 10미만까지 1씩 증가하면서 반복
	console.log('실행문3:'+j )
}//

//2. 배열과 for 문
let 과일상자=['사과', '포도', '딸기'] //*데이터 3개를 저장하는 배열 선언


	//1.0부터 마지막인덱스까지의 j 반복해서 배열명[인덱스=j] 요소 호출
for(let j=0; j< 과일상자.length; j++){
	//j는0부터 배열의길이[3] 미만 까지 1씩 증가 하면서 반복 = 0 1 2-> 3회
		//인덱스===길이-1
	console.log (j + "번쨰요소:" + 과일상자[j])

} //for e

	//2. df 기준으로 오른쪽에 있는 배열/리스트내 요소 값을 하나씩 왼쪽 변수에 반복 대입
for(let j of 과일상자){//for s
	console.log("요소의 데이터:"+ j )
}	

	//3. in 키워드: 기준으로 오른쪽있는 배열/리스트내 요소 인덱스를 하나씩 왼쪽 변수에 반복
	
for(let j in 과일상자){
	console.log("요소의 인덱스:"+ j )
}	






