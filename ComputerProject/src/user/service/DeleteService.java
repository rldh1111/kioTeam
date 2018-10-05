package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.UserNotFoundException;
import common.exception.UserNotFountException;
import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

public class DeleteService {
	private static DeleteService instance = new DeleteService();

	public static DeleteService getInstance() {
		return instance;
	}

	private DeleteService() {
		System.out.println();
	}

	public void delete(int userId) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			UserDao userDao = UserDao.getInstance();
			try {
				conn.setAutoCommit(false);
				User user = userDao.SelectByUserId(conn, userId);
				if (user == null) {
					throw new UserNotFoundException("없는 유저입니다");
				}
				userDao.delete(conn, userId);
				conn.commit();
			} catch (UserNotFountException e) {
				conn.rollback();
				throw e;
			} catch (SQLException e) {
				conn.rollback();
				throw new RuntimeException();
			}

		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
