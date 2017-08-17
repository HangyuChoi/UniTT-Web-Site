package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import bean.VideoBean;
import db.DBAction;
import util.JdbcUtil;

public class VideoDao {
	String str;
	static ArrayList<VideoBean> arrSave;

	public Connection getConnection() {
		Connection conn = DBAction.getInstance().getConnection();
		return conn;
	}

	/*
	 * 이름 널 유형 --------------- -------- -------------- VIDEOLIST_IDX NOT NULL
	 * NUMBER COURSEBOARD_IDX NOT NULL NUMBER TITLE NOT NULL VARCHAR2(400)
	 * VIDEO_PATH VARCHAR2(200) CONTENT VARCHAR2(2000)
	 * 
	 * String videolist_idx; String courseboard_idx; String title; String
	 * video_path; String content;
	 */
	public String uploadVideoDao(ArrayList<VideoBean> arr) throws SQLException {
		String sql = "insert into unitt_videolist values(videolist_idx.nextVal,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			Connection conn = getConnection();
			for (int i = 0; i < arr.size(); i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, arr.get(i).getCourseboard_idx());
				pstmt.setString(2, arr.get(i).getTitle());
				pstmt.setString(3, arr.get(i).getVideo_path());
				pstmt.setString(4, arr.get(i).getContent());
				int result = pstmt.executeUpdate();
				str = result > 0 ? "success" : "fail";
				System.out.print("결과 : " + str);
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
		return str;
	}

	public Map<Integer, ArrayList> showVideoDao(int idx) throws SQLException {
		VideoBean bean;
		arrSave = new ArrayList<VideoBean>();
		String sql = "SELECT * FROM unitt_videolist WHERE courseboard_idx = ? ORDER BY videolist_idx ASC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer, ArrayList> parentMap = new Hashtable<Integer, ArrayList>();

		try {
			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new VideoBean();
				bean.setVideolist_idx(rs.getInt("videolist_idx"));
				bean.setCourseboard_idx(rs.getInt("courseboard_idx"));
				bean.setTitle(rs.getString("title"));
				bean.setVideo_path(rs.getString("video_path"));
				bean.setContent(rs.getString("content"));
				System.out.println("Video_path : " + bean.getVideo_path() + ", Content : " + bean.getContent());
				arrSave.add(bean);
			}
			// 2차원 배열로 만들기
			for (int i = 0; i <= arrSave.size() - 1; i++) {
				parentMap.put(arrSave.get(i).getVideolist_idx(), arrSave);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return parentMap;
	}

	// 동영상 data 가져오기 ( 리스트에서 제목 클릭 )
	public ArrayList<VideoBean> selectDao(String pageNum) throws SQLException {
		VideoBean bean;
		int pageNum2 = Integer.parseInt(pageNum);
		ArrayList<VideoBean> arr = new ArrayList<VideoBean>();
		for (int i = 0; i < arrSave.size(); i++) {
			if (pageNum2 == arrSave.get(i).getCourseboard_idx()) {
				bean = new VideoBean();
				bean.setVideolist_idx(arrSave.get(i).getVideolist_idx());
				bean.setTitle(arrSave.get(i).getTitle());
				bean.setVideo_path(arrSave.get(i).getVideo_path());
				bean.setContent(arrSave.get(i).getContent());
				arr.add(bean);
			}
		}
		return arr;
	}
}
