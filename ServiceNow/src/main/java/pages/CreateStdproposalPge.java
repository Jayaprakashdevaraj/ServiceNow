package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import testng.api.base.ProjectSpecificMethods;

public class CreateStdproposalPge extends ProjectSpecificMethods {

	public WebElement frameInCreateStdproposalPge;

	public CreateStdproposalPge(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public CreateStdproposalPge getProblemNumber() {
		frameInCreateStdproposalPge = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInCreateStdproposalPge);
		stdProposalNum = locateElement("xpath", "//input[@id='std_change_proposal.number']").getAttribute("value");
		defaultContent();
		return this;
	}
	public CreateStdproposalPge enterShortDescription(String ShortDescription) {
		switchToFrame(frameInCreateStdproposalPge);
		clearAndType(locateElement("xpath", "//input[@id='std_change_proposal.short_description']"), ShortDescription);
		defaultContent();
		return this;
	}

	@Given("Click submit button")
	public StdChangeProposalsPage clickSubmit() {
		switchToFrame(frameInCreateStdproposalPge);
		click(locateElement("id", "sysverb_insert"));
		defaultContent();
		return new StdChangeProposalsPage(driver, node, test);
	}

	
}
