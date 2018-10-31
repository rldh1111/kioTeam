package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

import jdbc.Connection.ConnectionProvider;
import shopping.dao.ShoppingDao;
import shopping.model.Shopping;
import user.model.User;

public class ShoppingInsertService {
	private static ShoppingInsertService instance = new ShoppingInsertService();

	private ShoppingInsertService() {
	}

	public static ShoppingInsertService getInstance() {
		return instance;
	}

	public void insert(ShoppingRequest sr) {
		ShoppingDao shoppingDao = ShoppingDao.getInstance();
		try (Connection conn = ConnectionProvider.getConnection()) {
			conn.setAutoCommit(false);
			Shopping shopping = shoppingDao.existProductSelect(conn, sr.getUserId(), sr.getProductId());
			if (shopping != null) {
				shoppingDao.update(conn, sr.getUserId(),sr.getProductId(), sr.getCount());
			} else {
				shoppingDao.insert(conn,
						new Shopping(sr.getUserId(), sr.getUserName(), sr.getProductId(), sr.getProductType(),
								sr.getProductName(), sr.getPrice(), sr.getCount(), sr.getExplanation(), sr.getUrl()));
			}
			conn.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
