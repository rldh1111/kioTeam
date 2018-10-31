package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import common.exception.ProductNotFoundException;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class ProductTypeViewService {
	private static ProductTypeViewService instance = new ProductTypeViewService();

	public static ProductTypeViewService getInstance() {
		return instance;
	}

	private ProductTypeViewService() {

	}

	private int size = 10;
	private int blockSize = 5;

	public ProductPage selectType(String productType, int pageNum) {
		ProductDao productDao = ProductDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = productDao.selectTypeCount(conn, productType);
			ArrayList<Product> products = productDao.selectProductType(conn, productType, (pageNum - 1) * size, size);
			return new ProductPage(products, pageNum, total, size, blockSize);
		}catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
