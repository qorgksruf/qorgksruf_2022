
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.3218778,126.8308848), //지도의 중심좌표.
	level: 5 //지도의 레벨(확대, 축소 정도)
};



var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

//--------------------------마커 이미지 변경------------------------------------//

var imageSrc = '/jspweb/img/markericon2.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다


//-------------------------마커 생성------------------------------------------//
// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() ,
    image: markerImage	//해당 마커객체의 이미지 객체 대입
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);


//-------------------------지도 클릭이벤트----------------------------------------//
// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
    });

/*//-----------------------여러개 마커생성하기-----------------------------------------------//
let positions = [];

	$.ajax({
		url:"https://api.odcloud.kr/api/3071314/v1/uddi:e4e7774d-0b16-4299-b830-dee5045df70f_201909291441?page=1&perPage=135&serviceKey=LByHaZAPV%2B358qol0urRIjwiPtuFl%2BRzRrzTXQzCUhCm1bU0Eq7onkTRngIvK640oMHYOLPY6dRpVhdJbjIG3A%3D%3D",
		method:"get",
		async: 'false',
		success:(r)=>{
			console.log(r);	//공공데이터 데이터 요청 결과
			console.log('통신성공');
			
			r.data.forEach((o)=>{	//결과내 리스트 객체 반복문
				console.log(o)
				
				let info={// 마커를 표시할 객체 생성
					title: o.업소명,
					latlng: new kakao.maps.LatLng(o.경도 ,o.위도)
				}
			
					//js 변수선언: 1.var 2.let 3.const
				for (let i = 0; i < positions.length; i ++){
				    // 마커를 생성합니다
				    var marker = new kakao.maps.Marker({
				        map: map, // 마커를 표시할 지도
				        position: positions[i].latlng, // 마커를 표시할 위치
				        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				        image : markerImage // 마커 이미지 
				    });
				
				
//-------------------------------------마커에 클릭 이벤트-------------------------------------------------------//
						// 마커에 클릭이벤트를 등록합니다
					kakao.maps.event.addListener(marker, 'click', function() {
							 	alert(positions[i].title+'의마커 클릭했습니다');
					});
				
				}//for end
		
			})
		}	
	})*/



 //--------------------------마커 클러스터 [마커들을 관리]------------------------------------//
 
     // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 6 // 클러스터 할 최소 지도 레벨 
    });



     // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    $.get("https://api.odcloud.kr/api/3071314/v1/uddi:e4e7774d-0b16-4299-b830-dee5045df70f_201909291441?page=1&perPage=135&serviceKey=LByHaZAPV%2B358qol0urRIjwiPtuFl%2BRzRrzTXQzCUhCm1bU0Eq7onkTRngIvK640oMHYOLPY6dRpVhdJbjIG3A%3D%3D",
    	 (r) => {
			 console.log(r)
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        //let 리턴된값배열= map.( )=>{ return 리턴값}
        var markers = $(r.data).map(function(i, o) {
			
			//마커생성객체
            let marker= new kakao.maps.Marker({
                position : new kakao.maps.LatLng(o.위도, o.경도),
                image: markerImage
            });
            
               //위에서 생성된 마커객체의 클릭 이벤트 추가하기
			kakao.maps.event.addListener(marker, 'click', function() {
				alert(o.업소명+"입니다");
			});
			
			//리턴에서 markers에 대입하기[map 함수 제공] 
			return marker;
            
        });

        // 클러스터러에 마커들[마커배열]을 추가합니다
        clusterer.addMarkers(markers);
    });
    





