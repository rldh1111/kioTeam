package payment.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.Connection.ConnectionProvider;
import payment.dao.PaymentDao;
import shopping.model.Shopping;

public class PaymentService {
	private static PaymentService instance = new PaymentService();

	public static PaymentService getInstance() {
		return instance;
	}

	private PaymentService() {

	}
	
	public void payment(PaymentRequest pr) {
		PaymentDao paymentDao = PaymentDao.getInstance();
		try(Connection conn = ConnectionProvider.getConnection()){
			paymentDao.insert(conn, pr);
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
}
