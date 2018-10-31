package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.Connection.ConnectionProvider;
import shopping.dao.ShoppingDao;
import shopping.model.Shopping;

public class ShoppingListService {
	private static ShoppingListService instance = new ShoppingListService();

	private ShoppingListService() {
	}

	public static ShoppingListService getInstance() {
		return instance;

	}

	private int size = 10;
	private int blockSize = 5;

	public ShoppingPage getShoppingPage(int pageNum, String loginId) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			ShoppingDao shoppingDao = ShoppingDao.getInstance();
			int total = shoppingDao.selectCount(conn, loginId);
			List<Shopping> shoppings = shoppingDao.select(conn, loginId, (pageNum - 1) * size, size);
			return new ShoppingPage(shoppings, pageNum, total, size, blockSize);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
