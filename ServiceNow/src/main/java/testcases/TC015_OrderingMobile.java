package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC015_OrderingMobile extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Oreder mobile";
		testDescription = "Order mobile and verifiy";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD015_OrderMobile";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void orderMobile(String UserName, String PassWord,String SearchReqvalue, String MobileModel, String color, String stroage, String OrderedSuccessfully) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).ClickServiceCatelog()
		.clickMobile()
		.clickMobileModel(MobileModel)
		.selectColor(color).selectStroage(stroage).clickOrder()
		.VerifyOderPlaced(OrderedSuccessfully).getReqNo();
		

	}
}
