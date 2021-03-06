package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.DuplicateEmailException;
import common.exception.DuplicatePhoneException;
import common.exception.DuplicatieException;
import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

//회원 가입 처리하는 서비스
public class JoinService {
	private static JoinService instance = new JoinService();

	public static JoinService getInstance() {
		return instance;
	}

	private JoinService() {
	}

	public void join(JoinRequest joinReq) { // 아이디가 중복되는지 확인하고 아니면 insert로 user객체를 보내줌
		UserDao userDao = UserDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {

			try {
				conn.setAutoCommit(false);
				User user = userDao.selectByLoginId(conn, joinReq.getLoginId());
				if (user != null) {
					throw new DuplicatieException("아이디 중복");
				}
				User user1 =userDao.selectByEmail(conn, joinReq.getEmail());
				if (user1 != null) {
					throw new DuplicateEmailException("이메일 중복");
				}
				User user2 = userDao.selectByPhone(conn, joinReq.getPhone());
				if (user2 != null) {
					throw new DuplicatePhoneException("전화번호 중복");
				}
				userDao.insert(conn,
						new User(joinReq.getUserType(), joinReq.getName(), joinReq.getLoginId(), joinReq.getPassword(),
								joinReq.getAddress(), joinReq.getEmail(), joinReq.getPhone(), joinReq.getQuestion(),
								joinReq.getAnswer()));
				conn.commit();
			} catch (DuplicatieException e) {
				conn.rollback();
				throw e;
			} catch (SQLException e) {
				conn.rollback();
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
