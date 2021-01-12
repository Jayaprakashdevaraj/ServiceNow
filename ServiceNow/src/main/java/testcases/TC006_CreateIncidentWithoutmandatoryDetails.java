package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC006_CreateIncidentWithoutmandatoryDetails extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Create incident without mandatory fields";
		testDescription = "Create incident without mandatory fields and verifiy the msg";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "CreateNewIncidentwithoutmandatoryFields";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createIncident(String UserName, String PassWord,String SearchReqvalue, String mandatoryError) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).selectIncidents().clickNewButton()
		.getIncidentNumber().clickSubmitWithoutmandatory().mandatoryError(mandatoryError);
		

		

	}
}
