package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC005_DeleteIncident extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Delete incident";
		testDescription = "Delete the incident and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "DeleteIncident";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void resolvedIncident(String UserName, String PassWord,String SearchReqvalue, String ExistingIncident) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);

		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).selectIncidents().searchExistingIncident(ExistingIncident).clickSearchIncident()
		.clickDelete().searchExistingIncident(ExistingIncident).incidentNotIntable();

	}
}
