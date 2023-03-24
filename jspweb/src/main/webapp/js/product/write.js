console.log('js열림')

//전역변수
let plat=0;
let plng=0;

function onwrite(){
	//1.폼전송
	let writeform= document.querySelectorAll('.writeform')[0];
		console.log(writeform);
	let writeformData = new FormData(writeform);
		console.log(writeformData);
	//좌표[위도, 경도]추가
	writeformData.set("plat",plat);
	writeformData.set("plng",plng);
	
	if(plat==0||plng==0){
		alert('위치 선택후 등록해주세요');
		return;
	}
	
	
	$.ajax({
		url:"/jspweb/product/info",
		method:"post",
		data: writeformData,
		contentType : false ,
		processData : false , 
		success : (r)=>{
			console.log( "통신성공" )
			console.log( r )
			if(r=="true"){
				alert('등록성공');
				location.href="/jspweb/index.jsp"
			}else{
				console.log( "통신실패" )
			}
		}
		
	})
	
}





//----------------------------카카오를 지도에 표시할 div

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
//----------------------------지도를 클릭한 위치에 표시할 마커
// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

//----------------------------지도에 클릭 이벤트를 등록합니다------------------------

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
	plat= latlng.getLat()
		console.log(   "위도: "+latlng.getLat() )
	plng=latlng.getLng()
    	console.log(   "경도: "+latlng.getLng() )
});