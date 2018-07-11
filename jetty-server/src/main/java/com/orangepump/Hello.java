
package com.orangepump;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class Hello {
	
	public static void main(String args[]) throws Exception {
		
		DBConnection dbconn = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		StringBuffer string = null;
		List list = null;
		
		try {
			
			dbconn = new DBConnection();
			conn = dbconn.getConnection();
			
			string = new StringBuffer();
			string.append("select * from test\n");
			
			pstmt = conn.prepareStatement(string.toString());
			rset = pstmt.executeQuery();
			
			rset.close();
			pstmt.close();
			
		} finally {
			if(pstmt != null) try {pstmt.close();}catch(Exception ee) {ee.toString();}
			if(conn != null) try {dbconn.release(conn);}catch(Exception ee) {ee.toString();}
		}
		
		return list;
	}
	

}
