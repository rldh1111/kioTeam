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

	public ArrayList<Shopping> selectShopping(Connection conn, int userId) throws SQLException {
		String sql = "select * from shoppingbasket where userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery()) {
				ArrayList<Shopping> shoppings = new ArrayList<Shopping>();
				while (rs.next()) {
					shoppings.add(makeShopping(rs));
				}
				return shoppings;
			}
		}

	}

	public Shopping existProductSelect(Connection conn, int userId, int productId) throws SQLException {
		String sql = "select * from shoppingbasket where userId = ? AND productId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, userId);
			pst.setInt(2, productId);
			Shopping shopping = null;
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					shopping = makeShopping(rs);
				}
			}
			return shopping;
		}
	}

	// 장바구니 추가
	public void insert(Connection conn, Shopping shopping) throws SQLException {
		String sql = "insert into shoppingbasket(userId, userName, productId, productType, productName, price, count, explanation, url) values(?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, shopping.getUserId());
			pst.setString(2, shopping.getUserName());
			pst.setInt(3, shopping.getProductId());
			pst.setString(4, shopping.getProductType());
			pst.setString(5, shopping.getProductName());
			pst.setInt(6, shopping.getPrice());
			pst.setInt(7, shopping.getCount());
			pst.setString(8, shopping.getExplanation());
			pst.setString(9, shopping.getUrl());
			pst.executeUpdate();
		}
	}

	// 물품 코드에 따른 삭제
	public void delete(Connection conn, int productId, int userId) throws SQLException {
		String sql = "delete from shoppingbasket where productId = ? AND userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, productId);
			pst.setInt(2, userId);
			pst.executeUpdate();
		}
	}

	// 장바구니 전체삭제
	public void deleteAll(Connection conn, int userId) throws SQLException {
		String sql = "delete from shoppingbasket where userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, userId);
			pst.executeUpdate();
		}
	}

	// 만약 물건이 있다면 개수추가
	public void update(Connection conn, int userId, int productId, int count) throws SQLException {
		String sql = "update shoppingbasket set count = count+? where productId = ? and userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, count);
			pst.setInt(2, productId);
			pst.setInt(3, userId);
			pst.executeUpdate();

		}
	}

	// 특정 리스트만 수를 셈
	public int selectCount(Connection conn, int userId) throws SQLException {
		String sql = "select count(*) from shoppingbasket where userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
				return 0;
			}

		}
	}

	// 객체를 담음
	public List<Shopping> select(Connection conn, int userId, int startRow, int size) throws SQLException {
		String sql = "select * from shoppingbasket where userId = ? order by productId limit ?,? ";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, userId);
			pst.setInt(2, startRow);
			pst.setInt(3, size);
			try (ResultSet rs = pst.executeQuery()) {
				List<Shopping> splist = new ArrayList<Shopping>();
				while (rs.next()) {
					splist.add(makeShopping(rs));
				}
				return splist;
			}
		}
	}

	// 찾기
	public Shopping selectByLoginId(Connection conn, int userId) throws SQLException {
		String sql = "select * from user where userId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, userId);
			Shopping shopping = null;
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					shopping = makeShopping(rs);
				}
				return shopping;
			}
		}
	}


	private Shopping makeShopping(ResultSet rs) throws SQLException {
		Shopping shopping = new Shopping(rs.getInt("shoppingId"), rs.getInt("userId"), rs.getString("userName"), rs.getInt("productId"),
				rs.getString("productType"), rs.getString("productName"), rs.getInt("price"),
				rs.getTimestamp("wdate").toLocalDateTime(), rs.getInt("count"), rs.getString("explanation"),
				rs.getString("url"));
		return shopping;
	}
}
