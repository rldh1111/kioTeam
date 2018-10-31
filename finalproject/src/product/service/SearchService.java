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
	private int size = 10;
	private int blockSize = 5;
	
	public ProductPage search(int pageNum, String search) throws SQLException {
		ProductDao productDao = ProductDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = productDao.selectSearchCount(conn ,search);
			ArrayList<Product> products = productDao.select(conn, search, (pageNum - 1) * size, size);
			if (products.isEmpty()) {
				throw new ProductNotFoundException("검색한 제품이 없습니다");
			}
			return new ProductPage(products, pageNum, total, size, blockSize);
		}catch(ProductNotFoundException e) {
			throw e;
		}

	}
}
