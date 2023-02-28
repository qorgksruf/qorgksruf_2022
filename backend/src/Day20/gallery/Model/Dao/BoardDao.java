package Day20.gallery.Model.Dao;

public class BoardDao extends Dao{
	//싱글톤
	private static BoardDao dao = new BoardDao();
	private BoardDao() { }
	public static BoardDao getInstance( ) {
		return dao;
	}
}
