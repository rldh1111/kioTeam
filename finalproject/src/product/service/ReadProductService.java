package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.ProductNotFoundException;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class ReadProductService {
	private static ReadProductService instance = new ReadProductService();

	private ReadProductService() {
	}

	public static ReadProductService getInstance() {
		return instance;
	}
	
	public Product readProduct(int productId) {
		ProductDao productDao =ProductDao.getInstance();
		try(Connection conn = ConnectionProvider.getConnection()){
			Product product = productDao.selectProductId(conn, productId);
			if(product == null) {
				throw new ProductNotFoundException("없는 제품입니다");
			}
			return product;
		}catch(SQLException e) {
			throw new RuntimeException();
		}catch(ProductNotFoundException e) {
			throw e;
		}
	}
}
