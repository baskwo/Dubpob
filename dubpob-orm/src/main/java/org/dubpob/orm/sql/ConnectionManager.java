package org.dubpob.orm.sql;

import static com.google.common.base.Throwables.propagate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	private String dbms, host, username, password;
	
	public ConnectionManager(String dbms,String host, String username, String password) {
		this.dbms = dbms;
		this.host = host;
		this.username = username;
		this.password = password;
	}
	
	public Connection getConnection() {
		Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.username);
	    connectionProps.put("password", this.password);

	    if (this.dbms.equals("mysql")) {
	        try {
				conn = DriverManager.getConnection(
				           "jdbc:" + this.dbms + "://" +
				           this.host +
				           ":3306/",
				           connectionProps);
			} catch (SQLException e) {
				propagate(e);
			}
	    }
	    
	    return conn;
	}
}
