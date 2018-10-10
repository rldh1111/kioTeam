package payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import payment.service.PaymentRequest;

public class PaymentDao {
	private static PaymentDao instance = new PaymentDao();
	private PaymentDao() {
		
	}
	public static PaymentDao getInstance() {
		return instance;
	}
	
	public void insert(Connection conn, PaymentRequest pr) throws SQLException {
		String sql = "insert into payment(paymentId, productId, productName, numbers, loginId, userName, address, phone) values(?,?,?,?,?,?,?,?)";
		try(PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1,pr.getPaymentId());
			pst.setInt(2,pr.getProductId());
			pst.setString(3,pr.getProductName());
			pst.setInt(4,pr.getNumbers());
			pst.setString(5,pr.getLoginId());
			pst.setString(6,pr.getUserName());
			pst.setString(7,pr.getAddress());
			pst.setString(8,pr.getPhone());
			pst.executeUpdate();
		}
	}
}
