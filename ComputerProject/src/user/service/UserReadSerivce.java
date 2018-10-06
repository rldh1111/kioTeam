package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.UserNotFoundException;
import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

public class UserReadSerivce {
	private static UserReadSerivce instance = new UserReadSerivce();

	public static UserReadSerivce getInstance() {
		return instance;
	}

	private UserReadSerivce() {
	}

	public User readUser(int userId) {
		UserDao userDao = UserDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			User user = userDao.SelectByUserId(conn, userId);
			if (user == null) {
				throw new UserNotFoundException("유저가 없음");
			}
			return user;
		} catch (UserNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}
}
