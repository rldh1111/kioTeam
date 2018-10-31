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

	public void insert(Connection conn,PaymentRequest payments) throws SQLException {
		String sql = "insert into payment(productId, productName, numbers, loginId, userName, address, phone) values(?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, payments.getProductId());
			pst.setString(2, payments.getProductName());
			pst.setInt(3, payments.getNumbers());
			pst.setString(4, payments.getLoginId());
			pst.setString(5, payments.getUserName());
			pst.setString(6, payments.getAddress());
			pst.setString(7, payments.getPhone());
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
					payments.add(
							new Payment(rs.getInt("paymentId"), rs.getInt("productId"), rs.getString("productName"),
									rs.getInt("numbers"), rs.getInt("price"), rs.getInt("userId"), rs.getString("loginId"),
									rs.getString("userName"), rs.getString("address"), rs.getString("phone")));

				}
				return payments;
			}
		}
	}

	public ArrayList<Payment> selectUserList(Connection conn, int userId, int startRow, int size) throws SQLException {
		String sql = "select * from payment order by paymentId desc limit ?, ? where userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, startRow);
			pst.setInt(2, size);
			pst.setInt(3, userId);
			try (ResultSet rs = pst.executeQuery()) {
				ArrayList<Payment> payments = new ArrayList<Payment>();
				while (rs.next()) {
					payments.add(new Payment(rs.getInt("paymentId"), rs.getInt("productId"), rs.getString("productName"),
									rs.getInt("numbers"), rs.getInt("price"), rs.getInt("userId"), rs.getString("loginId"),
									rs.getString("userName"), rs.getString("address"), rs.getString("phone")));

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
}
