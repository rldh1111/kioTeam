package user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public ArrayList<User> selectList() {
		try (Connection conn = ConnectionProvider.getConnection()) {
			UserDao userDao = UserDao.getInstance();
			ArrayList<User> users = userDao.selectAll(conn);
			return users;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
