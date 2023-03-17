console.log('함수');
console.log(memberinfo);

let bno=document.querySelector(".bno").value;
console.log("update 페이지의 bno:::"+bno);

//내가 수정할 게시물 출력
getBoard();
function getBoard(){
	$.ajax({
		url:"/jspweb/board/info",
		method:"get",
		data:{"type":2, "bno":bno },//2는 개별출력임
		success:(r)=>{
			console.log('통신');
			console.log(r);
			
			document.querySelector('.btitle').value=r.btitle;
			document.querySelector('.bcontent').value=r.bcontent;
			
			//기존 select option 가져와서 selected
			let cnoSelect = document.querySelector('.cno');
				console.log(cnoSelect);	//select만 가져온거임
				console.log(cnoSelect.options[0]);	//select 안에 있는 첫번재 옵션 호출
			for(let i=0; i<cnoSelect.options.length; i++){
				//i는 0부터 옵션테그 개수만큼 반복
				if(cnoSelect.options[i].value==r.cno){
					//i번째 옵션테그의 값과 현재 게시물의 카테고리번호와 일치하면 
					cnoSelect.options[i].selected=true;
				}
			}
			
			//첨부파일있을때/ 없을때
			let html=''
			if(r.bfile==null){//없을떄
				html+='<div>첨부파일없음</div>';
				
			}else{//있을때
				html+=`<div>
						기존 첨부파일:<span class="oldbfile"></span>
						<button onclick="bfiledelete()" type="button">삭제</button>
						</div>`
			}
					
			html+=`변경할첨부파일:  <input name="bfile" type="file">`
			document.querySelector('.bfilebox').innerHTML=html;
			document.querySelector('.oldbfile').innerHTML=r.bfile;
		}
	})		
}

//파일 수정
function bupdate(){
	console.log('쓰기함수열림')
	let updateForm = document.querySelectorAll('.updateForm')[0];

	//1.form 안에 있는 데이터 객체화했다
	let updateFormData = new FormData(updateForm);
	
	//form 밖에 있거나 js에 있는 추가 데이터는 formData.set 추가 가능함
	//formdata객체명.set('변수명',데이터)
	updateFormData.set('bno',bno); //수정할 대상
		console.log(updateFormData);
		$.ajax({
		url:"/jspweb/board/info",
		method:"put",
		data:updateFormData,
		processData: false,
		contentType: false,
		success:(r)=>{
			console.log('통신');
			console.log(r);
			if(r=='true'){
				alert('업데이트성공');	//현재 보고있는 게시판 조회이동
				location.href="/jspweb/board/view.jsp?bno="+bno;
			}else{
				
			}

		}
	})	
		
}

//3. 파일만 삭제
function bfiledelete(){
	alert('첨부파일 만 삭제합니다');
	
		$.ajax({
		url:"/jspweb/board/info",
		method:"delete",
		data:{"bno":bno ,"type":2},	//게시물삭제 //첨부파일만 삭제
/*		processData: false,
		contentType: false,*/
		success:(r)=>{
			console.log('통신');
			console.log(r);
			if(r=='true'){
				//특정 div만 reload[렌더링]방법 => 해당파일 삭제시 삭제된 모습 바로 보여주는거 
					$(".bfilebox").load(	location.href+' .bfilebox' ); 
					//load():jQuery 제공하는 렌더링[새로고침] 함수
				
				//얘는 jQUERY방식임 $(".클래스명") 	해당 클래스명을 가진 테그를 객체화한다
				//ㅇㅒ는 document.querySelector('.bfilebox'); 이거랑 같음
				//불가능 document.querySelector('.bfilebox').load(location.href+'.bfilebox');
			}else{
				
			}
		}
	})	
	
}




