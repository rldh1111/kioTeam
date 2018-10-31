package shopping.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.Connection.ConnectionProvider;
import shopping.dao.ShoppingDao;
import shopping.model.Shopping;

public class ShoppingReadService{
	private static ShoppingReadService instance = new ShoppingReadService();

	private ShoppingReadService() {
	}

	public static ShoppingReadService getInstance() {
		return instance;
	}
	
	public ArrayList<Shopping> readShopping(int userId){
		ShoppingDao shoppingDAO = ShoppingDao.getInstance();
		try(Connection conn = ConnectionProvider.getConnection()){
			ArrayList<Shopping> shoppings = shoppingDAO.selectShopping(conn, userId);
			return shoppings;
		}catch(SQLException e) {
			throw new RuntimeException();
		}
		
	}
}
