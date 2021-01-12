package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC017_CancelMobileOrder extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Cancel mobile order";
		testDescription = "Cancel mobile order and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD017_CancelMobileOrder";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void orderMobile(String UserName, String PassWord,String SearchReqvalue, String MobileModel, String color, String stroage, String OrderedSuccessfully,String Approval,String RequestState) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).ClickServiceCatelog()
		.clickMobile()
		.clickMobileModel(MobileModel)
		.selectColor(color).selectStroage(stroage).clickOrder()
		.VerifyOderPlaced(OrderedSuccessfully).getReqNo().clickReqNo()
		.changeApproval(Approval).changeRequestState(RequestState).clickCancel();
		

	}
}
