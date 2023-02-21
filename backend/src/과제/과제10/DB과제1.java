package 과제.과제10;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DB과제1 {
	/*과제10
	1. MYSQL 워크벤치  'DB과제1' 이름으로 DB 생성한다.
	2. JAVA 에서 'DB과제1' 클래스 생성한다.

	3. 실행 메뉴
		1. DB연결 2.SQL구문 작성 3.매개변수 입력

	4. 
		1선택시  - 'DB과제1' 이름의 DB와 연결한다.
		2선택시 - console에서 SQL 작성할수 있도록 하여 아래와 같이 table 생성한다. 
			제품 테이블( 제품번호[정수] , 제품명[20] , 제품설명[100] , 제품가격[정수 );
		3선택시 - 제품번호 , 제품명 , 제품설명 , 제품가격 을 각각 입력받아 입력받은 데이터로 DB에 저장한다. [ 제품 3개 등록 ]

	5. 어떤한 경우에도 프로그램이 종료 되지 않도록 예외처리 한다.
	*/
	
	
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Connection com=null;
		while(true) {
			try {	
					System.out.println("1. DB연결 2.SQL구문작성 3.매개변수 입력 ");
					int ch=scanner.nextInt();
					
					if(ch==1) {//db연결
						System.out.println("---연동할 db명 입력;;");
						String dbname=scanner.next();
						System.out.println(dbname+"에 연결합니다");
						
						com= DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/"+dbname, "root", "1234");		
						System.out.println("연결성공");
						
					}else if(ch==2) {
						System.out.println("--sql구문입력");
						scanner.nextLine();
						String sql = scanner.nextLine();
						
						PreparedStatement ps = com.prepareStatement(sql);
						
						ps.execute();
						
					}else if(ch==3) {
						System.out.println("제품번호 ");
						int pno= scanner.nextInt();
						System.out.println("제품명");
						String pid=scanner.next();
						System.out.println("제품설명");
						String pcontent =scanner.next();
						System.out.println("제품가격");
						int pprice=scanner.nextInt();
						
						String sql="insert into product value(?, ?, ? ,?);";
						PreparedStatement ps = com.prepareStatement(sql);
					
						ps.setInt(1, pno);
						ps.setString(2, pid);
						ps.setString(3, pcontent);
						ps.setInt(4, pprice);
						
						ps.executeUpdate();
					}			
					
				
			}catch(Exception e) {
				System.out.println("db연결 후 다시실행"+e);
			}
		}//while e
	}//main e
}
