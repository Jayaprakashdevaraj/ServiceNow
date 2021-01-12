package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC011_CreateProblem extends ProjectSpecificMethods{	
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Create Problem";
		testDescription = "Create problem and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD011_CreateProblem";		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createProblem(String UserName, String PassWord, String SearchReqvalue, String ShortDescription) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);

		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).clickProblem()
		.clickNewButton()
		.getProblemNumber().enterShortDescription(ShortDescription).clickSubmit()
		.enterProblemNumInSearch(problemNum).verifyProblem(problemNum);
	
		

	}
}
