package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class OrderStatusPage extends ProjectSpecificMethods {

	public WebElement frameIniPhonePage;

	public OrderStatusPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public OrderStatusPage VerifyOderPlaced(String OrderedSuccessfully) {
		frameIniPhonePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameIniPhonePage);
		WebElement VerificationText = locateElement("xpath", "//div[@id='sc_order_status_intro_text']//span");
		verifyExactText(VerificationText, OrderedSuccessfully);
		System.out.println(OrderedSuccessfully);
		defaultContent();
		return this;	
	}

	public OrderStatusPage getReqNo() {
		frameIniPhonePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameIniPhonePage);
		ReqNum = locateElement("id", "requesturl").getText();
		defaultContent();
		return this;	
	}
	
	public UpdateRequestPage clickReqNo() {
		frameIniPhonePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameIniPhonePage);
		click(locateElement("id", "requesturl"));
		defaultContent();
		return new UpdateRequestPage(driver, node, test);	
	}
		

}
