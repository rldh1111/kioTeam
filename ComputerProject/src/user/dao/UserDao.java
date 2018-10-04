package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import user.model.User;
import user.service.ModifyRequest;

public class UserDao {
	private static UserDao instance = new UserDao();

	private UserDao() {
	}

	public static UserDao getInstance() {
		return instance;
	}

	public ArrayList<User> selectAll(Connection conn) throws SQLException {
		String sql = "select * from user";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			ArrayList<User> users = new ArrayList<User>();
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					users.add(makeUser(rs));
				}
			}
			return users;
		}
	}
	
	public User selectIdByName(Connection conn, String name, String phone, String email, String question, String answer)
			throws SQLException {
		String sql = "select loginId from user where name=? && phone=? && email=? && question=? && answer=?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			System.out.println(name);
			System.out.println(phone);
			System.out.println(email);
			System.out.println(question);
			System.out.println(answer);
			pst.setString(1, name);
			pst.setString(2, phone);
			pst.setString(3, email);
			pst.setString(4, question);
			pst.setString(5, answer);
			User user = null;
		
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					 user = new User(rs.getString("loginId"));
			
					
				}
				return user;
			}
			

		}

	}

	public User selectByLoginId(Connection conn, String loginId) throws SQLException {
		String sql = "select * from user where loginId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, loginId);
			User user = null;
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					user = makeUser(rs);
				}
			}
			return user;
		}
	}

	public User SelectByUserId(Connection conn, int userId) throws SQLException {
		String sql = "select * from user where userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, userId);
			User user = null;
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					user = makeUser(rs);
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

	public void update(Connection conn, ModifyRequest mr) throws SQLException { // 회원정보수정
		String sql = "update user set name = ?, password = ?, address = ?, email = ?, phone = ?, question = ?, answer = ? where userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, mr.getName());
			pst.setString(2, mr.getPassword());
			pst.setString(3, mr.getAddress());
			pst.setString(4, mr.getEmail());
			pst.setString(5, mr.getPhone());
			pst.setString(6, mr.getQuestion());
			pst.setString(7, mr.getAnswer());
			pst.setInt(8, mr.getUserId());
			pst.executeUpdate();
		}
	}

	public void delete(Connection conn, int userId) throws SQLException {
		String sql = "delete from user where userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, userId);
			pst.executeUpdate();
		}
	}

	private User makeUser(ResultSet rs) throws SQLException {
		User user = new User(rs.getInt("userId"), rs.getString("userType"), rs.getString("name"),
				rs.getString("loginId"), rs.getString("password"), rs.getString("address"), rs.getString("email"),
				rs.getString("phone"), rs.getString("question"), rs.getString("answer"),
				rs.getTimestamp("wdate").toLocalDateTime());
		return user;
	}
}
