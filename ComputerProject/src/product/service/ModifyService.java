package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.exception.DuplicatieException;
import common.exception.ProductNotFoundException;
import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;

public class ModifyService {
	private static ModifyService instance = new ModifyService();

	public static ModifyService getInstance() {
		return instance;
	}

	private ModifyService() {

	}

	public void modify(ModifyRequest mr) {
		ProductDao productDao = ProductDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				conn.setAutoCommit(false);
				Product product = productDao.selectProductId(conn, mr.getProductId());
				if (product == null) {
					throw new ProductNotFoundException("없는 제품입니다");
				}
				product = productDao.selectName(conn, mr.getName());
				
					if (product != null) {
						if (!product.getName().equals(mr.getName())) {
							throw new DuplicatieException("이름이 중복됩니다");
						}
						
					}
				
				productDao.update(conn, mr.getProductId(), mr.getName(), mr.getProductType(), mr.getPrice(),
						mr.getExplanation(), mr.getUrl());
				conn.commit();
			} catch (DuplicatieException e) {
				conn.rollback();
				throw e;
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
