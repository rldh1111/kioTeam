package product.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

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

	public ArrayList<Product> selectType(Connection conn, String type, int startRow, int size) throws SQLException {
		String sql = "select * from product where type = ? order by productId limit ?, ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, type);
			pst.setInt(2, startRow);
			pst.setInt(3, size);
			try (ResultSet rs = pst.executeQuery()) {
				ArrayList<Product> products = new ArrayList<>();
				while (rs.next()) {
					products.add(makeProduct(rs));
				}
				return products;
			}
		}
	}

	public ArrayList<Product> selectProductType(Connection conn, String productType, int startRow, int size)
			throws SQLException {
		String sql = "select * from product where productType = ? order by productId desc limit ?, ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, productType);
			pst.setInt(2, startRow);
			pst.setInt(3, size);
			try (ResultSet rs = pst.executeQuery()) {
				ArrayList<Product> products = new ArrayList<>();
				while (rs.next()) {
					products.add(makeProduct(rs));
				}
				return products;
			}
		}
	}

	public ArrayList<Product> selectLikeCount(Connection conn, String search, int startRow, int size)
			throws SQLException {
		String sql = "select * from product where productType like '%" + search + "%' or explanation like '%" + search
				+ "%' or productName like '%" + search + "%' order by productId desc limit ?,?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, search);
			pst.setInt(2, startRow);
			pst.setInt(3, size);
			try (ResultSet rs = pst.executeQuery()) {
				ArrayList<Product> products = new ArrayList<>();
				while (rs.next()) {
					products.add(makeProduct(rs));
				}
				return products;
			}
		}
	}

	public Product selectName(Connection conn, String productName) throws SQLException {
		String sql = "select * from product where productName = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, productName);
			Product product = null;
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					product = (makeProduct(rs));
				}
			}
			return product;
		}
	}

	public int selectSearchCount(Connection conn, String search) throws SQLException {
		String sql = "select count(*) from product where productType like '%" + search + "%' or explanation like '%"
				+ search + "%' or productName like '%" + search + "%'";
		try (Statement st = conn.createStatement()) {
			try (ResultSet rs = st.executeQuery(sql)) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
			return 0;
		}
	}

	public int selectCount(Connection conn) throws SQLException {
		String sql = "select count(*) from product";
		try (Statement st = conn.createStatement()) {
			try (ResultSet rs = st.executeQuery(sql)) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
			return 0;
		}
	}

	public int selectTypeCount(Connection conn, String productType) throws SQLException {
		String sql = "select count(*) from product where productType = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, productType);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
			return 0;
		}
	}

	public int selectTypeviewCount(Connection conn, String type) throws SQLException {
		String sql = "select count(*) from product where type = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, type);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
			return 0;
		}
	}

	public ArrayList<Product> selectProudct(Connection conn, int startRow, int size) throws SQLException {
		String sql = "select * from product order by productId desc limit ?, ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, startRow);
			pst.setInt(2, size);
			try (ResultSet rs = pst.executeQuery()) {
				ArrayList<Product> products = new ArrayList<>();
				while (rs.next()) {
					products.add(makeProduct(rs));
				}
				return products;
			}
		}
	}

	public ArrayList<Product> select(Connection conn, String search, int startRow, int size) throws SQLException { // 검색해서
																													// 가져오기
		String sql = "select * from product where productType like '%" + search + "%' or explanation like '%" + search
				+ "%' or productName like '%" + search + "%' order by productId desc limit ?, ?";
		ArrayList<Product> products = new ArrayList<Product>();
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, startRow);
			pst.setInt(2, size);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					products.add(makeProduct(rs));
				}
			}
		}
		return products;
	}

	public void insert(Connection conn, String type, String productName, String productType, int price,
			String explanation, String url) throws SQLException { // 제품등록
		String sql = "insert into product(type, productName, productType, price, explanation, url) values(?,?,?,?,?,?)";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, type);
			pst.setString(2, productName);
			pst.setString(3, productType);
			pst.setInt(4, price);
			pst.setString(5, explanation);
			pst.setString(6, url);
			pst.executeUpdate();
		}
	}

	public void update(Connection conn, int productId, String type, String productName, String productType, int price,
			String explanation, String url) throws SQLException {
		String sql = "update product set type = ?, productName = ?, productType = ?, price = ?, explanation = ?, url = ? where productId = ?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, type);
			pst.setString(2, productName);
			pst.setString(3, productType);
			pst.setInt(4, price);
			pst.setString(5, explanation);
			pst.setString(6, url);
			pst.setInt(7, productId);
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
		Product product = new Product(rs.getInt("productId"), rs.getString("type"), rs.getString("productName"),
				rs.getString("productType"), rs.getInt("price"), rs.getTimestamp("wdate").toLocalDateTime(),
				rs.getTimestamp("udate").toLocalDateTime(), rs.getString("explanation"), rs.getString("url"));
		return product;
	}
}
