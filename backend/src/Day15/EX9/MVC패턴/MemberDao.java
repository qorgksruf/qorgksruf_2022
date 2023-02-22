package Day15.EX9.MVC패턴;

import java.sql.*;
import java.util.ArrayList;




public class MemberDao {
	
	//DB 연동코드- > 싱글톤으로 
	
	//싱글톤 객체 만들기
	private static MemberDao dao=new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}

	
		//필드
		//DriverManager.getConnection() 해당 db주소와 연결 성공시 성공한 db구현객체 반환
		private Connection conn;	//1.db연결된 구현객체를 받아서 다양한 메소드 제공
		private PreparedStatement ps; //2.연결된 sql조작 메소드 제공[? 매개변수 사용]
		private ResultSet rs;		//3. sql결과 조작 메소드 제공 인터페이스
		
		
		
		private MemberDao() {
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/day15","root","1234");
				System.out.println("[연동성공]");
			}
			catch (Exception e) {
					System.out.println(e.getMessage());
			}
			
		}
		
		//sql 처리 메소드
		//회원가입 메소드[ 인수는 뭐? 표만든거 id,pw 반환은 뭐? 성공실패]
		//인수 Dto(id,pw) 으로 반환은 true로 받을거니까 boolean
		public boolean signup(MemberDto dto) {
				String sql ="insert into member (mid,mpw) values(?,?)";
				//연동 db에 sql 대입한다
				try {
				
					ps = conn.prepareStatement(sql);
					//ps는 매개변수에 대한 조작가능
					ps.setString(1, dto.getMid());
					ps.setString(2, dto.getMpw());
					//ps 가 sql실행
					ps.executeUpdate();
					//결과 반환
					return true; //여기까지 문제 없었으면 저장성공
					
				} catch (SQLException e) {
			
					System.out.println("DB오류"+e);
					return false; //try문제가 있으면 실행되는 구역-> 저장 실패
				}

				
		}
		
		//모든회원출력할거임 , 그리고 반환은 회원정보 여러명것 반환할예정, 회원모델링한게 dto/회원1명=dto객체 /회원여러명이면 [ArrayList 에 dto담기]
		public ArrayList<MemberDto> list(){
				//여러명의 회원dto 객체를 저장하기 위한 리스트 선언
			ArrayList<MemberDto>list = new ArrayList<>();
			
			//sql 작성 ->db한테 모든회원줭
			String sql="select  * from member";
			
			//연결된 db에 작성된 sql대입
			try {
				ps=conn.prepareStatement(sql);
				
			
				rs = ps.executeQuery();	//결과: 검색된 모든 레코드
				
				//레코드-->자바형테->객체dto//레코드 1개->dto 1개->회원1개
				while(rs.next()) {	//다음 레코드로 이동하겠다는뜻 [없으면 false 멈추게됨 즉 마지막 레코드까지 계속 돔]
					
					//레코드-->객체화시킴 [rs.get~~(필드순서번호) 자료형 맞추는거 필수]
					MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), rs.getNString(3));
					System.out.println("회원마다 "+dto);
					//1개의 객체를 리스트에 담기 그래야 또 다음 while로 가서 또 하나더하고 한줄씩 쌓여감
					list.add(dto);
				}
				
				System.out.println("회원목록;;;"+list.toString());
				return list;
				
			}catch (Exception e) {
				System.out.println("db오류");
			}
			//sql 조작
			return null;

		}
		
		
		//비밀번호수정[인수: 누구의[식별 mno] 비밀번호를 무엇으로[새로운 mpw] 바꿀건지 ///   반환:성공true 실패false]
		
		public boolean update(int mno, String mpw) {
			//sql 작성
			String sql="update member set mpw = ? where mno = ?";
			//db에 sql대입
			try {
				ps=conn.prepareStatement(sql);
				//sql조작
				ps.setString(1, mpw);
				ps.setInt(2, mno);
			//sql 실행
				ps.executeUpdate();
				
			//sql 결과
				return true;
			}
				catch (Exception e) {	//insert, update,deletye=> excute
				System.out.println("db오류");
				return false;
			}
		}
		
		//4.회원삭제 [ 인수: 누구의 회원[mno]을 삭제할껀지 /반환 :성공 실패 없는회원 이렇게 세개 받을거면 int로 두개정도면 boolean이 젤 좋음]
		public boolean delete(int mno) {
			//1.작성
			String sql= "delete from member shere mno = ?";	//1

			//2.연결
			
			try {
				ps=conn.prepareStatement(sql);	//2
				
				ps.setInt(1, mno);	//3
				
				ps.executeUpdate();	//insert ,update, delete는 rs안씀 //4
				
				return true;//5
				
			}catch (Exception e) {
				System.out.println("db오류");
				return false;
			}
			

		}
		
		
		
		
		

}//class e
