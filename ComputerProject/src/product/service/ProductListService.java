package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.exception.ProductNotFoundException;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class ProductListService {
	private static ProductListService instance = new ProductListService();

	public static ProductListService getInstance() {
		return instance;
	}

	private ProductListService() {
	}

	private int size = 10;
	private int blockSize = 5;

	public ProductPage ProductList(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			ProductDao productDao = ProductDao.getInstance();
			int total = productDao.selectCount(conn);
			ArrayList<Product> products = productDao.selectProudct(conn, (pageNum - 1), total);
			return new ProductPage(products, pageNum, total, size, blockSize);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
