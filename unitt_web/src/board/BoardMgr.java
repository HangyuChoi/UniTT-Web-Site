package board;

import java.sql.*;
import java.util.ArrayList;

import db.DBAction;



/*  DAO 기능 ( DB 업무적 처리를 매니저가 담당  )  */
public class BoardMgr {
	private static BoardMgr instance = new BoardMgr(); // 싱글 톤
	private String sql;
	private int rowCount;
	private int pageCount;
	private int confirm;
	private boolean insert_confirm;
	private DBAction db;
	private BoardData bd;
	private boolean information;

	public BoardMgr() {
		db = DBAction.getInstance();
	}
	public static BoardMgr getInstance() {
		if(instance == null)
			instance = new BoardMgr();
		return instance;
	}
//	public int getPageCount() throws SQLException {
//		rowCount = 0;
//		pageCount = 0;
//
//		return 0;
//	}

	// 게시물 입력
	public boolean insertBoardData(BoardData bd) throws SQLException {
		int maxgno = 0;
		sql = "select max(gno) from board_list";
		// max 는 해당 컬럼의 최대 값을 가져온다.
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				maxgno = rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			//if(conn != null) conn.close();
		}
		// mysql
/*		sql = "insert into board_list(gno, ono, nested, id, name,"
				+ " title, content, wdate, readno, pseq, reply)"
				+ " value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	*/

		// oracle
		 sql = "insert into board_list(board_num, gno, ono, nested, id, name,"
		            + " title, content, wdate, readno, pseq, reply)"
		            + " values(board_num.nextVal,?,?,?,?,?,?,?,?,?,?,?)";

		      PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
		      pstmt.setInt(1,(maxgno + 1));
		      pstmt.setInt(2, 0);
		      pstmt.setInt(3, 0);
		      pstmt.setString(4, bd.getId());
		      pstmt.setString(5, bd.getName());
		      pstmt.setString(6, bd.getTitle());
		      pstmt.setString(7, bd.getContent());
		      pstmt.setString(8, bd.getWdate());
		      pstmt.setInt(9, 0);
		      pstmt.setInt(10, 0);
		      pstmt.setInt(11, 0);
		      confirm = pstmt.executeUpdate();
		      insert_confirm = confirm == 1 ? true : false;
		      return insert_confirm;
	}


	// 게시판 목록
	public BoardData selectBoardData(int no, boolean inc) throws Exception {
		sql = "select * from board_list where board_num=" + no;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				bd = new BoardData();
				bd.setNum(rs.getInt(1));
				bd.setGroup(rs.getInt(2));
				bd.setOrder(rs.getInt(3));
				bd.setNested(rs.getInt(4));
				bd.setId(rs.getString(5));
				bd.setName(rs.getString(6));
				bd.setTitle(rs.getString(7));
				bd.setContent(rs.getString(8));
				bd.setWdate(rs.getString(9));
				bd.setReadno(rs.getInt(10));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		if(inc && information) { // 조회 확인
			// 조회수 1 증가
			sql = "update board_list set readno=readno + 1 "
					+ "where board_num =" + no;

			try {
				stmt = conn.createStatement();
				confirm = stmt.executeUpdate(sql);
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				if(stmt != null) stmt.close();
				//if(conn != null) conn.close();
			}

			//bean
			bd.setReadno(bd.getReadno() + 1);
			information = false; // 조회 off      중복 배제
		}
		return bd;
	}

	// 게시판 수정
	public void updateBoardData(BoardData bd) throws SQLException{
	      sql = "update board_list set title = '" +bd.getTitle()
	            +"', wdate='" + bd.getWdate() +"', content='" +bd.getContent()
	            +"' where board_num = " +bd.getNum();

	      Connection conn = null;
	      Statement stmt = null;
	      try{
	         conn = db.getConnection();
	         stmt = conn.createStatement();
	         confirm = stmt.executeUpdate(sql);
	      } catch(SQLException e){
	         e.printStackTrace();
	      } finally{
	         if(stmt != null) stmt.close();
	         //if(conn != null) conn.close();
	      }
	   }

	// 게시판 페이지 처리
	public int getPageCount() throws SQLException {
		rowCount = 0;
		pageCount = 0;
		sql = "select count(*) from board_list";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = db.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				rowCount = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			//if(conn != null) conn.close();
		}
		pageCount = rowCount / 15;
		if(rowCount % 10 > 0) pageCount++;	// 게시물 갯수가 15가 넘어가면 pageCount를 증가시켜서 다음페이지로 넘겨라.
		return pageCount;
	}

	// 게시물 가져오기
	public BoardData[] selectBoardDataList(int show_num) throws Exception {
		information = true; // 조회 on
		BoardData[] bdList;
		BoardData data;
		ArrayList arr = new ArrayList();
		// show_num = 2
		int start = 10 * (show_num -1); // 시작 게시물 ex) 0, 15, 30, 45 ...
		int end = show_num * 10; // 범위 (몇개 단위)

		// mysql
		/*sql = "select * from board_list order by "
				+ "gno desc, ono asc limit " + start + "," + end;*/

		 sql = "select * from (select a.*, rownum rseq from "
		            + "(select * from board_list order by gno desc, ono asc)a)"
		            + "where rseq > " +start +" and rownum <= "+end;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = db.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				data = new BoardData();
				data.setNum(rs.getInt("board_num"));
				data.setGroup(rs.getInt("gno"));
				data.setOrder(rs.getInt("ono"));
				data.setNested(rs.getInt("nested"));
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWdate(rs.getString("wdate"));
				data.setReadno(rs.getInt("readno"));
				data.setPseq(rs.getInt("pseq"));
				data.setReply(rs.getInt("reply"));
				arr.add(data);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			//if(conn != null) conn.close();
		}
		bdList = new BoardData[arr.size()];
		for(int i = 0; i < bdList.length; i++) {
			bdList[i] = (BoardData)arr.get(i);
		}
		return bdList;

	}

	// 댓글 등록
	   public void insertBoardData(int group, int order, int nested, BoardData bd) throws SQLException{
	      sql = "update board_list set ono ="
	            + "ono + 1 where gno = "
	            + group + " and ono > " +order;
	      Connection conn = null;
	      Statement stmt = null;
	      try{
	         conn = db.getConnection();
	         stmt = conn.createStatement();
	         confirm = stmt.executeUpdate(sql);
	      } catch(SQLException e){
	         e.printStackTrace();
	      } finally{
	         if(stmt != null) stmt.close();
	      }
	      sql = "insert into board_list(board_num, gno, ono, nested, id, name, title,"
	            + "content, wdate, readno, pseq, reply) values(board_num.nextVal, "
	            + group +"," +(order + 1) +"," +(nested + 1) +",'" +bd.getId() +"','"
	            + bd.getName() +"','" +bd.getTitle() +"','" +bd.getContent() +"','" +bd.getWdate()
	            + "'," +0 +"," +0 +"," +0 +")";
	      try{
	         stmt = conn.createStatement();
	         confirm = stmt.executeUpdate(sql);
	      } catch(SQLException e){
	         e.printStackTrace();
	      }
	   }

	   // 게시물 삭제
	   public void deleteBoardData(int no) throws Exception{
	      sql = "select gno, ono, nested from board_list "
	            + "where board_num=" +no;

	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      try{
	         conn = db.getConnection();
	         stmt = conn.createStatement();
	         rs = stmt.executeQuery(sql);

	         if(rs.next()){
	            int group = rs.getInt(1);
	            int order = rs.getInt(2);
	            int nested = rs.getInt(3);

	            if(rs != null) rs.close();
	            if(stmt != null) stmt.close();

	            sql = "delete from board_list where board_num="+no;
	            stmt = conn.createStatement();
	            confirm = stmt.executeUpdate(sql);
	            if(stmt != null) stmt.close();

	            sql = "delete from board_list where gno=" +group +
	                " and ono >=" + order + " and nested > " +nested;
	            stmt = conn.createStatement();
	            confirm = stmt.executeUpdate(sql);
	            if(stmt != null) stmt.close();

	            sql = "update board_list set ono = ono - 1 "
	                  + "where gno = " +group +" and ono > " +order;
	            stmt = conn.createStatement();
	            confirm = stmt.executeUpdate(sql);
	         }
	      } catch(Exception e){
	         e.printStackTrace();
	      } finally{
	         if(rs != null) rs.close();
	         if(stmt !=null) stmt.close();
	      }
	   }
	// 오버로드
//	public void insertBoardData(int a) {
//
//	}
}
