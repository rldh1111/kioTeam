package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.UserNotFoundException;
import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

public class ModifyService {
	private static ModifyService instance = new ModifyService();

	public static ModifyService getInstance() {
		return instance;
	}

	private ModifyService() {
	}

	public void modify(ModifyRequest mr) {
		UserDao userDao = UserDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				conn.setAutoCommit(false);
				User user = userDao.SelectByUserId(conn, mr.getUserId());
				if (user == null) {
					throw new UserNotFoundException("유저가 없음");
				}
				userDao.update(conn, mr);
				conn.commit();
			} catch (UserNotFoundException e) {
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
