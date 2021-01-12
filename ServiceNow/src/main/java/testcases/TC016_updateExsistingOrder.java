package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC016_updateExsistingOrder extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Update mobile order";
		testDescription = "Update mobile order and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD016_UpdateOrder";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void updateMobileOrder(String UserName, String PassWord,String SearchReqvalue,String ExistingReqNo, String Approval, String RequestState) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).ClickServiceCatelogRequest()
		.enterExistingReqno(ExistingReqNo).clickSearchReq()
		.verifyreqNumber(ExistingReqNo)
		.changeApproval(Approval).changeRequestState(RequestState).clickUpdate();
		

	}
}
