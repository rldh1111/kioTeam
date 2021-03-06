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

	public void insert(RegisterRequest rr) {
		ProductDao productDao = ProductDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				conn.setAutoCommit(false);
				Product product = productDao.selectName(conn, rr.getName());
				if (product != null) {
					throw new DuplicatieException("같은 제품이 있습니다.");
				}
				productDao.insert(conn, rr.getType(), rr.getName() , rr.getProductType(), rr.getPrice(), rr.getExplanation(), rr.getUrl());
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
