package pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.hc.core5.http2.impl.nio.ClientH2StreamMultiplexer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import testng.api.base.ProjectSpecificMethods;

public class IncidentsPage extends ProjectSpecificMethods {

	public WebElement incidentFrame;
	public WebElement searchIncident;
	public static WebElement incidentInTable;
	public List<WebElement> incidentTable;
	
	public IncidentsPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@Given("Select new button")
	public CreateIncidentPage clickNewButton() {
		incidentFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(incidentFrame);
		click(locateElement("id", "sysverb_new"));
		defaultContent();
		return new CreateIncidentPage(driver, node, test);

	}

	@Given("Search incident with incident number")
	public IncidentsPage enterIncidentNumInSearch(String incidentNum) {

		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement search = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(search, incidentNum);
		search.sendKeys(Keys.ENTER);
		defaultContent();
		return this;
	}

	@Given("Verify the new incident")
	public IncidentsPage verifyIncident(String incidentNum) {
		WebElement searchFrameInTable = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrameInTable);
		incidentInTable = locateElement("xpath","//a[@class='linked formlink']");
		verifyExactText(incidentInTable, incidentNum);
		defaultContent();
		return this;
	}

	@Then("search the existing incident")
	public IncidentsPage searchExistingIncident(String ExistingIncident) {
		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement search = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(search, ExistingIncident);
		search.sendKeys(Keys.ENTER);
		defaultContent();
		return this;	
		}
	
	
	public IncidentsPage incidentNotIntable() {
		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement tableIncident = locateElement("xpath" ,"//table[@id='incident_table']/tbody//tr/td");
		verifyExactText(tableIncident,"No records to display");
		defaultContent();
		return this;	
		}
	
	
	
	public UpdateIncidentPage clickSearchIncident() {
		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement tableIncidentNo = locateElement("xpath" ,"//table[@id='incident_table']/tbody//tr/td[3]");
		click(tableIncidentNo);
		defaultContent();
		return new UpdateIncidentPage(driver, node, test);
	}

	public IncidentsPage verifyUrgency(String UpdatedUrgency) {
		WebElement searchFrameInTable = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrameInTable);

		incidentTable = locateElements("xpath", "//table[@id='incident_table']/tbody//tr");
		int size = incidentTable.size();
		for (int i = 1; i <= size; i++) {
			WebElement checkUrgency = locateElement("xpath", "//table[@id='incident_table']/tbody//tr["+i+"]/td[10]");
			
			verifyExactText(checkUrgency, UpdatedUrgency);
			break;
		}
		defaultContent();
		return this;
	}

	public IncidentsPage verifyState(String UpdatedState) {
		WebElement searchFrameInTable = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrameInTable);

		incidentTable = locateElements("xpath", "//table[@id='incident_table']/tbody//tr");
		int size = incidentTable.size();
		for (int i = 1; i <= size; i++) {
			WebElement checkState = locateElement("xpath", "//table[@id='incident_table']/tbody//tr["+i+"]/td[7]");
			verifyExactText(checkState, UpdatedState);
			break;
		}
		defaultContent();
		return this;
	}

	public IncidentsPage verifyAdditionalCmd(String UpdateAdditionalComments) {
		WebElement searchFrameInTable = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrameInTable);

		incidentTable = locateElements("xpath", "//table[@id='incident_table']/tbody//tr");
		int size = incidentTable.size();
		for (int i = 1; i <= size; i++) {
			WebElement checkState = locateElement("xpath", "//table[@id='incident_table']/tbody//tr["+i+"]/td[7]");
			verifyExactText(checkState, UpdateAdditionalComments);
			break;
		}
		defaultContent();
		return this;
	}
}
