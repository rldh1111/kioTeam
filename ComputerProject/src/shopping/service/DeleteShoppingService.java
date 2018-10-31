package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.Connection.ConnectionProvider;
import shopping.dao.ShoppingDao;
import shopping.model.Shopping;

public class DeleteShoppingService {
	private static DeleteShoppingService instance = new DeleteShoppingService();
	private DeleteShoppingService() {};
	public static DeleteShoppingService getInstance() {return instance;}
	
	public void delete(DeleteRequest dr) {
		ShoppingDao shoppingDAO = ShoppingDao.getInstance();
		try(Connection conn = ConnectionProvider.getConnection()){
			try {
				conn.setAutoCommit(false);
				shoppingDAO.delete(conn, dr.getProductId());
				System.out.println(dr.getProductId());
				conn.commit();
			}catch(SQLException e) {
				conn.rollback();
				throw new RuntimeException(e);
			}		
		} catch (SQLException e1) {
			throw new RuntimeException(e1);
		}
	}
}
