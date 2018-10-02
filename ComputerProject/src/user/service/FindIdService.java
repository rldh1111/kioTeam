package user.service;

import java.sql.Connection;
import java.sql.SQLException;


import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;


//Id찾는 서비스
public class FindIdService {
	private static FindIdService instance = new FindIdService();

	private FindIdService() {
	}

	public static FindIdService getInstance() {
		return instance;
	}

	public User FindId(String name, String phone, String email, String question, String answer) throws SQLException {
		UserDao userDao = UserDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			User user = userDao.selectIdByName(conn, name, phone, email,
					question, answer);
			
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
}
