package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.LoginFailException;
import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

public class LoginService {
	private static LoginService instance = new LoginService();

	public static LoginService getInstance() {
		return instance;
	}

	private LoginService() {
		System.out.println();
	}

	public User login(String loginId, String password) {
		UserDao userDao = UserDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			User user = userDao.selectByLoginId(conn, loginId);
			if (user == null) {
				throw new LoginFailException("없는 사용자");
			}
			if (!user.matchPassword(password)) {
				throw new LoginFailException("비밀번호가 틀림");
			}
			return user;
		} catch (LoginFailException e) {
			throw e;
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}
}
