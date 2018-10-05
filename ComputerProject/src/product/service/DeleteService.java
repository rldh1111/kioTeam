package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.ProductNotFoundException;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class DeleteService {
	private static DeleteService instance = new DeleteService();

	public static DeleteService getInstance() {
		return instance;
	}

	private DeleteService() {

	}

	public void delete(int productId){
		ProductDao productDao = ProductDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				conn.setAutoCommit(false);
				Product product = productDao.selectProductId(conn, productId);
				if (product == null) {
					throw new ProductNotFoundException("없는 제품입니다");
				}
				productDao.delete(conn, productId);
				conn.commit();
			} catch (ProductNotFoundException e) {
				conn.rollback();
				throw e;
			} catch (SQLException e) {
				conn.rollback();
				throw new RuntimeException();
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
