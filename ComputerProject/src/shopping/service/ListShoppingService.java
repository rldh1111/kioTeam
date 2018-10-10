package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.Connection.ConnectionProvider;
import shopping.dao.ShoppingDAO;
import shopping.model.Shopping;

public class ListShoppingService {
	private static ListShoppingService instance = new ListShoppingService();

	private ListShoppingService() {
	}

	public static ListShoppingService getInstance() {
		return instance;

	}

	private int size = 10;
	private int blockSize = 5;

	public ShoppingPage getShoppingPage(int pageNum, String loginId) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			ShoppingDAO shoppingDAO = ShoppingDAO.getInstance();
			int total = shoppingDAO.selectCount(conn, loginId);
			List<Shopping> spList = shoppingDAO.select(conn, loginId, (pageNum - 1) * size, size);
			return new ShoppingPage(spList, pageNum, total, size, blockSize);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
