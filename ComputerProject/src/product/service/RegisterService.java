package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.DuplicatieException;
import common.exception.ProductNotFoundException;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class RegisterService {
	private static RegisterService instance = new RegisterService();

	public static RegisterService getInstance() {
		return instance;
	}

	private RegisterService() {
	}

	public void insert(String name, String productType, int price, String explanation) {
		ProductDao productDao = ProductDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				conn.setAutoCommit(false);
				Product product = productDao.selectName(conn, name);
				if (product != null) {
					throw new DuplicatieException("같은 제품이 있습니다.");
				}
				productDao.insert(conn, name, productType, price, explanation);
				conn.commit();
			} catch (DuplicatieException e) {
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
