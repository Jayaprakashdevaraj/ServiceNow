package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC010_DeleteExtChange extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Delete the Change Request";
		testDescription = "delete the Change Request and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD010_DeleteexistingChange";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createchanges(String UserName, String PassWord,String SearchReqvalue, String typeofSearch, String ExistingChange) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).clickChange().selectSearchType(typeofSearch).searchExistingChange(ExistingChange).clickSearchChange()
		.clickDelete()
		.selectSearchType(typeofSearch).searchExistingChange(ExistingChange).changeReqNotIntable();

		

	}
}
