/**
 * 
 */





		 let boardlist=[
			 { no : 1 , classfy: '[홈페이지/모바일]' , title : '인테넷 예매 후 CGV 현장에서 환불(예매 취소)이 가능한가요?' , 	view: 89014 },
			 { no : 2 , classfy: '[VIP관련]' , title : 'VIP 등급별 유지, 선정의 VIP점수 기준을 알고 싶어요' , 	view: 84392 },
			 { no : 3 , classfy: '[관람권/결제수단]' , title : '관람권 사용해서 예매했는데 현금영수증 발행을 못했어요!' , 	view: 82913 },
			 { no : 4 , classfy: '[멤버쉽/클럽서비스]' , title : '생일콤보 받는 방법을 알려주세요. (2020.04.01~)' , 	view: 84392 },
			 { no : 5 , classfy: '[VIP관련]' , title : 'VIP 선정 기준은 어떻게 되나요?' , 	view: 89014 },
			 { no : 6 , classfy: '[멤버쉽/클럽서비스]' , title : '아이핀(I-PIN) 이 무엇인가요?' , 	view: 82913 },
			 { no : 7 , classfy: '[VIP관련]' , title : '인터넷 예매 후 예매 내용 확인은 어떻게 하나요?' , 	view: 83738 },
			 { no : 8 , classfy: '[멤버쉽/클럽서비스]' , title : '이미 예매한 내역의 결제수단을 변경하고 싶어요.' , 	view: 81276 },
			 { no : 9 , classfy: '[홈페이지/모바일]' , title : 'CGV영화관람권(무비머니)은 어떻게 구매하나요?' , 	view: 89014 },
			 { no : 10 , classfy: '[홈페이지/모바일]' , title : '내가 본 영화를 실수로 삭제했어요. 복구 가능한가요?' , 	view: 80943 },
			 { no : 11 , classfy: '[특별관]' , title : '내가 본 영화를 실수로 삭제했어요. 복구 가능한가요?' , 	view: 89014 },
			 { no : 12 , classfy: '[영화관이용]' , title : 'CINE&LIVING ROOM(씨네앤리빙룸) 상영관은 어떤 곳인가요?' , 	view: 89014 },
			 { no : 13 , classfy: '[VIP관련]' , title : 'LOLOL(롤롤) 운영시간은 어떻게되나요?' , 	view: 89014 },
			 { no : 14 , classfy: '[특별관]' , title : '통신사(SKT, KT, LGU+) 예매 시 적립/내가 본 영화 등록/포토플레이 제작은 어떻게 하나요?' , 	view: 80014 },
			 { no : 15 , classfy: '[홈페이지/모바일]' , title : 'V버스터즈가 뭔가요?' , 	view: 79697 },
			 { no : 16 , classfy: '[홈페이지/모바일]' , title : 'PRIVATE BOX 상영관은 어떤 곳인가요?' , 	view: 79747 },
			 { no : 17 , classfy: '[홈페이지/모바일]' , title : '포토플레이 제작 기준은 어떻게 되나요?' , 	view: 89014 },
			 { no : 18 , classfy: '[홈페이지/모바일]' , title : '온라인 예매내역의 환불/취소 시 알아야할 내용은 어떤것이 있나요?' , 	view: 89014 },
			 { no : 19 , classfy: '[홈페이지/모바일]' , title : '영화관람/매점상품 기프트콘은 어디서 환불하나요?' , 	view: 79567 },
			 { no : 20 , classfy: '[홈페이지/모바일]' , title : '내가 본 영화 등록이 안되어 있어요. 어떻게 하나요?' , 	view: 79420 }
			
			 
		 ]
		 
		 
		 	let html=''
		 	for( let i=0 ; i<boardlist.length; i++){
				 html +=`
				 <tr>
				 		<td> ${ boardlist[i].no } </td>
				 		<td> <a href="#">${ boardlist[i].classfy}</a> </td>
				 		<td> <a href="#">${ boardlist[i].title}</a> </td>
				 		<td> ${ boardlist[i].view} </td>
				 		
				 </tr> `
				 
			 }
		 	
		 		document.querySelector('.boardlist').innerHTML=html;
		 	
		 
 
 