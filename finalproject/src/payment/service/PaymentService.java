package payment.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.Connection.ConnectionProvider;
import payment.dao.PaymentDao;
import payment.model.Payment;

public class PaymentService {
	private static PaymentService instance = new PaymentService();

	public static PaymentService getInstance() {
		return instance;
	}

	private PaymentService() {

	}

	public void payment(PaymentRequest pr) {
		PaymentDao paymentDao = PaymentDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				conn.setAutoCommit(false);
				paymentDao.insert(conn, pr);
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				throw new RuntimeException();
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
