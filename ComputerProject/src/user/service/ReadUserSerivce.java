package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.UserNotFoundException;
import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

public class ReadUserSerivce {
	private static ReadUserSerivce instance = new ReadUserSerivce();

	public static ReadUserSerivce getInstance() {
		return instance;
	}

	private ReadUserSerivce() {
		System.out.println();
		System.out.println();
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
