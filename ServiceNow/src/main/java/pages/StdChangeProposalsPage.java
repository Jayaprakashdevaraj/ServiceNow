package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import testng.api.base.ProjectSpecificMethods;

public class StdChangeProposalsPage extends ProjectSpecificMethods {

	public WebElement frameInStandardChangeProposalsPage;
	public WebElement proposalInTable;
	
	public StdChangeProposalsPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public CreateStdproposalPge clickNewButton() {
		frameInStandardChangeProposalsPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInStandardChangeProposalsPage);
		click(locateElement("id", "sysverb_new"));
		defaultContent();
		return new CreateStdproposalPge(driver, node, test);

	}
	@Given("Search incident with incident number")
	public StdChangeProposalsPage enterStdPropsalNumInSearch(String stdProposalNum) {

		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement search = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(search, stdProposalNum);
		search.sendKeys(Keys.ENTER);
		defaultContent();
		return this;
	}


	public StdChangeProposalsPage enterExistStdPropsalNumInSearch(String ExistStdProposalNum) {

		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement search = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(search, ExistStdProposalNum);
		search.sendKeys(Keys.ENTER);
		defaultContent();
		return this;
	}

	
	
	
	@Given("Verify the new incident")
	public StdChangeProposalsPage verifyStdproposal(String ExistStdProposalNum) {
		WebElement searchFrameInTable = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrameInTable);
		proposalInTable = locateElement("xpath","//a[@class='linked formlink']");
		verifyExactText(proposalInTable, ExistStdProposalNum);
		defaultContent();
		return this;
	}


	public UpdateProposalPage clickSearchProposal() {
		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement tableProposaltNo = locateElement("xpath" ,"//table[@id='std_change_proposal_table']/tbody//tr/td[3]");
		click(tableProposaltNo);
		defaultContent();
		return new UpdateProposalPage(driver, node, test);
	}

}
