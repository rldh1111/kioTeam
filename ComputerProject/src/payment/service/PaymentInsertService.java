package payment.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.Connection.ConnectionProvider;
import payment.dao.PaymentDao;
import shopping.model.Shopping;

public class PaymentInsertService {
	private static PaymentInsertService instance = new PaymentInsertService();

	public static PaymentInsertService getInstance() {
		return instance;
	}

	private PaymentInsertService() {

	}
	
	public void payment(ArrayList<PaymentRequest> payments) {
		PaymentDao paymentDao = PaymentDao.getInstance();
		try(Connection conn = ConnectionProvider.getConnection()){
			for (int i = 0; i < payments.size(); i++) {
				paymentDao.insert(conn, payments.get(i));
			}
			
		}catch(SQLException e) {
			throw new RuntimeException();
		}
	}
}
