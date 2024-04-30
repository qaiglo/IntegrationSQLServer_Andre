import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.sql.Connection as Connection
import java.sql.ResultSet as ResultSet

// Connect To DB
Connection connection = CustomKeywords.'sql_serverConnection.ExcecutingFirstQuerySQLServer.connectDB'(GlobalVariable.db_url,
	GlobalVariable.db_username, GlobalVariable.db_password)

// Verify the connection
if ((connection != null) && !(connection.isClosed())) {
	println('Koneksi Ke Database Berhasil!')

	// SQL Query Delete Data By Admin ID
	ResultSet resultSet = CustomKeywords.'sql_serverConnection.ExcecutingFirstQuerySQLServer.deleteAdmin'(3)

	if (resultSet.next()) {
		
		System.out.println("Berhasil Menghapus Data!")
		
	}
	
	connection.close()

	WebUI.delay(3)
} else {
	println('Koneksi Ke Database Gagal.')
}

WebUI.delay(3)


