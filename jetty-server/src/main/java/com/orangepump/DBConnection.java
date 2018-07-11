
package com.orangepump;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

public class DBConnection {

	DataSource ds = null;
	
	public DBConnection() throws Exception {

		String jndiName = "jdbc/orcl";

		javax.naming.Context ctx = null;
		Connection conn = null;

		try {

			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(jndiName);

		} catch (Exception ex) {			
            System.out.println("Could Not Find the PoolMan Driver.");
		}
	}
	
	public Connection getConnection() throws Exception {		
		Connection conn = ds.getConnection();
		return conn;
	}

	public void release(Connection conn) {
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) { 
				System.out.println("con resource close fail"); 
			}
		}	
	}

}
