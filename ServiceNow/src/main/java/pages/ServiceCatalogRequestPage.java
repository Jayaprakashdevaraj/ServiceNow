package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import testng.api.base.ProjectSpecificMethods;

public class ServiceCatalogRequestPage extends ProjectSpecificMethods {

	public WebElement frameInReqPage;

	public ServiceCatalogRequestPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}
	
	public ServiceCatalogRequestPage enterExistingReqno(String ExistingReqNo) {
		WebElement frameInReqPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInReqPage);
		WebElement search = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(search, ExistingReqNo);
		search.sendKeys(Keys.ENTER);
		defaultContent();
		return this;
	}
	public ServiceCatalogRequestPage enterNewReqno() {
		WebElement frameInReqPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInReqPage);
		WebElement search = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(search, ReqNum);
		search.sendKeys(Keys.ENTER);
		defaultContent();
		return this;
	}
	public ServiceCatalogRequestPage reqtNotIntable() {
		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement tableIncident = locateElement("xpath" ,"//table[@id='sc_request_table']/tbody//tr/td");
		verifyExactText(tableIncident,"No records to display");
		defaultContent();
		return this;	
		}
	

	public UpdateRequestPage clickSearchReq() {
		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement tableIncidentNo = locateElement("xpath" ,"//table[@id='sc_request_table']/tbody//tr/td[3]/a");
		click(tableIncidentNo);
		defaultContent();
		return new UpdateRequestPage(driver, node, test);
	}

	public ServiceCatalogRequestPage ClickServiceCatelogRequest() {
		click(locateElement("xpath", "//span[text()='Service Catalog']/following::div[text()='Requests']"));
		return new ServiceCatalogRequestPage(driver, node, test);
	}
	
	

}
