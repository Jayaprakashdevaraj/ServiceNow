package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class ChangeLookupPage extends ProjectSpecificMethods {
	
	public WebElement frameInUpdateChangePage;
	
	
	
	public ChangeLookupPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public UpdateChangePage selectAssignedTo(String UpdateAssignTo) {
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
		return new UpdateChangePage(driver, node, test);

	}

}
