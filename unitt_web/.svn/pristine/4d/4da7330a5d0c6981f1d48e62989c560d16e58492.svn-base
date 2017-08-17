package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.CategoryBean;
import bean.MemberBean;
import db.DBAction;
import util.JdbcUtil;

public class MemberDao {
	String str;

	public Connection getConnection() {
		Connection conn = DBAction.getInstance().getConnection();
		return conn;
	}

	// register
	public String registerDao(MemberBean bean) throws SQLException {
		String sql = "insert into unitt_member values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getPhone_number());
			pstmt.setString(5, bean.getEmail());
			pstmt.setString(6, bean.getQuestion());
			pstmt.setString(7, bean.getAnswer());
			pstmt.setString(8, bean.getInterest());
			pstmt.setString(9, bean.getIntroduce());
			int result = pstmt.executeUpdate();
			str = result > 0 ? "success" : "fail";
		} finally {
			JdbcUtil.close(pstmt);
		}
		return str;
	}

	// login
	public String loginDao(String id, String pw) throws SQLException {
		String sql = "select id, password,name from unitt_member where id = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String name = null;
		try {
			Connection conn = getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			// id, pw
			if (rs.next()) {
				if (pw.equals(rs.getString("password"))) {
					str = "success";
					name = rs.getString("NAME");
				} else {
					str = "password fail";
				}
			} else {
				str = "id fail";
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return name;

	}

	// modify select data
	public ArrayList<MemberBean> modifyCheckDao(String id) throws SQLException {
		ArrayList<MemberBean> arr = new ArrayList<MemberBean>();
		MemberBean dbData = null;
		String sql = "select * from unitt_member where id=?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbData = new MemberBean();
				dbData.setId(rs.getString("id"));
				dbData.setPassword(rs.getString("password"));
				dbData.setName(rs.getString("name"));
				dbData.setPhone_number(rs.getString("phone_number"));
				dbData.setEmail(rs.getString("email"));
				dbData.setQuestion(rs.getString("question"));
				dbData.setAnswer(rs.getString("answer"));
				dbData.setInterest(rs.getString("interest"));
				dbData.setIntroduce(rs.getString("introduce"));
				arr.add(dbData);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return arr;
	}

	// modify update
	public String updateDao(MemberBean bean) throws SQLException {
		String sql = "update unitt_member set password = ?, name = ?, phone_number = ?, "
				+ "email = ?, question = ?, answer = ?, interest = ?, introduce = ? where id = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getPassword());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPhone_number());
			pstmt.setString(4, bean.getEmail());
			pstmt.setString(5, bean.getQuestion());
			pstmt.setString(6, bean.getAnswer());
			pstmt.setString(7, bean.getInterest());
			pstmt.setString(8, bean.getIntroduce());
			pstmt.setString(9, bean.getId());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				str = "success";
			} else {
				str = "fail";
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
		return str;
	}

	// delete check
	public MemberBean withdrawCheckDao(String id) throws SQLException {
		MemberBean dbData = null;
		String sql = "select * from unitt_member where id=?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbData = new MemberBean();
				dbData.setId(rs.getString("id"));
			}

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return dbData;
	}

	public String withdrawDao(String id, String pw) throws SQLException {
		String sql = "select * from unitt_member where id = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (pw.equals(rs.getString("password"))) {
					str = delete(id);
				} else {
					str = "fail";
				}
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return str; // WithdrawService  str
	}

	// withdraw.jsp - withdrawDao()
	public String delete(String id) throws SQLException {
		String sql = "delete from unitt_member where id = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				str = "success";
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return str; // withdrawDao() str
	}
}
