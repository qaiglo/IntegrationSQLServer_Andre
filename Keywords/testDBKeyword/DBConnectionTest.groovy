package testDBKeyword

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword

public class DBConnectionTest {
	
   /**
   * Open and return a connection to database
   * @param dataFile absolute file path
   * @return an instance of java.sql.Connection
   */
	
   //Establishing a connection to the DataBase
   @Keyword
   def connectDB(String url, String dbname, String username, String password){
	
	   jdbc:sqlserver://35.229.139.231;databaseName=TEST
	   //Load driver class for your specific database type
	   String conn = "jdbc:sqlserver://" + url + ":" + "/" + dbname
	
	   //Class.forName("org.sqlite.JDBC")
	
	   //String connectionString = "jdbc:sqlite:" + dataFile
	   if(connection != null && !connection.isClosed()){
		   connection.close()
	   }
	   
	   connection = DriverManager.getConnection(conn, username, password)
	   return connection
   }
	
   /**
   * execute a SQL query on database
   * @param queryString SQL query string
   * @return a reference to returned data collection, an instance of java.sql.ResultSet
   */
   
   //Executing the constructed Query and Saving results in resultset
   @Keyword
   def executeQuery(String queryString) {
	   Statement stm = connection.createStatement()
	   ResultSet rs = stm.executeQuery(queryString)
	   return rs
   }
	
   //Closing the connection
   @Keyword
   def closeDatabaseConnection() {
	   if(connection != null && !connection.isClosed()){
		   connection.close()
   }
   connection = null
   }
	
   /**
   * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
   * @param queryString a SQL statement
   * @return single value result of SQL statement
   */
	
   @Keyword
   def execute(String queryString) {
	   Statement stm = connection.createStatement()
	   boolean result = stm.execute(queryString)
	   return result
   }
   
}
