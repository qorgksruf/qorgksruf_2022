package Day07;


import java.util.Scanner;

public class EX1_회원시스템_배열 {

	public static void main(String[] args) {
			
		Scanner scanner= new Scanner(System.in);
		
		//memberList={null,null,null} ******배열은 고정배열이다
		String[]memberList=new String[3];
		
		
		while(true) {//종료조건부터 쓰삼;;;;; 없음으로 할게
			
			
			//배열 데이터 출력
			System.out.println("번호[인덱스]\t회원명\t전화번호");
			for(int i=0; i<memberList.length; i++) {
				if(memberList[i]!=null) {
					String[] member=memberList[i].split(",");//"유재석","010-4500"
						System.out.println( i+"\t"+member[0]+"\t"+member[1]);
				} 	
			}
			
			
			
			
			System.out.println("1.회원등록 2.회원삭제");
			
			int ch= scanner.nextInt();
			
			if(ch==1) {
				System.out.println("회원명;;;;");
					String name=scanner.next();
				System.out.println("전화번호;;;");
					String phone=scanner.next();
					
				//****배열내 빈공간 즉 null을 찾기 push기능처럼 *********배열등록하는곳
				 for(int i=0; i<memberList.length; i++) {
					 if(memberList[i]==null) {
						 memberList[i]= name+","+phone;
						 System.out.println(i+"번 회원등록되었습니다 정보:"+memberList[i]);//근데 저장이 3개가됨 왜? null이 세개라
						 break;	//그래서 이걸써서 저장했으면 1개만 저장되도록 
					 }
				 }
					
					
			}
			else if(ch==2){///삭제후 번호 댕기기기능
				System.out.println("삭제할 번호/인덱스;;;");
				int no=scanner.nextInt();
				//3.배열내 데이터 삭제//splice 기능[배열내 null 만들기]
				memberList[ no ]=null;//근데 인덱스 이빨빠진것처럼되니까
				//삭제후 빈자리 채우기[삭제된 인덱스 뒤로 한칸씩 당기기]
				for(int i=no; i<memberList.length; i++) {//삭제위치부터 마지막인덱스까지 삭제자리에 삭제번호+1 넣어줌
					
					if( i+1==memberList.length) {//머마지막 인덱스이면
						memberList[i]=null;	//마지막인덱스에 null넣고 나가는거임
						break;
					}	
						
					
					memberList[i]=memberList[i+1];	//다음 인덱스가 null이면 완전종료
					if(memberList[i+1]==null)break;
					
				}
			}
			
			else {
				
			};
		}//while e
		
	}//main e
}//class e
