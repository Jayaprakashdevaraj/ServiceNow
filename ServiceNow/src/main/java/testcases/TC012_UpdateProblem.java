package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC012_UpdateProblem extends ProjectSpecificMethods{	
	
	@BeforeTest
	public void setValues() {
		testCaseName = "Update Problem";
		testDescription = "Update problem and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD012_UpdateProblem";		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void updateProblem(String UserName, String PassWord, String SearchReqvalue, String ExistingProblem, String updateImpact, String updateUrgency, String updateWorknote) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);

		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).clickProblem()
		.searchExistingProblem(ExistingProblem).clickSearchProblem()
		.changeImpact(updateImpact).changeUrgency(updateUrgency).addWorknote(updateWorknote).clickUpdate()
		.verifyImpact(updateImpact).verifyUrgency(updateUrgency);

	}
}
