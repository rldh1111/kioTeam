package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.ProductNotFoundException;
import common.handler.CommandHandler;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class ProductMoreViewService {
	private static ProductMoreViewService instance = new ProductMoreViewService();

	private ProductMoreViewService() {
	}

	public static ProductMoreViewService getInstance() {
		return instance;
	}

	public Product moreView(int productId) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				ProductDao productDao = ProductDao.getInstance();
				Product product = productDao.selectProductId(conn, productId);
				if (product == null) {
					throw new ProductNotFoundException("제품을 찾을 수 없습니다");
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
