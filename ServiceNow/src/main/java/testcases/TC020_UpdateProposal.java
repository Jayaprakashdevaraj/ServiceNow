package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateIncidentPage;
import pages.IncidentsPage;
import pages.LoginPage;
import testng.api.base.ProjectSpecificMethods;

public class TC020_UpdateProposal extends ProjectSpecificMethods{	


	
	@BeforeTest
	public void setValues() {
		testCaseName = "Update Standard Change Proposals";
		testDescription = "Update Standard Change Proposals and verifiy ";
		nodes = "ServiceNow";
		authors = "Jayaprakash";
		category = "Smoke";
		dataSheetName = "TD020_UpdateProposal";
		
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createStdProposal(String UserName, String PassWord,String SearchReqvalue, String ExistStdProposalNum, String AssignmentGroup, String AssignedTo, String State, String Category, String Justification, String RiskAndImpact) throws InterruptedException {
		LoginPage lp =new LoginPage(driver, node, test);
		
		lp.enterUserName(UserName).enterPassword(PassWord).clickLogin()
		.enteroptionInSearch(SearchReqvalue).ClickMyProposal()
		.enterExistStdPropsalNumInSearch(ExistStdProposalNum).verifyStdproposal(ExistStdProposalNum).clickSearchProposal()
		.changeAssignmentGroup(AssignmentGroup).changeAssignedTo(AssignedTo).changeState(State).changeCategory(Category)
		.clickChangeReqValue().changeAssignmentGroupInChgReq(AssignmentGroup).enterJustification(Justification).enterRiskAndImpact(RiskAndImpact).clickUpdate();

	}
}
