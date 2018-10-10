package product.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.exception.ProductNotFoundException;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class SearchService {
	private static SearchService instance = new SearchService();

	public static SearchService getInstance() {
		return instance;
	}

	private SearchService() {

	}

	public ArrayList<Product> search(String search) throws SQLException {
		ProductDao productDao = ProductDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			ArrayList<Product> products = productDao.select(conn, search);
			if (products.isEmpty()) {
				throw new ProductNotFoundException("검색한 제품이 없습니다");
			}
			return products;
		}catch(ProductNotFoundException e) {
			throw e;
		}

	}
}
