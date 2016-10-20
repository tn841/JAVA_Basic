package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itwill.jdbc.common.ConnectionFactory;

public class StatementMain {

	public static void main(String[] args) throws Exception {
		
//		String driverClass="oracle.jdbc.driver.OracleDriver";
//		String url="jdbc:oracle:thin:@210.16.214.203:1521:XE";
//		String user="user21";
//		String pass="user21";
		String selectSQL = "select * from address order by no";	//executeQuery()
		String updateSQL = "update address set address = '뉴욕' where no = 6";	//executeUpdate()
		String anySQL = "select * from address order by no";		//execute()
		
//		Class.forName(driverClass);
//		Connection con=DriverManager.getConnection(url,user,pass);
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		/*
		 * 	행의 수를 제한
		 * 	- Sets the limit for the maximum number of rows 
		 * 	that any ResultSet object generated by this Statement object can contain to the given number. 
		 * 	If the limit is exceeded, the excess rows are silently dropped.
		 */
		stmt.setMaxRows(3);
	
		
		/*
		 * 	요청만료시간
		 * 		- Lock이 걸린경우.
		 * 		- By default there is no limit on the amount of time 
		 */
		stmt.setQueryTimeout(10);
		
		
		
		/* << int java.sql.Statement.executeUpdate(String sql) >>
		 * 	- Executes the given SQL statement, 
		 * 	which may be an INSERT, UPDATE, or DELETE statement or 
		 * 	an SQL statement that returns nothing, 
		 * 	such as an SQL DDL statement. 
		 */
		int updateRowCont = stmt.executeUpdate(updateSQL);
		System.out.println("updateRowCount : "+updateRowCont);
		
			
		/* << ResultSet java.sql.Statement.executeQuery(String sql)>>
		 * 	- Executes the given SQL statement, which returns a single ResultSet object.
		 * 	- a ResultSet object that contains the data produced by the given query; never null 
		 * 	
		 */
		ResultSet rs = stmt.executeQuery(selectSQL);
		
		while(rs.next()){
			int no = rs.getInt("no");
			String name = rs.getString("name");
			System.out.println(no+"\t"+name);
		}
		
		rs.close();
		
		
		/*
		 *  << boolean java.sql.Statement.execute(String sql) >>
		 *  - Executes the given SQL statement, which may return multiple results.
		 *  - true if the first result is a ResultSet object; 
		 *    false if it is an update count or there are no results
		 */
		
		stmt.setMaxRows(0);	//행 제한 해제
		boolean isResultSet = stmt.execute(anySQL);
		if(isResultSet){
			//execute결과 ResultSet이 반환된 경우
			ResultSet rs2 = stmt.getResultSet();
			
			while(rs2.next()){
				int no=rs2.getInt("no");
				String id=rs2.getString("id");
				String address=rs2.getString("address");
				System.out.println(no+"\t"+id+"\t"+address);
			}
			rs2.close();
		}else{
			//execute결과 ResultSet이외의 값이 반환된 경우
			int updateCount = stmt.getUpdateCount();
			System.out.println("updateCount : "+updateCount);
		}
		
	
		stmt.close();
		
//		con.close();
		ConnectionFactory.releaseConnection(con);
				
	
	}

}
