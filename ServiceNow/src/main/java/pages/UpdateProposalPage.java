package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class UpdateProposalPage extends ProjectSpecificMethods {

	public WebElement frameInUpdateProposalsPage;
	public WebElement proposalInTable;
	
	public UpdateProposalPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	
	public UpdateProposalPage changeAssignmentGroup(String AssignmentGroup) {
		frameInUpdateProposalsPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProposalsPage);	
		WebElement selectAssignmentGroup = locateElement("xpath", "//input[@id='sys_display.std_change_proposal.assignment_group']");
		clearAndType(selectAssignmentGroup, AssignmentGroup);

		defaultContent();
		return this;
	}
	
	public UpdateProposalPage changeAssignedTo(String AssignedTo) {
		frameInUpdateProposalsPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProposalsPage);	
		WebElement selectAssignedTo = locateElement("xpath", "//input[@id='sys_display.std_change_proposal.assigned_to']");
		clearAndType(selectAssignedTo, AssignedTo);
		
		defaultContent();
		return this;
	}
	
	public UpdateProposalPage changeState(String State) {
		frameInUpdateProposalsPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProposalsPage);	
		WebElement selectState = locateElement("xpath", "//select[@id='std_change_proposal.state']");
		selectDropDownUsingText(selectState, State);
		defaultContent();
		return this;
	}
	
	
	public UpdateProposalPage changeCategory(String Category) {
		frameInUpdateProposalsPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProposalsPage);	
		WebElement selectAssignedTo = locateElement("xpath", "//input[@id='sys_display.std_change_proposal.category']");
		clearAndType(selectAssignedTo, Category);
		defaultContent();
		return this;
	}
	

	public UpdateProposalPage clickChangeReqValue() {
		frameInUpdateProposalsPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProposalsPage);
		click(locateElement("xpath" ,"//span[@class='tabs2_tab default-focus-outline']"));
		defaultContent();
		return this;
	}
	
	public UpdateProposalPage enterJustification(String Justification) {
		frameInUpdateProposalsPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProposalsPage);	
		WebElement addJustification = locateElement("xpath", "//td[@data-value='Justification']//textarea[1]");
		clearAndType(addJustification, Justification);
		defaultContent();
		return this;
	}
	
	
	public UpdateProposalPage enterRiskAndImpact(String RiskAndImpact) {
		frameInUpdateProposalsPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProposalsPage);	
		WebElement addRiskAndImpact = locateElement("xpath", "//td[@data-value='Risk and impact analysis']//textarea[1]");
		clearAndType(addRiskAndImpact, RiskAndImpact);
		defaultContent();
		return this;
	}
	
	public UpdateProposalPage changeAssignmentGroupInChgReq(String AssignmentGroup) {
		frameInUpdateProposalsPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProposalsPage);	
		WebElement selectAssignmentGroup = locateElement("xpath", "//input[@aria-label='Input value for field: Assignment group'][2]");
		clearAndType(selectAssignmentGroup, AssignmentGroup);
		defaultContent();
		return this;
	}
	
	
	

	
	
	public StdChangeProposalsPage clickUpdate() throws InterruptedException {
		WebElement frameInUpdateProposalsPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProposalsPage);
		click(locateElement("xpath", "//button[@id='sysverb_update']"));
		Thread.sleep(3000);
		defaultContent();
		return new StdChangeProposalsPage(driver, node, test);
	}


}
