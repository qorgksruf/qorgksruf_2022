console.log('js열림')


getmemberList();

function getmemberList(){
	$.ajax({
		url : "/jspweb/member", 
		method:"get",
		success: (r)=>{
			console.log('ajax응답');
			console.log(r);// 응답 결과 데이터 확인 
			// 1. 응답데이터 처리 
				// 1. 테이블 헤더 구성 
				let html = `<tr>				
									<th width="10%"> 번호 </th>
									<th width="10%"> 프로필 </th>
									<th width="10%"> 아이디 </th>
									<th width="10%"> 이메일주소</th>
									<th width="10%"> 비고 </th>
							</tr>`
				r.forEach((o,i)=>{
					//만약에 회원의 mimg 프로필이미지가 null이면 기본프로필 사용 아니면 mimg사용
					
					html +=`						
						<tr>
							<td> ${o.mno} </td>
							<td><img src="/jspweb/member/pimg/${o.mimg == null ? 'default.webp' : o.mimg}" width="100%"> </td>
							<td>${o.mid} </td>
							<td> ${o.memail}</td>
							<td> </td>
						</tr>`

				});
					// 3. 구성된html를 table 대입 
				document.querySelector('.mListTable').innerHTML = html;
				
			
		}
		
	})	
}

