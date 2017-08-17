package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import bean.SearchBean;
import db.DBAction;
import util.JdbcUtil;


public class SearchDao {
	static ArrayList<SearchBean> arrSave;

	public Connection getConnection() {
		Connection conn = DBAction.getInstance().getConnection();
		return conn;
	}

	// 카테고리 검색 ( 목록만  )
	public Map<Integer, Map> searchDao(String search) throws SQLException {
		SearchBean bean;
		//ArrayList<CategoryBean> arr = new ArrayList<CategoryBean>();
		arrSave = new ArrayList<SearchBean>();
		String sql = "SELECT * FROM unitt_courseboard WHERE title LIKE '%"+search+"%'";
		Statement stmt = null;
		ResultSet rs = null;
		Map<String, String> childMap = new Hashtable<String, String>();
		Map<Integer, Map> parentMap = new Hashtable<Integer, Map>();
		try {
			Connection conn = getConnection();
			stmt = conn.createStatement();			
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				bean = new SearchBean();
				bean.setCourseboard_idx(rs.getInt("courseboard_idx"));
				bean.setMember_id(rs.getString("member_id"));
				bean.setName(rs.getString("name"));
				bean.setCategory(rs.getString("category"));
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setImage(rs.getString("image"));
				bean.setShot_introduce(rs.getString("shot_introduce"));
				bean.setPlan(rs.getString("plan"));
				//arr.add(bean);
				arrSave.add(bean);
			}
			// 2차원 배열로 만들기
			for(int i = 0; i <= arrSave.size()-1; i++) {
				childMap = new Hashtable<String, String>();
				childMap.put(arrSave.get(i).getTitle(), arrSave.get(i).getName());
				parentMap.put(arrSave.get(i).getCourseboard_idx(), childMap);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return parentMap;
	}

	// 강좌게시판 data 가져오기 ( 리스트에서 제목 클릭 )
	public ArrayList<SearchBean> selectDao(String pageNum) throws SQLException {
		SearchBean bean;
		int pageNum2 = Integer.parseInt(pageNum);
		ArrayList<SearchBean> arr = new ArrayList<SearchBean>();
		System.out.println(arrSave.get(0).getPlan());
		for(int i = 0; i < arrSave.size(); i++) {
			if(pageNum2 == arrSave.get(i).getCourseboard_idx()) {
				bean = new SearchBean();
				bean.setCourseboard_idx(arrSave.get(i).getCourseboard_idx());
				bean.setMember_id(arrSave.get(i).getMember_id());
				bean.setName(arrSave.get(i).getName());
				bean.setCategory(arrSave.get(i).getCategory());
				bean.setTitle(arrSave.get(i).getTitle());
				bean.setContent(arrSave.get(i).getContent());
				bean.setImage(arrSave.get(i).getImage());
				bean.setShot_introduce(arrSave.get(i).getShot_introduce());
				bean.setPlan(arrSave.get(i).getPlan());
				arr.add(bean);
			}
		}
		return arr;
	}
}
