 
 let pay=0;	//결제금액
 
 function setpay(p){
	 pay=p;
	 alert("결제금액선택"+p);
 }
/* 포인트 가맹점[관리자회원]식별코드
  var IMP = window.IMP;   // 생략 가능
  IMP.init("imp00685607"); // 예: imp00000000 
  
  
    function requestPay() {
		if(pay==0){
			alert("충전할금액을 선택해주세요")
			return;
		}
		
    IMP.request_pay({
      pg: "kakaopay",						//각 pg사별 이름존재
      pay_method: "card",					//결제방법
      merchant_uid: "ORD20180131-0000011",  // 주문번호	//결제DB에서 사용할 PK
      name: "이젠 포인트 결제",
      amount: pay,                         // 숫자 타입 //결제금액
      buyer_email: "gildong@gmail.com",		//여기부턴 관리자정보
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
      if (rsp.success) {//결제성공
      	concole.log(rsp);
      } else {//결제취소/실패
      
       	//결제 성공했다는 가정
       	let info={
			   mpcomment:'포인트충전',
			   mpamount:pay,
			   mno:memberinfo.mno
		   }
		   
		   $.ajax({
			   url:"/jspweb/point",
			   data:info,
			   method:"post",
			   success:(r)=>{
				   console.log(r);
				   console.log("통신성공")
				   if(r=="true"){
					   alert('포인트충전완료');
				   }
			   }
		   })
      }
    });
  }*/
  
//--------------------------------------------------------  

  