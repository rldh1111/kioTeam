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

	public ArrayList<Product> selectType(Connection conn, String productType, int startRow, int size)
			throws SQLException {
		String sql = "select * from product where productType = ? order by productId limit ?, ?";
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

	public ArrayList<Product> select(Connection conn, String search) throws SQLException { // 검색해서 가져오기
		String sql = "select * from product where name like '%" + search + "%'";
		ArrayList<Product> products = new ArrayList<Product>();
		try (Statement pst = conn.createStatement()) {
			try (ResultSet rs = pst.executeQuery(sql)) {
				while (rs.next()) {
					products.add(makeProduct(rs));
				}
			}
		}
		return products;
	}

	public void insert(Connection conn, String name, String productType, int price, String explanation, String url)
			throws SQLException { // 제품등록
		String sql = "insert into product(name, productType, price, explanation, url) values(?,?,?,?,?)";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, name);
			pst.setString(2, productType);
			pst.setInt(3, price);
			pst.setString(4, explanation);
			pst.setString(5, url);
			pst.executeUpdate();
		}
	}

	public void update(Connection conn, int productId, String name, String productType, int price, String explanation,
			String url) throws SQLException {

		String sql = "CALL updateproduct(?,?,?,?,?,?)";
		try (CallableStatement cs = conn.prepareCall(sql)) {
			cs.setString(1, name);
			cs.setString(2, productType);
			cs.setInt(3, price);
			cs.setString(4, explanation);
			cs.setString(5, url);
			cs.setInt(6, productId);
			cs.executeUpdate();

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
				rs.getTimestamp("udate").toLocalDateTime(), rs.getString("explanation"), rs.getString("url"));
		return product;
	}
}
