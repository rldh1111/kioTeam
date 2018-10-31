package user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Connection.ConnectionProvider;

import user.dao.UserDao;
import user.model.User;

public class UserListService {
	private static UserListService instance = new UserListService();

	public static UserListService getInstance() {
		return instance;
	}

	private UserListService() {
	}

	private int size = 10;
	private int blockSize = 5;

	public UserPage UserList(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			UserDao userDao = UserDao.getInstance();
			int total = userDao.selectCount(conn);
			List<User> users = userDao.selectUser(conn, (pageNum - 1) * size, size);
			return new UserPage(users, pageNum, total, size, blockSize);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
