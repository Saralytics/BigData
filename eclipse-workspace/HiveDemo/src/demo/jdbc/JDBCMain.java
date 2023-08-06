package demo.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCMain {

	public static void main(String[] args) {
		
		
		String query = "select * from emp";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			
			conn = JDBCUtils.getConnection();
			
			st = conn.createStatement();
			
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				String name = rs.getString("ename");
				double salary = rs.getDouble("sal");
				
				System.out.println(name + "-" + salary);
				
			};
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//
			JDBCUtils.release(conn, st, rs);
		}
		

	}

}
