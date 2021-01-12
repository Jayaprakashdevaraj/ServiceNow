package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import testng.api.base.ProjectSpecificMethods;

public class CreateProblemPage extends ProjectSpecificMethods {

	public WebElement frameInCreateProblemPage;
	
	public CreateProblemPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}
	
	public CreateProblemPage getProblemNumber() {
		frameInCreateProblemPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInCreateProblemPage);
		problemNum = locateElement("xpath", "//input[@id='sys_readonly.problem.number']").getAttribute("value");	
		defaultContent();
		return this;
	}
	
	public CreateProblemPage enterShortDescription(String ShortDescription) {
		switchToFrame(frameInCreateProblemPage);
		clearAndType(locateElement("xpath", "//input[@id='problem.short_description']"), ShortDescription);
		defaultContent();
		return this;
	}

	@Given("Click submit button")
	public ProblemsPage clickSubmit() {
		switchToFrame(frameInCreateProblemPage);
		click(locateElement("id", "sysverb_insert"));
		defaultContent();
		return new ProblemsPage(driver, node, test);
	}

	
}
