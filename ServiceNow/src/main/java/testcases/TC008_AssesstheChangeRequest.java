package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC008_AssesstheChangeRequest extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Assess the Change Request";
		testDescription = "Assess the Change Request and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD008_AssesstheChangeRequest";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createchanges(String UserName, String PassWord,String SearchReqvalue,String typeofSearch, String ExistingChange, String UpdatedState,String UpdateAssignmentgroup, String UpdateAssignTo) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).clickChange().selectSearchType(typeofSearch).searchExistingChange(ExistingChange).clickSearchChange()
		.selectState(UpdatedState).enterAssignmentgroup(UpdateAssignmentgroup).clickSearchInAssignTo(UpdateAssignTo).clickUpdate()
		.verifyState(UpdatedState).verifyAssignTo(UpdateAssignTo);	
		

	}
}
