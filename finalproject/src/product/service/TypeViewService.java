package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.exception.ProductNotFoundException;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class TypeViewService {
	private static TypeViewService instance = new TypeViewService();

	public static TypeViewService getInstance() {
		return instance;
	}

	private TypeViewService() {
	}

	private int size = 10;
	private int blockSize = 5;

	public ProductPage TypeList(int pageNum, String type) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			ProductDao productDao = ProductDao.getInstance();
			int total = productDao.selectTypeviewCount(conn, type);
			ArrayList<Product> products = productDao.selectType(conn, type, (pageNum - 1) * size, size);
			return new ProductPage(products, pageNum, total, size, blockSize);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	

	}
}
