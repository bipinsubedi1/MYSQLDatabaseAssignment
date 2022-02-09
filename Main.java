package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
	String driver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/bipindb";
	   static final String USER = "root";
	   static final String PASS = "Chitwan1!";

	   public static void main(String[] args) {
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	          /*String sql = "CREATE TABLE REGISTRATION " +
	                   "(EmpID INTEGER not NULL, " +
	                   " EmpName VARCHAR(255), " + 
	                   " age INTEGER, " + 
	                   " salary INTEGER " +
	                   " values (?, ?, ?, ?))"; */
	    	  
	    	  String sql = " insert into REGISTRATION (EmpID, EmpName, age, salary)"
	    		        + " values (?, ?, ?, ?)";
	          
	          PreparedStatement preparedStmt = conn.prepareStatement(sql);
	          preparedStmt.setInt (1, 123);
	          preparedStmt.setString (2, "Rubble");
	          preparedStmt.setInt   (3, 30);
	          preparedStmt.setInt    (4, 5000);
	          
	          PreparedStatement preparedStmt1 = conn.prepareStatement(sql);
	          preparedStmt1.setInt (1, 345);
	          preparedStmt1.setString (2, "Bipin");
	          preparedStmt1.setInt   (3, 27);
	          preparedStmt1.setInt    (4, 6000);

	          // execute the preparedstatement
	          preparedStmt1.execute();

	         stmt.executeUpdate(sql);
	         System.out.println("Created table in given database..."); 	  
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }
}
