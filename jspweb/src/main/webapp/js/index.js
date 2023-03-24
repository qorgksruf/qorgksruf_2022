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

let productList=null;
function productlistprint(){
		let html = '';
        
    productList.forEach( (p) => {
		
		html += `<div>
					<span> ${p.pname} </span>
					<span> ${p.pcomment} </span>
					<span> ${p.pprice} </span>
					<span> ${p.pstate} </span>
					<span> ${p.pview} </span>
					<span> ${p.pdate} </span>
					<span> <button onclick="setplike(${p.pno})" type="button"> getplike(${p.pno}) </button></span>
				</div>`
					
	})
	document.querySelector('.productlistbox').innerHTML = html;
}


var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.37773589703581, 126.78118307978525), // 지도의 중심좌표 
        level : 3 // 지도의 확대 레벨 
    });
    
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 7 // 클러스터 할 최소 지도 레벨 
    });
 
 
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
	        productlistprint();
	             
	        // ------------------ 마커작업 -------------------
	        var markers = $( r ).map( ( i , p ) => {
				console.log( p );
				
				// 마커에 추가코드 작성하기 위해 변수화
	            let marker =  new kakao.maps.Marker({
	                position : new kakao.maps.LatLng(p.plat, p.plng)
	            });
	            
	            // 마커에 클릭이벤트를 등록합니다
				kakao.maps.event.addListener(marker, 'click', function() {
					
					let html = `<button onclick="productlistprint()"> << </button> <h3>제품상세페이지</h3>`
				    
				   	html += `<div>
								<div> ${p.pname} </div>
								<div> ${p.pcomment} </div>
								<div> ${p.pprice} </div>
								<div> ${p.pstate} </div>
								<div> ${p.pview} </div>
								<div> ${p.pdate} </div>
								<div> <button class="plikebtn" onclick="setplike(${p.pno})" type="button"> </button></div>
								</div>`
								
					document.querySelector('.productlistbox').innerHTML = html;
					
					getplike(p.pno);
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
		

    