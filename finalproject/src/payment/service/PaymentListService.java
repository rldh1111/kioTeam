package payment.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.Connection.ConnectionProvider;
import payment.dao.PaymentDao;
import payment.model.Payment;


public class PaymentListService {
	private static PaymentListService instance = new PaymentListService();

	public static PaymentListService getInstance() {
		return instance;
	}

	private PaymentListService() {

	}

	private int size = 10;
	private int blockSize = 5;
	
	public PaymentPage paymentList(int pageNum) {
		PaymentDao paymentDao = PaymentDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = paymentDao.selectCount(conn);
			ArrayList<Payment> payments = paymentDao.selectList(conn, (pageNum - 1) * size, size);
			return new PaymentPage(payments, pageNum, total, size, blockSize);
		}catch(SQLException e) {
			throw new RuntimeException();
		}

	}
}
