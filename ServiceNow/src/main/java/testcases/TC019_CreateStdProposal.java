package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC019_CreateStdProposal extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Create Standard Change Proposals";
		testDescription = "Create Standard Change Proposals and verifiy ";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD019_CreateNewProposal";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createStdProposal(String UserName, String PassWord,String SearchReqvalue, String ShortDescription) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).ClickMyProposal()
		.clickNewButton()
		.getProblemNumber().enterShortDescription(ShortDescription).clickSubmit()
		.enterStdPropsalNumInSearch(stdProposalNum).verifyStdproposal(stdProposalNum);
		

		

	}
}
