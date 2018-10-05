package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

//pw 찾는 서비스
public class FindPwService {
	private static FindPwService instance = new FindPwService();

	private FindPwService() {
	}

	public static FindPwService getInstance() {
		return instance;
	}
	
	public User FindPw(String loginId, String phone, String email, String question, String answer) throws SQLException {
		UserDao userDao = UserDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			User user = userDao.selectPwByName(conn, loginId, phone, email,
					question, answer);
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

}
