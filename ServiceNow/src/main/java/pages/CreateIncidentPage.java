package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import testng.api.base.ProjectSpecificMethods;

public class CreateIncidentPage extends ProjectSpecificMethods {

	public WebElement frameInCreateIncident;
	
	public CreateIncidentPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	@Given("Get new incident number")
	public CreateIncidentPage getIncidentNumber() {
		frameInCreateIncident = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInCreateIncident);
		incidentNum = locateElement("xpath", "//input[@name='incident.number']").getAttribute("value");	
		System.out.println(incidentNum);
		defaultContent();
		return this;
	}
	
	

	@Given("Enter Short Description in short description text field")
	public CreateIncidentPage enterShortDescription(String ShortDescription) {
		switchToFrame(frameInCreateIncident);
		clearAndType(locateElement("xpath", "//input[@id='incident.short_description']"), ShortDescription);
		defaultContent();
		return this;
	}

	@Given("Click submit button")
	public IncidentsPage clickSubmit() {
		switchToFrame(frameInCreateIncident);
		click(locateElement("id", "sysverb_insert"));
		defaultContent();
		return new IncidentsPage(driver, node, test);
	}
	
	public CreateIncidentPage clickSubmitWithoutmandatory() {
		switchToFrame(frameInCreateIncident);
		click(locateElement("id", "sysverb_insert"));
		defaultContent();
		return this;
	}

	public CreateIncidentPage mandatoryError(String mandatoryError) {
		switchToFrame(frameInCreateIncident);
		WebElement errormsg = locateElement("xpath", "//span[@class='outputmsg_text']");
		verifyPartialText(errormsg, mandatoryError);
		defaultContent();
		return this;	
		
	}
	
}
