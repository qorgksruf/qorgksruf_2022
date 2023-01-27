// 1. userbox Dom객체 가져오기
let userbox = document.querySelector('.userbox');
let monbox =document.querySelector('.monbox');
let m_bar=document.querySelector('.m_bar');
let c_bar=document.querySelector('.c_bar');

let logbox=document.querySelector('.logbox');
let logbox2=document.querySelector('.logbox2');

/*let productList= [
	{ img:'몬스터1.gif' , hp : 100, left:910, exp: 50 },
	{ img:'몬스터2.gif' , hp : 100, left:910, exp: 150 },
	{ img:'몬스터3.gif' , hp : 100, left:910, exp: 300 }
]
*/

// * userbox [기본/처음] 위치
let u_left = 10;
let m_left = 910;
let mhp = 300;
let uhp=300;

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
	console.log( '내 위치 : ' + u_left )
	console.log( '몹 위치 : ' + m_left )
	console.log( '거리 : ' + ( m_left-u_left ) )
	let 거리 =  ( m_left-u_left ) 
	if( 거리 >=0 && 거리 <=80){
		mhp -= 20;
		m_bar.style.width =  `${ mhp }px`
	}

}

function 타격(){
	console.log( '내 위치 : ' + u_left )
	console.log( '몹 위치 : ' + m_left )
	console.log( '거리 : ' + ( u_left-m_left ) )
}



//3.몬스터 이동 난수[랜덤=1초마다]

// 특정 시간마다 함수 실행해주는 함수 setInterval( () => {} , 밀리초(1000/1초))

setInterval(mon_moving, 1000);

function mon_moving(){
	//1. 난수 +-10
	let rand = parseInt(Math.random()*100+1);	//1~20 //이동거리
	let rand2 = parseInt( Math.random()*2);		//0또는1//이동방향
	if(rand2 == 1) m_left += rand; //난수 대입
	else m_left -= rand
	//2. 게임화면 고정
	if ( m_left < 0 ) m_left = 0;
	if ( m_left > 910 )m_left =910;
	//3.
	monbox.style.left=`${m_left}px`;
	
	logbox2.innerHTML= `<div> 몸 좌표 : ${m_left}</div>`
	
}



/*
	
	함수 형태 
	1.일반함수: function 함수명(){ }
	2.익명함수: function(){ }
	3.람다식함수: ( )=> { }
	4.변수함수: let 변수명 = () => { }
	
*/





