package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC014_DeleteProblem extends ProjectSpecificMethods{	
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Delete Problem";
		testDescription = "Delete problem and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD014_DeleteProblem";		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void deleteProblem(String UserName, String PassWord, String SearchReqvalue, String ExistingProblem) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);

		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).clickProblem()
		.searchExistingProblem(ExistingProblem).clickSearchProblem()
		.clickDelete()
		.searchExistingProblem(ExistingProblem).problemNotIntable();

	}
}
