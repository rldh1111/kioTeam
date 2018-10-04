package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import common.exception.ProductNotFoundException;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class ProductViewService {
	private static ProductViewService instance = new ProductViewService();

	public static ProductViewService getInstance() {
		return instance;
	}

	private ProductViewService() {

	}

	public Product selectProduct(int productId) {
		ProductDao productDao = ProductDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
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
	}
}
