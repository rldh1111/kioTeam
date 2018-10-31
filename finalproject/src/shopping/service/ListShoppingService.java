package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.Connection.ConnectionProvider;
import product.dao.ProductDao;
import product.model.Product;
import shopping.dao.ShoppingDao;
import shopping.model.Shopping;

public class ListShoppingService {
	private static ListShoppingService instance = new ListShoppingService();

	private ListShoppingService() {
	}

	public static ListShoppingService getInstance() {
		return instance;

	}

	private int size = 4;
	private int blockSize = 5;

	public ShoppingPage getShoppingPage(int pageNum, int userId) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			ShoppingDao shoppingDAO = ShoppingDao.getInstance();
			int total = shoppingDAO.selectCount(conn, userId);
			List<Shopping> spList = shoppingDAO.select(conn, userId, (pageNum - 1) * size, size);
			return new ShoppingPage(spList, pageNum, total, size, blockSize);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
