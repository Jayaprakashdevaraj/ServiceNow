package testng.api.base;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import selenium.api.base.SeleniumBase;
import utils.DataLibrary;


public class ProjectSpecificMethods extends SeleniumBase {


	public String dataSheetName;		
	public static String incidentNum ="";
	public static String changeNum = "";
	public static String problemNum = "";
	public static String ReqNum = "";
	public static String stdProposalNum = "";
	
	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}	

	@BeforeMethod
	public void beforeMethod() {
		driver = startApp("chrome", "https://dev54932.service-now.com");
		node = test.createNode(testCaseName);
	}

	
/*	 @AfterMethod 
	 public void afterMethod() { 
		  close(); 
	}
	 
*/











}
