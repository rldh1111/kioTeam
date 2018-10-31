package payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import payment.model.Payment;
import payment.service.PaymentRequest;
import product.model.Product;

public class PaymentDao {
	private static PaymentDao instance = new PaymentDao();

	private PaymentDao() {

	}

	public static PaymentDao getInstance() {
		return instance;
	}

	public void insert(Connection conn, PaymentRequest payment) throws SQLException {
		String sql = "insert into payment(userId, userName, productId, productName, count, price, address, phone, url) values(?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, payment.getUserId());
			pst.setString(2, payment.getUserName());
			pst.setInt(3, payment.getProductId());
			pst.setString(4, payment.getProductName());
			pst.setInt(5, payment.getCount());
			pst.setInt(6, payment.getPrice());
			pst.setString(7, payment.getAddress());
			pst.setString(8, payment.getPhone());
			pst.setString(9, payment.getUrl());
			pst.executeUpdate();
		}
	}

	public ArrayList<Payment> selectList(Connection conn, int startRow, int size) throws SQLException {
		String sql = "select * from payment order by paymentId desc limit ?, ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, startRow);
			pst.setInt(2, size);

			try (ResultSet rs = pst.executeQuery()) {
				ArrayList<Payment> payments = new ArrayList<Payment>();
				while (rs.next()) {
					payments.add(makePayment(rs));

				}
				return payments;
			}
		}
	}

	public ArrayList<Payment> selectUserList(Connection conn, int userId, int startRow, int size) throws SQLException {
		String sql = "select * from payment where userId = ? order by paymentId desc limit ?, ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, userId);
			pst.setInt(2, startRow);
			pst.setInt(3, size);
			try (ResultSet rs = pst.executeQuery()) {
				ArrayList<Payment> payments = new ArrayList<Payment>();
				while (rs.next()) {
					payments.add(makePayment(rs));
				}
				return payments;
			}
		}
	}

	public int selectCount(Connection conn) throws SQLException {
		String sql = "select count(*) from payment";
		try (Statement st = conn.createStatement()) {
			try (ResultSet rs = st.executeQuery(sql)) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
			return 0;
		}
	}

	public Payment makePayment(ResultSet rs) throws SQLException {
		Payment payment = new Payment(rs.getInt("paymentId"), rs.getInt("userId"), rs.getString("userName"),
				rs.getInt("productId"), rs.getString("productName"), rs.getInt("count"), rs.getInt("price"),
				rs.getString("address"), rs.getString("phone"), rs.getTimestamp("wdate").toLocalDateTime(),
				rs.getString("url"));
		return payment;
	}
}
