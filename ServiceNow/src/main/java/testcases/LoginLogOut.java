package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class LoginLogOut extends ProjectSpecificMethods{	

	@BeforeTest
	public void setValues() {
		testCaseName = "Login to the application";
		testDescription = "Login to the application with different credientials";
		nodes = "ServiceNow-Login";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "LoginDetails";
	}

	@Test(dataProvider = "fetchData")
	public void login(String UserName, String PassWord) {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.switchToFrame(0);
		lp.enterUserName(UserName)
		.enterPassword(PassWord)
		.clickLogin();
		
	}


}





