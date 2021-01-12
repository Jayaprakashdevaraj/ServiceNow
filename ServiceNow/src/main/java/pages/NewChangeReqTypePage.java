package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class NewChangeReqTypePage extends ProjectSpecificMethods {
	public WebElement frameInChangeTypePage;
	
	
	public NewChangeReqTypePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
public CreateNewChangePage clickReqChange(String changeType) {
	frameInChangeTypePage = locateElement("xpath", "//iframe[@id='gsft_main']");
	switchToFrame(frameInChangeTypePage);
	click(locateElement("xpath", "//a[contains(text(),"+changeType+")]"));
	defaultContent();
	return new CreateNewChangePage(driver, node, test);


}
}
