package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC001_CreateIncident extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Create incident";
		testDescription = "Create incident and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "CreateNewIncident";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createIncident(String UserName, String PassWord, String SearchReqvalue, String ShortDescription) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).selectIncidents().clickNewButton()
		.getIncidentNumber().enterShortDescription(ShortDescription).clickSubmit()
		.enterIncidentNumInSearch(incidentNum).verifyIncident(incidentNum);

		

	}
}
