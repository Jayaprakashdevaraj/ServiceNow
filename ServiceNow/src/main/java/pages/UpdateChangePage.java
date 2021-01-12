package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class UpdateChangePage extends ProjectSpecificMethods {

	public WebElement frameInUpdateChangePage;

	public UpdateChangePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public UpdateChangePage selectState(String UpdatedState) {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement selectState = locateElement("xpath", "//select[@id='change_request.state']");
		selectDropDownUsingText(selectState, UpdatedState);
		defaultContent();
		return this;
	}

	public UpdateChangePage enterAssignmentgroup(String UpdateAssignmentgroup) {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement assignmentgroup = locateElement("xpath", "//input[@id='sys_display.change_request.assignment_group']");
		clearAndType(assignmentgroup, UpdateAssignmentgroup);
		assignmentgroup.sendKeys(Keys.ENTER);
		defaultContent();
		return this;
	}

	public UpdateChangePage clickSearchInAssignTo(String UpdateAssignTo) {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement assignedTo = locateElement("xpath", "//input[@id='sys_display.change_request.assigned_to']");
		clearAndType(assignedTo, UpdateAssignTo);
		assignedTo.sendKeys(Keys.ENTER);
		defaultContent();
		return this;
	}

	public UpdateChangePage clickSchedule() {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		click(locateElement("xpath", "//span[text()='Schedule']"));
		defaultContent();
		return this;
		
	}
	

	public UpdateChangePage plannedStartDate(String planStart) {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement plannedStart = locateElement("xpath", "//input[@id='change_request.start_date']");
		clearAndType(plannedStart, planStart);
		defaultContent();
		return this;
	}
	
	public UpdateChangePage plannedEndDate(String planEnd) {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement plannedEnd = locateElement("xpath", "//input[@id='change_request.end_date']");
		clearAndType(plannedEnd, planEnd);
		defaultContent();
		return this;
	}
	
	
	public UpdateChangePage actualStartDate(String actualStart) {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement actualStartDate = locateElement("xpath", "//input[@id='change_request.work_start']");
		clearAndType(actualStartDate, actualStart);
		defaultContent();
		return this;
	}
	
	public UpdateChangePage actualEndDate(String actualEnd) {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement actualEndDate = locateElement("xpath", "//input[@id='change_request.work_end']");
		clearAndType(actualEndDate, actualEnd);
		defaultContent();
		return this;
	}
	
	public UpdateChangePage CABRequired() {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement cabCheck = locateElement("xpath", "//label[@id='label.ni.change_request.cab_required']");
		click(cabCheck);
		defaultContent();
		return this;
	}
	
	public UpdateChangePage CABDate(String cab) {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement cabDate = locateElement("xpath", "//input[@id='change_request.cab_date']");
		clearAndType(cabDate, cab);
		defaultContent();
		return this;
	}

	public ChangeRequestpage clickUpdate() throws InterruptedException {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement update = locateElement("xpath", "//button[@id='sysverb_update']");
		click(update);
		Thread.sleep(3000);
		defaultContent();
		return new ChangeRequestpage(driver, node, test);
	}

	public ChangeRequestpage clickDelete() throws InterruptedException {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		click(locateElement("xpath", "//button[@id='sysverb_delete']"));
		click(locateElement("xpath", "//button[@id='ok_button']"));
		Thread.sleep(3000);
		defaultContent();
		return new ChangeRequestpage(driver, node, test);
	}
	
	
	
	
	
/*	public void commonDataPicker() {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		click(locateElement("xpath", "//span[@class='icon-calendar icon']"));
		WebElement datePickerPopup = locateElement("xpath", "//table[@class='drag_section_header']");
		WebElement datepicker = locateElement("xpath", "//table[@class='calTable']");
		WebElement clickPreviousMonth = locateElement("xpath", "//table[@class='calTable']//tr/td[1]");
		WebElement currentMonth = locateElement("xpath", "//table[@class='calTable']//tr/td[2]");
		WebElement clickNextMonth = locateElement("xpath", "//table[@class='calTable']//tr/td[3]");	
	}
*/	
	
/*	public ChangeLookupPage clickSearchInAssignTo() {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		WebElement lookupButton = locateElement("xpath", "//button[@id='lookup.change_request.assigned_to']");
		click(lookupButton);
		defaultContent();
		return new ChangeLookupPage(driver, node, test);
	}
	
	public UpdateChangePage selectreqAssignLooup(String UpdateAssignTo) {
		WebElement frameInUpdateChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateChangePage);
		switchToWindow("Users | ServiceNow");
		WebElement search = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(search, UpdateAssignTo);
		search.sendKeys(Keys.ENTER);
		List<WebElement> locateElements = locateElements("xpath", "//table[@id='sys_user_table']/tbody//tr");
		int size = locateElements.size();
		for(int i=1; i<=size;i++) {
			WebElement cellValue = locateElement("xpath", "//table[@id='sys_user_table']/tbody//tr["+i+"]/td[3]");
			verifyExactText(cellValue, UpdateAssignTo);
			click(cellValue);
			break;
		}
		defaultContent();
		return this;	
		}
*/	
	

}
