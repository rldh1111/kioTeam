package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.Connection.ConnectionProvider;
import user.dao.UserDao;
import user.model.User;

public class ModifyService {
	private static ModifyService instance = new ModifyService();

	public static ModifyService getInstance() {
		return instance;
	}

	private ModifyService() {
	}


}
