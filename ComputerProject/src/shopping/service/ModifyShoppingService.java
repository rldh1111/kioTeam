package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.Connection.ConnectionProvider;
import shopping.dao.ShoppingDao;
import shopping.model.Shopping;

public class ModifyShoppingService {
	private static ModifyShoppingService instance = new ModifyShoppingService();

	private ModifyShoppingService() {
	}

	public static ModifyShoppingService getInstance() {
		return instance;
	}

	public void modify(ModifyRequest mr) {
		ShoppingDao shoppingDAO = ShoppingDao.getInstance();

		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				conn.setAutoCommit(false);
				shoppingDAO.update(conn, mr.getProductId(), mr.getCount());
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
