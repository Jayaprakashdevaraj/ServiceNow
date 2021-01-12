package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class UpdateRequestPage extends ProjectSpecificMethods {

	public WebElement frameInUpdateRequest;

	public UpdateRequestPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}
	public UpdateRequestPage verifyreqNumber(String ExistingReqNo) {
		frameInUpdateRequest = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateRequest);	
		WebElement reqNoInUpdatePg = locateElement("xpath", "//input[@id='sys_original.sc_request.number']");
		verifyExactAttribute(reqNoInUpdatePg, "value", ExistingReqNo);
		defaultContent();
		return this;
	}

	public UpdateRequestPage changeApproval(String Approval) {
		frameInUpdateRequest = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateRequest);	
		WebElement selectApproval = locateElement("xpath", "//select[@id='sc_request.approval']");
		selectDropDownUsingText(selectApproval, Approval);
		defaultContent();
		return this;
	}
	
	public UpdateRequestPage changeRequestState(String RequestState) {
		frameInUpdateRequest = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateRequest);	
		WebElement selectRequestState = locateElement("xpath", "//select[@id='sc_request.request_state']");
		selectDropDownUsingText(selectRequestState, RequestState);
		defaultContent();
		return this;
	}
	
	public ServiceCatalogRequestPage clickUpdate() throws InterruptedException {
		WebElement incidentFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(incidentFrame);
		click(locateElement("xpath", "//button[@id='sysverb_update']"));
		Thread.sleep(3000);
		defaultContent();
		return new ServiceCatalogRequestPage(driver, node, test);
	}

	public ServiceCatalogRequestPage clickCancel() throws InterruptedException {
		WebElement incidentFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(incidentFrame);
		click(locateElement("xpath", "//button[text()='Cancel Request']"));
		Thread.sleep(3000);
		defaultContent();
		return new ServiceCatalogRequestPage(driver, node, test);
	}
	
	public ServiceCatalogRequestPage clickDelete() throws InterruptedException {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		click(locateElement("xpath", "//button[@id='sysverb_delete']"));
		click(locateElement("xpath", "//button[@id='ok_button']"));
		Thread.sleep(3000);
		defaultContent();
		return new ServiceCatalogRequestPage(driver, node, test);
	}

	
}