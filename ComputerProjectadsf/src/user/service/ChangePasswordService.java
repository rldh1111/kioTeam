package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.InvalidPasswordException;
import common.exception.UserNotFountException;
import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

public class ChangePasswordService {
	private static ChangePasswordService instance = new ChangePasswordService();

	public static ChangePasswordService getInstance() {
		return instance;
	}

	private ChangePasswordService() {
	}

	// 비밀번호를 변경하기 위한 비지니스 로직을 수행
	// 로그인아이디, 현 비번, 새 비번을 인자로 받고
	// 그것을 통해서 비번이 제대로 되었는지, 현재 있는 사용자인지 확인하고
	// 로직을 수행한다.
	public void changePassword(String loginId, String oldPwd, String newPwd) {
		UserDao userDao = UserDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				conn.setAutoCommit(false);
				User user = userDao.selectByLoginId(conn, loginId);
				if (user == null) {
					throw new UserNotFountException("없는 유저");
				}
				// 잘못된 비밀번호를 입력했다면
				if (!user.matchPassword(oldPwd)) {
					throw new InvalidPasswordException("잘못된 비밀번호");
				}
				// 정상적으로 비번이 입력 되었다면
				// 업데이트에 보낼 객체의 비번을 새로 넣어줌
				user.setPassword(newPwd);
				userDao.update(conn, user);
				conn.commit();

			} catch (InvalidPasswordException e) {
				conn.rollback();
				throw new RuntimeException(e);
			} catch (UserNotFountException e) {
				conn.rollback();
				throw new RuntimeException(e);
			} catch (SQLException e) {
				conn.rollback();
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
