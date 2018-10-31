package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

import jdbc.Connection.ConnectionProvider;
import shopping.dao.ShoppingDao;
import shopping.model.Shopping;
import user.model.User;

public class ShoppingService {
	private static ShoppingService instance = new ShoppingService();
	private ShoppingService() {
	}
	public static ShoppingService getInstance() {
		return instance;
	}
	
	public void insert(ShoppingRequest sr) {
		ShoppingDao shoppingDAO = ShoppingDao.getInstance();
		try(Connection conn = ConnectionProvider.getConnection()){
			conn.setAutoCommit(false);
			shoppingDAO.insert(conn, new Shopping(sr.getProductId(),sr.getProductType(), sr.getLoginId(), sr.getProductname(),
					sr.getPrice(), LocalDateTime.now(), sr.getCount()));	
			conn.commit();	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
