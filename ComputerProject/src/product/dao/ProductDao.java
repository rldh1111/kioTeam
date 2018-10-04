package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.exception.ProductNotFoundException;
import product.model.Product;
import user.service.LoginService;

public class ProductDao {
	private static ProductDao instance = new ProductDao();

	public static ProductDao getInstance() {
		return instance;
	}

	private ProductDao() {
	}
	
	public Product selectProductId(Connection conn, int productId) throws SQLException {
		String sql = "select * from product where productId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, productId);
			Product product = null;
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					product = (makeProduct(rs));
				}
			}
			return product;
		}
	}

	public Product selectName(Connection conn, String name) throws SQLException {
		String sql = "select * from product where name = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, name);
			Product product = null;
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					product = (makeProduct(rs));
				}
			}
			return product;
		}
	}

	public ArrayList<Product> selectAll(Connection conn) throws SQLException { // 모두 가져오기
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "select * from product";
		try (PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				products.add(makeProduct(rs));
			}
		}
		return products;
	}

	public ArrayList<Product> select(Connection conn, String search) throws SQLException { // 검색해서 가져오기
		String sql = "select * from product where name or productType or explanation like %?%";
		ArrayList<Product> products = new ArrayList<Product>();
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, search);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					products.add(makeProduct(rs));
				}
			}
		}
		return products;
	}

	public void insert(Connection conn, String name, String productType, int price, String explanation)
			throws SQLException { // 제품등록
		String sql = "insert into product(name, productType, price, explanation) values(?,?,?,?)";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, name);
			pst.setString(2, productType);
			pst.setInt(3, price);
			pst.setString(4, explanation);
			pst.executeUpdate();
		}
	}

	public void update(Connection conn, int productId, String name, String productType, int price, String explanation)
			throws SQLException {
		String sql = "update product set name = ?, productType = ?, price = ?, explanation = ? where productId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, name);
			pst.setString(2, productType);
			pst.setInt(3, price);
			pst.setString(4, explanation);
			pst.setInt(5, productId);
			pst.executeUpdate();
		}
	}

	public void delete(Connection conn, int productId) throws SQLException {
		String sql = "delete from product where productId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, productId);
			pst.executeUpdate();
		}
	}

	private Product makeProduct(ResultSet rs) throws SQLException {
		Product product = new Product(rs.getInt("productId"), rs.getString("name"), rs.getString("productType"),
				rs.getInt("price"), rs.getTimestamp("wdate").toLocalDateTime(),
				rs.getTimestamp("udate").toLocalDateTime(), rs.getString("explanation"));
		return product;
	}
}
