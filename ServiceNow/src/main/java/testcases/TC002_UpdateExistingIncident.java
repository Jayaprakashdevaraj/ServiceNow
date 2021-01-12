package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC002_UpdateExistingIncident extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Update incident";
		testDescription = "Update incident and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "UpdateExistingIncident";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void UpdateIncident(String UserName, String PassWord,String SearchReqvalue, String ExistingIncident,String UpdatedUrgency,String UpdatedState) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);

		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).selectIncidents().searchExistingIncident(ExistingIncident).clickSearchIncident()
		.selectUrgency(UpdatedUrgency).selectState(UpdatedState).clickUpdate()
		.verifyUrgency(UpdatedUrgency).verifyState(UpdatedState);

	}
}
