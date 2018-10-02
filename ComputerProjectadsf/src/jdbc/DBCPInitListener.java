package jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInitListener implements ServletContextListener {

	// 우리의 디비 커넥션 풀을 셋팅하도록 해보자!!

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		// 서블릿 컨텍스트를 통해서 init파라미터(디비 정보가 있는 properties)를 받음
		// 파일주소로 파일을 읽어야함!! 시스템상 주소!!
		String poolConfigFile = sc.getRealPath(sc.getInitParameter("poolConfigFile"));

		// 파일 주소로 프로퍼티스 객체에 파일에 있는 데이터를 넣을 것임!
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(poolConfigFile));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("not found poolConfigFile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("fail to read poolConfigFile");
		}

		try {
			LoadJDBCDriver(prop);
			initConnectionPool(prop);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void initConnectionPool(Properties prop) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String uri = prop.getProperty("jdbcUri");
		String user = prop.getProperty("dbUser");
		String password = prop.getProperty("dbPwd");
		try {
			// 디비 접속정보를 이나로 넣고 커넥션을 만들어 주는 팩토리 객체를 생성.
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(uri, user, password);
			// 풀에서 쓸수있는 커네겻ㄴ을 만들어준느 팩토리에 커넥션 팩토리를 넣고 생성!
			PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connFactory, null);
			// 커넥션이 유효한지 체크하기 위한 쿼리를 지정
			// getProperty의 첫번째 이자는 파일에 정의 되어있는 값이고, 두번쩨 인자는 없을시! 기본값으로 해줄 값!
			poolableConnectionFactory.setValidationQuery(prop.getProperty("validationQuery", "select 1"));
			// 커넥션 풀의 설정 정보를 다루는 객체 생성하고 설정정보 셋팅
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig<>();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(Integer.parseInt(prop.getProperty("minIdle", "5")));
			poolConfig.setMaxIdle(Integer.parseInt(prop.getProperty("maxTotal", "50")));
			GenericObjectPool<PoolableConnection> pool = new GenericObjectPool<>(poolableConnectionFactory, poolConfig);
			poolableConnectionFactory.setPool(pool);

			// 풀링 드라이버를 로드
			Class.forName(prop.getProperty("poolingDriver"));
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			String poolName = prop.getProperty("poolName");
			// 생서한 커넥션 풀을 커넥션 풀 드라이버에 등록
			driver.registerPool(poolName, pool);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Not found poolingDriver Class", e);
		} catch (SQLException e) {
			throw new RuntimeException("can not get Driver PoolingDriver Class", e);
		}
	}

	private void LoadJDBCDriver(Properties prop) {
		// TODO Auto-generated method stub
		String driverClass = prop.getProperty("jdbcDriver");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("fail to load JDBC Driver");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
