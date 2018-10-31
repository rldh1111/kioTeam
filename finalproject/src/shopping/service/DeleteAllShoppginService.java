package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.Connection.ConnectionProvider;
import shopping.dao.ShoppingDao;

public class DeleteAllShoppginService {
	private static DeleteAllShoppginService instance = new DeleteAllShoppginService();

	private DeleteAllShoppginService() {
	};

	public static DeleteAllShoppginService getInstance() {
		return instance;
	}

	public void deleteAll(int userId) {
		ShoppingDao shoppingDAO = ShoppingDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			try {
				conn.setAutoCommit(false);
				shoppingDAO.deleteAll(conn, userId);
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				throw new RuntimeException();
			}

		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
