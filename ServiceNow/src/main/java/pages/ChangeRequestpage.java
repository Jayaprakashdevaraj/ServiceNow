package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import testng.api.base.ProjectSpecificMethods;

public class ChangeRequestpage extends ProjectSpecificMethods {
	
	public WebElement frameInChangePage;
	public List<WebElement> changeInTable; 	
	
	
	public ChangeRequestpage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@Given("Select new button")
	public NewChangeReqTypePage clickNewButton() {
		frameInChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInChangePage);
		click(locateElement("id", "sysverb_new"));
		defaultContent();
		return new NewChangeReqTypePage(driver, node, test);

	}

	public ChangeRequestpage selectSearchType(String typeofSearch) {

		WebElement frameInChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInChangePage);
		WebElement searchType = locateElement("xpath", "//select[@class='form-control default-focus-outline']");
		selectDropDownUsingText(searchType, typeofSearch);
		defaultContent();
		return this;
	}
	
	public ChangeRequestpage changeReqNotIntable() {
		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement tableIncident = locateElement("xpath" ,"//table[@id='change_request_table']/tbody//tr/td");
		verifyExactText(tableIncident,"No records to display");
		defaultContent();
		return this;	
		}
	
	
	
	public ChangeRequestpage enterChangeNumInSearch(String changeNum) {

		WebElement frameInChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInChangePage);
		WebElement changeSearch = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(changeSearch, changeNum);
		changeSearch.sendKeys(Keys.ENTER);
		defaultContent();
		return this;
	}
	
	public ChangeRequestpage verifyChange(String changeNum) {
		WebElement frameInChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInChangePage);

		changeInTable = locateElements("xpath", "//table[@id='change_request_table']/tbody//tr");
		int size = changeInTable.size();
		for (int i = 1; i <= size; i++) {
			WebElement checkNewChange = locateElement("xpath", "//table[@id='change_request_table']/tbody//tr["+i+"]/td[3]");
			verifyExactText(checkNewChange, changeNum);
			break;
		}
		defaultContent();
		return this;

	}

	public ChangeRequestpage searchExistingChange(String ExistingChange) {
		WebElement frameInChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInChangePage);
		WebElement search = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(search, ExistingChange);
		search.sendKeys(Keys.ENTER);
		defaultContent();
		return this;	
		}
	
	public UpdateChangePage clickSearchChange() {
		WebElement frameInChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInChangePage);
		WebElement tableChangeNo = locateElement("xpath" ,"//table[@id='change_request_table']/tbody//tr[1]/td[3]");
		click(tableChangeNo);
		defaultContent();
		return new UpdateChangePage(driver, node, test);
	}

	public ChangeRequestpage verifyState(String UpdatedState) {
		WebElement frameInChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInChangePage);
		changeInTable = locateElements("xpath", "//table[@id='change_request_table']/tbody//tr");
		int size = changeInTable.size();
		for (int i = 1; i <= size; i++) {
			WebElement checkState = locateElement("xpath", "//table[@id='change_request_table']/tbody//tr["+i+"]/td[6]");
			verifyExactText(checkState, UpdatedState);
			break;
		}
		defaultContent();
		return this;
	}
	public ChangeRequestpage verifyAssignTo(String UpdateAssignTo) {
		WebElement frameInChangePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInChangePage);
		changeInTable = locateElements("xpath", "//table[@id='change_request_table']/tbody//tr");
		int size = changeInTable.size();
		for (int i = 1; i <= size; i++) {
			WebElement checkAssignTo = locateElement("xpath", "//table[@id='change_request_table']/tbody//tr["+i+"]/td[10]");
			verifyExactText(checkAssignTo, UpdateAssignTo);
			break;
		}
		defaultContent();
		return this;
	}

	
}
