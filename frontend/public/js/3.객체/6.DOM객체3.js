
// 1.keyup 이벤트: 키보드 키를 누르고 땟을때

	// 1.<textarea> 마크업 객체화
const textarea= document.querySelector ('textarea')
const h3 =document.querySelector('h3')

textarea.addEventListener('keyup',(이벤트상태) => {
	 
	 h3.innerHTML =`글자 수: ${textarea. value.length }`
	 //4.키 상태 확인
	 
	console.log(이벤트상태)
	console.log(이벤트상태.altkey)  
	console.log(이벤트상태.ctrlkey)
	console.log(이벤트상태.shiftKey)
	console.log(이벤트상태.key)
	
})
	//css조작
	textarea.style.position='absolute'	//static 기본값은 위치 조작이 불가능함
	let x= 0	//처음위치를 정하기위한 x축과 y축 기본값세팅함
	let y= 0	//상위 마크업 시작점 기준
	let block= 30;	//이동단위

print(); //위치 배치 1번 실행
function print(){	//위치 배치 함수 
	textarea.style.left =`${ x*block }px`	//css left=(x*이동단위)+'px'
	textarea.style.top = `${ y*block }px`	//css right=`${y*이동단위}`
}	

//2. keydown: 키보드 키를 입력했을때
document.body.addEventListener('keydown', ( e )=>{
								
if(control){ //만약에 control이 true인 경우에만 아래 시작됨									
	let key =e.keyCode;		console.log(e.keyCode);
	if( key == 37 ){x--;}	// left음수 대입 // 왼쪽키
	else if( key == 38 ){ y--; }	// top 음수 대입 // 위쪽키		
	else if( key == 39 ){ x++; }	// left++ // 오른쪽키
	else if( key == 40 ){ y++; }	//top++// 아래키
	print()
	}	//if enf
})	//f end

let control = true;
//3. 배치 제어하기
document.querySelector('.moving').addEventListener('click', ()=>{
	
	/*control ? control=false : control=true 이걸쓰거나 밑에껄 쓰거나*/
	control = !control
})




