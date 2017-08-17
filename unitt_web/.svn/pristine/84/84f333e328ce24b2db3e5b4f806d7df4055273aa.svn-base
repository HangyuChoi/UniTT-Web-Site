package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.BoardBean;
import db.DBAction;
import util.JdbcUtil;

public class BoardDao {
	String str;
	
	public Connection getConnection(){
		Connection conn = DBAction.getInstance().getConnection();
		return conn;
	}
	
	public String writeDao(BoardBean bean) throws SQLException{
		String sql = "insert into unitt_courseboard (courseboard_idx,member_id,"
				+ "category,title,content,image,shot_introduce,plan,wdate,board_count)"
				+ " values (courseboard_idx.nextVal,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getMember_id());
			pstmt.setString(2, bean.getCategory());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getContent());
			pstmt.setString(5, bean.getImage());
			pstmt.setString(6, bean.getShot_introduce());
			pstmt.setString(7, bean.getPlan());
			pstmt.setString(8, bean.getWdate());
			pstmt.setInt(9, 0);
			
			int result = pstmt.executeUpdate();			
			str = result > 0 ? "success" : "fail";
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return str;
	}
}
