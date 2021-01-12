package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC009_UpdatescheduleInExtChange extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Update the schedule";
		testDescription = "Update the schedule in Existing Change Request and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD009_UpdatescheduleexistingChange";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createchanges(String UserName, String PassWord,String SearchReqvalue, String typeofSearch, String ExistingChange, String planStart,String planEnd, String cab, String actualStart, String actualEnd) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).clickChange().selectSearchType(typeofSearch).searchExistingChange(ExistingChange).clickSearchChange()
		.clickSchedule().plannedStartDate(planStart).plannedEndDate(planEnd).CABRequired().CABDate(cab).actualStartDate(actualStart).actualEndDate(actualEnd).clickUpdate();
		

	}
}
