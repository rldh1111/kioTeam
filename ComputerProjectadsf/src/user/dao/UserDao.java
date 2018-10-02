package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.model.User;

public class UserDao {
	private static UserDao instance = new UserDao();

	private UserDao() {

	}

	public static UserDao getInstance() {
		return instance;
	}

	public User selectByLoginId(Connection conn, String loginId) throws SQLException { // 로그인 아이디가 겹치면 user를 반환해 joinService에서 user가 반환되었으면 	아이디 중복 에러										
		String sql = "select * from user where loginid = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, loginId);
			User user = null;
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					user = new User(rs.getString("userType"), rs.getString("name"), rs.getString("loginId"),
							rs.getString("password"), rs.getString("address"), rs.getString("email"),
							rs.getString("phone"),rs.getString("question"),rs.getString("answer"));
				}
			}
			return user;
		}
	}

	public int insert(Connection conn, User user) throws SQLException { // 회원 가입
		String sql = "insert into user(userType, loginId, name, password, address, email, phone, question, answer) values(? ,? ,? ,? ,? ,? ,? ,? ,?)";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, user.getUserType());
			pst.setString(2, user.getLoginId());
			pst.setString(3, user.getName());
			pst.setString(4, user.getPassword());
			pst.setString(5, user.getAddress());
			pst.setString(6, user.getEmail());
			pst.setString(7, user.getPhone());
			pst.setString(8, user.getQuestion());
			pst.setString(9, user.getAnswer());
			return pst.executeUpdate();
		}
	}

	public void update(Connection conn, User user) throws SQLException { // 회원정보수정
		String sql = "update user set name = ?, password = ?, address = ?, email = ?, phone = ? where userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getAddress());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPhone());
			pst.setInt(6, user.getUserId());
			pst.executeUpdate();
		}
	}
}
