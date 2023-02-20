package Day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.PreparableStatement;


public class EX4_DB연동 {
			public static void main(String[] args) {
			
				
			try {	
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/java",	//java에서 db생성불가
						"root",
						"1234");

				System.out.println("[DB 연동 성공]"); 
				
				//1.table 생성하는 sql 구문을 문자열 변수에 저장
				String sql = "create table member(mno int, mid varchar(20), mpw varchar(20) )";
				
				//3. DML DDL 조작 인터페이스에 연결된 db연결구현객체에 sql 대입
				PreparedStatement ps = con.prepareStatement(sql);
				
				//4.SQL 실행
				ps.execute();
				
				
				
			}catch(Exception e) {
				System.out.println("DB연동실패 사유:"+e);
			}
		
	}
	
}

/*
 * 	JDBC : 자바와 DB연결 드라이브
 * 		-해당 DBMS 마다 라이브러리 [.JAR]파일 필요
 * 		-보관장소: C//MYSQL-CONNECTOR-JAVA-8.0.XX
 *	-1.라이브러리 추가
 *		1.프로젝트 오른쪽 클릭=> BUILD PATH
 *		2. Libraries 탭 에서 javaSe 버전 변경
 *			1.javaSE  - 1.8 일 경우 생략
 *			2. 더블클릭-> JAVASE- 1.8변경 ->apply
 *		  1.add External jars
 *		  2.MYSQL-CONNECTOR-JAVA-8.0.XX.jar 파일 찾아서 추가
 *	
 *	-2.
 *		Connection: DB연결 인터페이스
 *		DriverManager: DB 연결 클래스 구현 객체 제공
 *			DriverManager.getConnection(db주소 , 계정, 비밀번호)
 *				-일반예외 발생-> 예외처리 필수
 *				-mysql server주소: jdbc:mysql://ip주소: 포트번호/db명
 *			-mysql workbench에 java생성						
 *
 * */
 