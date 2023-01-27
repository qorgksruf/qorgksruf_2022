// 1. userbox Dom객체 가져오기
let userbox = document.querySelector('.userbox');
let monbox =document.querySelector('.monbox');
let m_bar=document.querySelector('.m_bar');
let c_bar=document.querySelector('.c_bar');

let logbox=document.querySelector('.logbox');
let logbox2=document.querySelector('.logbox2');

let monsterList= [
	{ img:'몬스터1.gif' , mhp : 100, left:910, exp: 50 },
	{ img:'몬스터2.gif' , mhp : 200, left:910, exp: 150 },
	{ img:'몬스터3.gif' , mhp : 300, left:910, exp: 300 }
]

let monindex = 0; // 배열내 첫번째 몬스터 호출 
let m_left = monsterList[0].left; // 첫번째 몬스터 위치 기본값 
let mhp = monsterList[0].mhp; // 첫번째 몬스터 체력 기본값 
let m_attack = 10 ; // 몬스터 공격력 

몬스터교체( monindex ); // 처음에는 monindex 0 이기 때문에 

function 몬스터교체( i ){ // i = 0 
	monbox.style.backgroundImage=`url("img/${ monsterList[i].img }")`	// i번째 몬스터 이미지 
	 m_left = monsterList[i].left; // i번째 몬스터 위치 
	 mhp = monsterList[i].mhp; // i번째 몬스터 체력
	
	 
}

// * userbox [기본/처음] 위치
let u_left = 10;


let uhp=100;
let u_attack =1;



// 2. 문서 안에서 키 입력 이벤트 

document.addEventListener( 'keydown' , (e)=>{
	let key = e.keyCode;	// 입력된 키 코드를 변수에 저장 
	
	if( key == 37 ){ // 왼쪽키
		u_left -= 10;	//왼쪽 좌표 -10 차감
		u_left= u_left <0 ? 0 : u_left; //만약에 차감된 왼쪽 좌표가 0보다 작으면 0 아니면 적용		
	}else if( key == 39 ){ // 오른쪽키 
		u_left += 10
		u_left= u_left >910 ? 910 : u_left; 
		userbox.style.backgroundImage=`url("img/케릭터2_이동.png")`	//이동 모션
		userbox.style.backgroundSize=`110%`;
		타격();
	}else if( key == 65 ){	//a키 공격
		userbox.style.backgroundImage=`url("img/케릭터2_이동.png")`//공격 모션 이미지
		공격();	
	}
	userbox.style.left = `${ u_left }px`//키 입력후에 css: left 변경
	//전체 좌표를 로그에 출력
	logbox.innerHTML = `<div> 좌표: ${u_left}</div>`
} )

document.addEventListener('keyup',(e)=>{
	userbox.style.backgroundImage=`url("img/케릭터1.png")`
	userbox.style.backgroundSize=`90%`;	
})



function 공격(){
	let 거리 =  ( m_left-u_left ) 
	if( 거리 >=0 && 거리 <=80){
		mhp -= 20;
		m_bar.style.width =  `${ mhp }px`
		if( mhp < 0 ){
			monindex++; // 다음 몬스터 i 증가 
			몬스터교체( monindex ) // i 대입
		if( mhp < 0 && (monindex = 2) ){
				alert('죽음')	}		/*여기 안됨*/
		}
			
	}
}	
	




function 타격(){
	console.log( '내 위치 : ' + u_left )
	console.log( '몹 위치:'+ m_left )
	let 거리 =  ( m_left-u_left ) 
	if( 거리 >=0 && 거리 <=80){
	uhp -= 20;
	c_bar.style.width =  `${ uhp }px`	
	/*userbox.style.width =  `${ uhp }px`*/
	}
}


		/*mhp -= u_attack*(parseInt (Math.random()*20+1 ))*/
	

setInterval( mon_moving , 1000 );
function mon_moving(){ 
	// 1. 난수 +-10
	let rand = parseInt( Math.random()*100+1); // 1~100	// 이동거리
	let rand2 = parseInt( Math.random()*2 ); // 0 또는 1  // 이동방향
	if( rand2 == 1 ) m_left += rand
	else m_left -= rand
	// 2. 게임 화면 고정 
	if( m_left < 0 ) m_left = 0;
	if( m_left > 910 ) m_left = 910;
	// 3. 몬스터 이동
	monbox.style.left = `${ m_left }px`
	// * 현재 좌표를 로그에 출력 
	logbox2.innerHTML = `<div> 몹 좌표 : ${ m_left }</div>`
}

/*
	함수 형태 
		1.일반함수 : function 함수명(){ }
		2.익명함수 : function(){ }
		3.람다식함수: ( ) => { }
		4.변수함수 : let 변수명 = () => { }
	Math.random()
		Math.random() : 0~1 사이의 실수 
		Math.random()*10 : 0~10 사이의 실수
		 
		
*/



