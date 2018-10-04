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

	public ArrayList<Product> selectList() throws SQLException {
		ProductDao productDao = ProductDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			ArrayList<Product> products = productDao.selectAll(conn);
			if (products == null) {
				throw new ProductNotFoundException("제품이 없음");
			}
			return products;
		}

	}
}
