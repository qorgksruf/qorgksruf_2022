package 과제3;

import java.util.ArrayList;
import java.util.Scanner;

import Day07_EX5.Member;

public class 실행 {

	public static void main(String[] args) {
		
		//입력객체
		Scanner scanner = new Scanner(System.in);
		
		String id="gksruf";
		String password="gksruf";
		String neme="백한결";
		
		
		//Book객체를 여러개 저장할 리스트
		ArrayList<Book>bookList= new ArrayList<>(); //가변길이 내가 길이 넣고싶은대로 하는거
		
		
				System.out.println("아이디를 입력하세요");
				String inputid=scanner.next();
					if(id.equals(inputid)) {
						System.out.println("비밀번호를 입력하세요");
						String inputpassword=scanner.next();
						if(password.equals(inputpassword)) {
							System.out.println("로그인에 성공하였습니다;;;;");
							

		
				while(true) {//표출력
						System.out.println("번호\t대여여부\t도서장르\t도서명");
						for(int i=0; i<bookList.size(); i++) {
							System.out.printf(i+"\t"+(bookList.get(i).state ? "가능":"불가능")+"\t"+bookList.get(i).jangre+"\t"+bookList.get(i).name);
						}

						
						System.out.println("1.도서대여 2.도서반납 3.도서등록");
						int ch= scanner.nextInt();
						if(ch==1) {//1.도서대여
							System.out.println("========대여페이지==========");
							System.out.println("대여할 도서번호를 입력하세요");
							int bno=scanner.nextInt();
								if( bookList.get(bno).state==true) {
									//만약에 입력한 도서인덱스의 도서상태가 true이면 가능한 상태
									System.out.println("[알림] 대여완료");
									bookList.get(bno).state=false;	//대여중으로 변경
								}else {
									System.out.println("[알림]대여중인 도서입니다");
								}
								
							
							
							
						}else if(ch==2) {//도서반납
							System.out.println("========도서반납==========");	
							System.out.println("반납 할 도서번호를 입력하세요");
								int bno=scanner.nextInt();	
								if(bookList.get(bno).state==false) {
									System.out.println("[알림]반납완료");
									bookList.get(bno).state=true;
								}else {
									System.out.println("[알림] 대여한 도서가 아닙니다");
								}
							
							
								
								
								
								
						}else if(ch==3) {//도서등록
							//변수3개 입력
							System.out.println("========도서등록==========");	
							System.out.println("도서명을 입력하세요");	String inputname=scanner.next();
							System.out.println("도서장르를 입력하세요");	String inputjangre=scanner.next();
																	boolean basicState=true;
																	
							//서로 다른 자료형의 변수들을 하나의 자료형으로 만들어라!!!! 
										Book book =new Book();
										book.name=inputname;
										book.jangre=inputjangre;
										book.state= basicState;
										bookList.add(book);
										
								}
							
						else {System.out.println("번호를다시 선택하세요");}
					}	
				}				
					
			}//while e			
	}//main e
	
	
}//class e
