package shopping.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import product.model.Product;
import shopping.model.Shopping;
import user.model.User;

public class ShoppingDao {
	private static ShoppingDao instance = new ShoppingDao();

	private ShoppingDao() {
	}

	public static ShoppingDao getInstance() {
		return instance;
	}

	// 장바구니에 담는 프로시저 이미 제품이 있으면 수량만 추가
	public int insert(Connection conn, Shopping shopping) throws SQLException {
		String sql = "CALL insertbasket(?,?,?,?,?,?)";
		try (CallableStatement cbst = conn.prepareCall(sql)) {
			cbst.setInt(1, shopping.getProductId());
			cbst.setString(2, shopping.getProductType());
			cbst.setString(3, shopping.getLoginId());
			cbst.setString(4, shopping.getProductname());
			cbst.setInt(5, shopping.getPrice());
			cbst.setInt(6, shopping.getCount());
			return cbst.executeUpdate();
		}
	}

	// 물품 코드에 따른 삭제
	public int delete(Connection conn, int productId) throws SQLException {
		String sql = "delete from shoppingbasket where productId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, productId);
			return pst.executeUpdate();
		}
	}

	// 물품 코드에 따른 수정
	public int update(Connection conn, int productId, int count) throws SQLException {
		String sql = "update shoppingbasket set count=? where productId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, count);
			pst.setInt(2, productId);
			return pst.executeUpdate();

		}
	}

	// 특정 리스트만 수를 셈
	public int selectCount(Connection conn, String loginId) throws SQLException {
		String sql = "select count(*) from shoppingbasket where loginId=?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, loginId);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
				return 0;
			}

		}
	}

	// 객체를 담음
	public List<Shopping> select(Connection conn, String loginId, int startRow, int size) throws SQLException {
		String sql = "select * from shoppingbasket where loginId=? order by productId limit ?,? ";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, loginId);
			pst.setInt(2, startRow);
			pst.setInt(3, size);
			try (ResultSet rs = pst.executeQuery()) {
				List<Shopping> splist = new ArrayList<Shopping>();
				while (rs.next()) {
					splist.add(convProduct(rs));
				}
				return splist;
			}
		}
	}

	// 찾기
	public Shopping selectByLoginId(Connection conn, String loginId) throws SQLException {
		String sql = "select * from user where loginid = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, loginId);
			Shopping shopping = null;
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					shopping = new Shopping(rs.getInt("productId"), rs.getString("productType"),
							rs.getString("loginId"), rs.getString("productName"), rs.getInt("price"),
							rs.getTimestamp("wdate").toLocalDateTime(), rs.getInt("count"));
				}
				return shopping;
			}
		}
	}

	// 객체를 넣음..?
	private Shopping convProduct(ResultSet rs) throws SQLException {
		Shopping shopping = new Shopping(rs.getInt("productId"), rs.getString("productType"), rs.getString("loginId"),
				rs.getString("productname"), rs.getInt("price"), rs.getTimestamp("wdate").toLocalDateTime(),
				rs.getInt("count"));

		return shopping;
	}
}
