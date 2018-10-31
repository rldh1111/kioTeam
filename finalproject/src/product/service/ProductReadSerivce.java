package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.ProductNotFoundException;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class ProductReadSerivce {
	private static ProductReadSerivce instance = new ProductReadSerivce();

	public static ProductReadSerivce getInstance() {
		return instance;
	}

	private ProductReadSerivce() {

	}

	public Product readProduct(int productId) {
		ProductDao productDao = ProductDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				Product product = productDao.selectProductId(conn, productId);
				if (product == null) {
					throw new ProductNotFoundException("제품이 없습니다");
				}
				return product;
			} catch (ProductNotFoundException e) {
				throw e;
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
