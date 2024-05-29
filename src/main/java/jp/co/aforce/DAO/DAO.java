package jp.co.aforce.DAO;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	static DataSource ds;

	
	public DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() throws Exception {
		if (ds == null) {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:/comp/env/jdbc/login_db");
		}
		return ds.getConnection();
	}


}
