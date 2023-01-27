
let productList= [
	{ img:'김치삼겹찜.jpeg' , title:'김치삼겹찜살',size: '푸짐한 삼겹살이 올라간', price: 12000, discount: 0.10, like:54, review: 412 },
	{ img:'야채곱창.jpeg' , title:'야채곱창',size: '집에서 만나는 술안주', price: 7900, discount: 0.15, like:54, review: 210 },
	{ img:'양념깻잎지.jpg' , title:'양념깻잎지',size: '향긋하고 알싸한 밥도둑', price: 6000, discount: 0.03, like:54, review: 32 },
	{ img:'에어돈까스.jpg' , title:'에어돈까스',size: '제주도 온 기분나는 돈까스', price: 8500, discount: 0.17, like:54, review: 455 },
	{ img:'오븐구이 치킨.jpg' , title:'오븐구이치킨',size: '자메이카 같은 오븐치킨', price: 13200, discount: 0.10, like:54, review: 622 },
	{ img:'진미채간장볶음.jpg' , title:'진미채간장볶음',size: '오징어아니고 요리임', price: 10900, discount: 0.20, like:54, review: 50 }
]


product_print();
// 1. 제품 출력 // 1. js 열릴떄 
function product_print(){
	let html = ``
	productList.forEach( ( o , i ) => { 
		html += `
			<div class="item"> 					<!-- 제품 1개 -->
				<img src="img/${ o.img }"><!-- 제품이미지 -->
				<div class="item_info"><!-- 제품정보 구역 -->
					<div class="item_title">${ o.title }</div>	<!-- 제품명 -->
					<div class="item_size">${ o.size }</div>	<!-- 제품사이즈 -->
					<div class="item_price">${ o.price.toLocaleString() } 원</div>	<!-- 원가 -->
					<div>
						<span class="item_sale">${ ( o.price - (o.price*o.discount) ) .toLocaleString() } 원</span>	<!-- 판매가 -->
						<span class="item_discount">${ o.discount*100 }%</span>	<!-- 할인율 -->
					</div>
				</div>
				<div class="item_bottom">	<!-- 제품정보 하단 구역  -->
					<div>
						<span class="badge rounded-pill text-bg-warning">주문폭주</span> <!-- 배지 -->
						<span class="badge rounded-pill text-bg-danger">1+1</span>
					</div>
					<div class="item_review"> 찜 ${ o.like } 리뷰수 ${ o.review }</div>	
				</div>
			</div>`
	} )
		document.querySelector('.itembox').innerHTML=html;
				
}