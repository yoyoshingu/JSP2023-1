package news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {

	Connection conn = null;
	PreparedStatement pstmt;

	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	
	public Connection open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "sa","");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public News getNews(int aid) throws SQLException{
		Connection conn = open();
		News n = new News();
		
		String sql = "SELECT * FROM GROUPNEWS WHERE AID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		try(conn; pstmt; rs){
			n.setAid(rs.getInt("aid"));
			n.setTitle(rs.getString("title"));
			n.setImg(rs.getString("img"));
			n.setDate(rs.getString("date"));
			n.setContent(rs.getString("content"));	
			pstmt.executeQuery();
			return n;
		}
	}
	
	public void addNews(News n)throws Exception{
		Connection conn = open();
		String sql = "INSERT INTO GROUPNEWS(title, img, date, content)"
				+ "values(?, ?, CURRENT_TIMESTAMP(), ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try(conn; pstmt){
			pstmt.setString(1,  n.getTitle());
			pstmt.setString(2, n.getImg());
			pstmt.setString(3, n.getContent() );
			pstmt.executeUpdate();
		}
				
	}
	
	public List<News> getAll() throws Exception{
		Connection conn = open();
		List <News> newslist = new ArrayList<>();
		
		String sql = "SELECT * FROM GROUPNEWS";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try(conn; pstmt; rs){
			while(rs.next()) {
				News n = new News();
				n.setAid(rs.getInt("aid"));
				n.setTitle(rs.getString("title"));
				n.setDate(rs.getString("date"));
				newslist.add(n);
			}
		}
		return newslist;
	}
	
	public void delNews(int aid)throws SQLException{
		Connection conn = open();
		String sql = "DELETE FROM GROUPNEWS WHERE AID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt){
			pstmt.setInt(1, aid);
			if(pstmt.executeUpdate() == 0) {
				throw new SQLException("DB에러: 삭제되지 않음");
			}
		}

  }

}