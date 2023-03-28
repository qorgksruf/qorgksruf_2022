/*getproductList();
function getproductList(){
		$.ajax({
		url:"/jspweb/product/info",
		method:"get",
		success : (r)=>{
			console.log( "통신성공" )
			console.log( r )
			if(r=="true"){
				alert('등록성공');
				console.log(r);
			}else{
				console.log( "통신실패" )
			}
		}
		
	})
}*/

//제품 목록 출력
let productList=null;
function produclistprint(){
		let html =  `<p style="font-size:12px; text-align:right" > 제품목록수 : ${ productList.length } 개 </h6>`;
        
    productList.forEach( (p,i) => {
		
/*		html += `<div>
					<span> ${p.pname} </span>
					<span> ${p.pcomment} </span>
					<span> ${p.pprice} </span>
					<span> ${p.pstate} </span>
					<span> ${p.pview} </span>
					<span> ${p.pdate} </span>
					<span> <button onclick="setplike(${p.pno})" type="button"  class="plikebtn"> </button></span>
				</div>`*/
				
		html+=`
			<div onclick="productprint(${i})" class="productbox">
				<div class="pimgbox">
					<img src="/jspweb/product/pimg/${p.pimgList[0]}" >
				</div>
				<div class="pcontentbox">
					<div class="pdate">${p.pdate}</div>
					<div class="pname">${p.pname}</div>
					<div class="pprice">${p.pprice.toLocaleString()}원 </div>
					<div class="petc"> 
						<i class="fas fa-eye"></i>${p.pview}
						<i class="fas fa-thumbs-up"></i>5
						<i class="fas fa-comment-dots"></i>2
					</div>
				</div>
				
			</div>
		
		`		
					
	})
	document.querySelector('.productlistbox').innerHTML = html;
}

//제품 개별조회
function productprint(i){
	let p =productList[i];
	
	//이미지 슬라이드에 대입할 html 구성 
	let imghtml =``;
	p.pimgList.forEach((img,i)=>{
		//부트스트랩 : active 현재 보여지는 이미지
		if(i==0){
			imghtml+=`
					<div class="carousel-item active">
				      <img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
				    </div>
				`
		}else{
			imghtml+=`
					<div class="carousel-item">
				      <img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
				    </div>
				`			
		}

	})
	
		let html = ``;
		html += `
			<div class="pviewbox">
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jspweb/member/pimg/${ p.mimg == null ? 'default.webp' : p.mimg }" class="hpimg">
						<span class="mid"> ${ p.mid } </span>
					</div>
					<div>
						<button onclick="produclistprint()" class="pbadge" type="button"> 목록보기 </button>
					</div>
				</div>
				<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
				  <div class="carousel-inner">
				  
				  	${ imghtml }
				  	
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
				
					<div class="pdate"> ${ p.pdate } </div>
					<div class="pname"> ${ p.pname } </div>
					<div class="pcomment"> ${ p.pcomment } </div>
					<div class="pstate"> 
						<span class="pbadge">
							${ p.pstate == 1 ? '판매중' : p.pstate == 2 ? '거래중' : '판매완료'  }
						</span> 
					</div>
					<div class="pprice"> ${ p.pprice.toLocaleString() }원 </div>
					<div class="petc"> 
						<i class="far fa-eye"></i> ${ p.pview }
						<i class="far fa-thumbs-up"></i> 5
						<i class="far fa-comment-dots"></i> 2
					 </div>
					<div class="pviewbtnbox">
						<button class="plikebtn" onclick="setplike(${p.pno})"  type="button"> <i class="far fa-heart"></i> </button>
						<button onclick="chatprint(${i})" type="button"> 채팅 </button>
					</div>
				</div>
			`		
					document.querySelector('.productlistbox').innerHTML = html;
					getplike(p.pno);
}//end

//채팅 페이지 이동
function chatprint(i){
	if(memberinfo.mid==null){
		alert('회원기능입니다.');
		return;
	}
	
	let p = productList[i];
	
	let chathtml='';
	$.ajax({
		url:"/jspweb/product/Chat",
		method:"get",
		data:{"pno":p.pno,},
		async:false, /*동기식*/
		success:(r)=>{
			console.log("chatt통신성공");
			console.log(r);
			r.forEach((o)=>{
				if(r.frommno == memberinfo.mno){
					chathtml+=`<div class="sendbox">${o.ncontent}</div>`
				}else{
					chathtml+=`<div class="receicebox">${o.ncontent}</div>`
				}
			})
			
		}
	})
	
	let html=`
			<div class="charbox">
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jspweb/product/pimg/${p.pimgList[0]}" class="hpimg">
						<span class="pname">${p.pname}</span>
					</div>
					<div>
						<button onclick="produclistprint()" class="pbadge" type="button"> 목록보기 </button>
					</div>
				</div>
				
				<div class="chatcontent">
						${chathtml}
				</div>
				
				<div class="chatbtn">
					<textarea class="ncontentinput rows="" cols=""></textarea>
					<button onclick="sendchat(${p.pno},${p.mno})" type="button">전송</button>
				</div>
				
			</div>	`;

	document.querySelector('.productlistbox').innerHTML = html;
}//end

function sendchat(pno,tomno){
	let ncontent= document.querySelector('.ncontentinput').value;
	$.ajax({
		url:"/jspweb/product/Chat",
		method:"post",
		data:{"pno":pno, "ncontent":ncontent,"tomno":tomno},
		success:(r)=>{
			console.log("통신")
			console.log(r)
			if(r=="true"){
				document.querySelector('.ncontentinput').value='';
			}
		}
	})//ajax e
}//f e


var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(33.45035074314823, 126.57112541869041), // 지도의 중심좌표 
        level : 3 // 지도의 확대 레벨 
    });
    
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 7 // 클러스터 할 최소 지도 레벨 
    });
 
//--------------------------마커 이미지 변경------------------------------------//

var imageSrc = '/jspweb/img/emo1.gif', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다 

 
 // 제품목록 호출 [현재 보이는 지도 좌표내 포함된 제품만]
 function getproductlist(동, 서,남,북){
	 //클러스터비우기 
	 clusterer.clear()
	 $.ajax({
		 url:"/jspweb/product/info",
		 method:"get",
		 async:false,
		 data:{"동":동,"서":서,"남":남,"북":북},
		 success:(r)=>{
	   		// -------------------- 사이드바 제품목록 --------------------------
			productList = r;		// 제품목록 결과를 전역변수에 담아주기
	       produclistprint();
	             
	        // ------------------ 마커작업 -------------------
	        var markers = $( r ).map( ( i , p ) => {
				console.log( p );
				// 마커에 추가코드 작성하기 위해 변수화
	            let marker =  new kakao.maps.Marker({
	                position : new kakao.maps.LatLng(p.plat, p.plng),
	                image:markerImage
	            });
	            
	            // 마커에 클릭이벤트를 등록합니다
				kakao.maps.event.addListener(marker, 'click', function() {
					productprint(i)
				});
	            return marker ;
	        });
	
	        // 클러스터러에 마커들을 추가합니다
	        clusterer.addMarkers(markers);
		}//success e
	})//ajax e	
}//m end
//현재 지도의 좌표얻기
get동서남북();
function get동서남북(){
		    // 지도의 현재 영역을 얻어옵니다 
	    var bounds = map.getBounds();
	    // 영역의 남서쪽 좌표를 얻어옵니다 
	    var swLatLng = bounds.getSouthWest();  
	    // 영역의 북동쪽 좌표를 얻어옵니다 
	    var neLatLng = bounds.getNorthEast(); 
		let 남 = swLatLng.getLat();
		let 서 = swLatLng.getLng();
		let 북 =neLatLng.getLat();
		let 동 = neLatLng.getLng();
		getproductlist(동, 서, 남, 북);
}


	//--------------------지도 중심좌표 이동 이벤트-------------------------
	// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다


	
	kakao.maps.event.addListener(map, 'dragend', function() {
	get동서남북();
	});
	
//3. 찜하기 버튼을 눌렀을때[첫 클릭시 찜하기 다음 클릭시 찜하기 취소 다음 클릭시 찜하기]
function setplike(pno){
	console.log("----------찜하기버튼------------")
	console.log(pno)
	if(memberinfo.mid==null){
		alert('회원기능입니다 로그인후 이용해주세요');
		return;
	}
	
	//1.post 방식 전송
	$.ajax({
		url:"/jspweb/product/like",
		method:"post",
		data:{"pno":pno},
		success:(r)=>{
			console.log(r)
			if(r=='true'){
				alert('찜하기등록')
				document.querySelector('.plikebtn').innerHTML="♥"
			}else{
				alert('찜하기취소')
				document.querySelector('.plikebtn').innerHTML= "♡"; 
			}
		}
	})
	//밑에랑 같다~!!!
	
	//$.get("/jspweb/product/like?pno="+pno , ()=>{} )
	//$.post("/jspweb/product/like?pno="+pno , ()=>{} )			
}

  	// 4.현재 회원이 해당 제품의 찜하기 상태 호출
	function getplike(pno){
		if(memberinfo==null){
			return "♡"
		}
		$.ajax({
			url:"/jspweb/product/like",
			method:"get",
			async:false,
			data:{"pno":pno},
			success:(r)=>{
				console.log(r)
				if(r=="true"){
					document.querySelector('.plikebtn').innerHTML = "♥";
				}else{
					document.querySelector('.plikebtn').innerHTML = "♡";
				}
			}
		})
/*			$.get("/jspweb/product/like?pno"=+pno, (r)=>{
				if(r=="true"){
					return "♥";
				}else{
					return "♡";
				}
			})*/

	}
		

    