package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import bean.CategoryBean;
import bean.MemberBean;
import bean.VideolistBean;
import db.DBAction;
import util.JdbcUtil;



/*
 *
 *
 *            비디오 다오 작업 해야함.
 *
 *
 */
public class VideoDao_test {
	static ArrayList<VideolistBean> arrSave;

	public Connection getConnection() {
		Connection conn = DBAction.getInstance().getConnection();
		return conn;
	}
/*
	이름              널        유형
	--------------- -------- --------------
	VIDEOLIST_IDX   NOT NULL NUMBER
	COURSEBOARD_IDX NOT NULL NUMBER
	TITLE           NOT NULL VARCHAR2(400)
	VIDEO_PATH               VARCHAR2(200)
	CONTENT                  VARCHAR2(2000)

	String videolist_idx;
    String courseboard_idx;
    String title;
    String video_path;
    String content;
*/

	// 로그인
	public Map<Integer, ArrayList> showVideoDao(int idx) throws SQLException {
		VideolistBean bean;
		arrSave = new ArrayList<VideolistBean>();
		String sql = "SELECT * FROM unitt_videolist WHERE courseboard_idx = ? ORDER BY videolist_idx ASC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//Map<String, String> childMap = new Hashtable<String, String>();
		Map<Integer, ArrayList> parentMap = new Hashtable<Integer, ArrayList>();

		try {
			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bean = new VideolistBean();
				bean.setVideolist_idx(rs.getInt("videolist_idx"));
				bean.setCourseboard_idx(rs.getInt("courseboard_idx"));
				bean.setTitle(rs.getString("title"));
				bean.setVideo_path(rs.getString("video_path"));
				bean.setContent(rs.getString("content"));
				System.out.println("Video_path : "+bean.getVideo_path() +", Content : "+ bean.getContent());
				arrSave.add(bean);
			}
			// 2차원 배열로 만들기
			for(int i = 0; i <= arrSave.size()-1; i++) {
//				childMap = new Hashtable<String, String>();
//				childMap.put(arrSave.get(i).getTitle(), arrSave.get(i).getVideo_path());
				parentMap.put(arrSave.get(i).getVideolist_idx(), arrSave);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return parentMap;
	}

		// 동영상 data 가져오기 ( 리스트에서 제목 클릭 )
		public ArrayList<VideolistBean> selectDao(String pageNum) throws SQLException {
			VideolistBean bean;
			int pageNum2 = Integer.parseInt(pageNum);
			ArrayList<VideolistBean> arr = new ArrayList<VideolistBean>();
			//System.out.println(arrSave.get(0).getPlan());
			for(int i = 0; i < arrSave.size(); i++) {
				if(pageNum2 == arrSave.get(i).getCourseboard_idx()) {
					bean = new VideolistBean();
					bean.setVideolist_idx(arrSave.get(i).getVideolist_idx());
					//bean.setCourseboard_idx(rs.getInt("courseboard_idx"));
					bean.setTitle(arrSave.get(i).getTitle());
					bean.setVideo_path(arrSave.get(i).getVideo_path());
					bean.setContent(arrSave.get(i).getContent());
					arr.add(bean);
				}
			}
			return arr;
		}
}
