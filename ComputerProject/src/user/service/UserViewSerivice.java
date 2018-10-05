package user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.exception.UserNotFoundException;
import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

public class UserViewSerivice {
	private static UserViewSerivice instance = new UserViewSerivice();

	public static UserViewSerivice getInstance() {
		return instance;
	}

	private UserViewSerivice() {
	}

	public User selectUser(int userId) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			UserDao userDao = UserDao.getInstance();
			User user = userDao.SelectByUserId(conn, userId);
			if (user == null) {
				System.out.println();
				throw new UserNotFoundException("유저가 없음");
			}
			return user;
		} catch (SQLException e) {
			throw new RuntimeException();
		} catch (UserNotFoundException e) {
			throw e;
		}
	}
}
