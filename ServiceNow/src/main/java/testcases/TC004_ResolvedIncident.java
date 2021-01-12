package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC004_ResolvedIncident extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Resolve incident";
		testDescription = "Resolve the incident and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "ResolveIncident";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void resolvedIncident(String UserName, String PassWord,String SearchReqvalue, String ExistingIncident,String UpdatedState,String UpdateAdditionalComments) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);

		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).selectIncidents().searchExistingIncident(ExistingIncident).clickSearchIncident()
		.selectState(UpdatedState).addAdditionalComments(UpdateAdditionalComments).clickUpdate()
		.verifyState(UpdatedState);

	}
}
