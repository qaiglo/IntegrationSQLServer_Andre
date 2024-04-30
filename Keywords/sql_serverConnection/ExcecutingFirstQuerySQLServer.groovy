package sql_serverConnection

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet
import java.sql.Statement

public class ExcecutingFirstQuerySQLServer {

	private static Connection connection = null

	/**
	 @Keyword
	 public connection(String url, String user, String password, String driverClassName) {
	 def sqlConnection = Sql.newInstance("url", "user", "password", "driverClassName")
	 sqlConnection.eachRow("Show tables") { row ->
	 println row[0]
	 }
	 //Groovy Clouser - it is set of statement that is more like a method which return and parameter
	 }
	 */

	@Keyword
	def connectDB(String url, String username, String password){
		//Load driver class for your specific database type

		if(connection != null && !connection.isClosed()){

			connection.close()
		}

		connection = DriverManager.getConnection(url, username, password)
		return connection
	}

	@Keyword
	def getAdmiByIdAdmin(int adminID) {

		String queryString = "SELECT *  FROM admin2 where admin_id = " + adminID

		Statement stm = connection.createStatement();
		ResultSet resultSet = stm.executeQuery(queryString);
		return resultSet
	}

	@Keyword
	def insertAdmin(String username, String password) {

		String queryStringInsertDataAdmin = "INSERT INTO admin2(username, password) VALUES('"+ username +"', '"+ password +"')"

		Statement stm = connection.createStatement();
		int result = stm.executeUpdate(queryStringInsertDataAdmin)

		if (result > 0) {
			return true
		}

		return false
	}

	@Keyword
	def deleteAdmin(int adminID) {

		String queryStringDeleteDataAdmin = "DELETE FROM admin2 where admin_id = " + adminID

		Statement stm = connection.createStatement();
		ResultSet resultSet = stm.executeQuery(queryStringDeleteDataAdmin);
		return resultSet
	}
}
