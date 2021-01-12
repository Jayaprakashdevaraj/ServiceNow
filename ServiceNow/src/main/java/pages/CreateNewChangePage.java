package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class CreateNewChangePage extends ProjectSpecificMethods {
	public WebElement frameInCreateChange;
	
	
	public CreateNewChangePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public CreateNewChangePage getChangeNumber() {
		frameInCreateChange = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInCreateChange);
		changeNum = locateElement("xpath", "//input[@name='change_request.number']").getAttribute("value");
		defaultContent();
		return this;
	}
	
	public CreateNewChangePage enterShortDescription(String ShortDescription) {
		switchToFrame(frameInCreateChange);
		clearAndType(locateElement("xpath", "//input[@id='change_request.short_description']"), ShortDescription);
		defaultContent();
		return this;
	}
	public ChangeRequestpage clickSubmit() {
		switchToFrame(frameInCreateChange);
		click(locateElement("id", "sysverb_insert"));
		defaultContent();
		return new ChangeRequestpage(driver, node, test);
	}
	
	
}
