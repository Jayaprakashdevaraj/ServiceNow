package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC007_CreateChanges extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Create Changes";
		testDescription = "Create Changes and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD007_CreateNewChange";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createchanges(String UserName, String PassWord,String SearchReqvalue, String changeType, String ShortDescription) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).clickChange()
		.clickNewButton().clickReqChange(changeType)
		.getChangeNumber().enterShortDescription(ShortDescription).clickSubmit()
		.enterChangeNumInSearch(changeNum).verifyChange(changeNum);
		

	}
}
