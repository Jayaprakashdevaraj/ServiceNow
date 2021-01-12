package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class UpdateIncidentPage extends ProjectSpecificMethods {

	
	
	public UpdateIncidentPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}
	
	public UpdateIncidentPage selectUrgency(String UpdatedUrgency) {
		WebElement incidentFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(incidentFrame);
		WebElement urgency = locateElement("xpath", "//select[@id='incident.urgency']");
		selectDropDownUsingText(urgency, UpdatedUrgency);
		defaultContent();
		return this;
	}
	
	public UpdateIncidentPage selectState(String UpdatedState) {
		WebElement incidentFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(incidentFrame);
		WebElement selectState = locateElement("xpath", "//select[@id='incident.state']");
		selectDropDownUsingText(selectState, UpdatedState);
		defaultContent();
		return this;
		
	}
	

	
	
	public UpdateIncidentPage addAdditionalComments(String UpdateAdditionalComments) {
		WebElement incidentFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(incidentFrame);
		WebElement additionalCmd = locateElement("xpath", "//textarea[@id='activity-stream-textarea']");
		clearAndType(additionalCmd, UpdateAdditionalComments);
		defaultContent();
		return this;
	}
	
	public IncidentsPage clickUpdate() {
		WebElement incidentFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(incidentFrame);
		click(locateElement("xpath", "//button[@id='sysverb_update']"));
		defaultContent();
		return new IncidentsPage(driver, node, test);
	}

	public IncidentsPage clickDelete() {
		WebElement incidentFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(incidentFrame);
		click(locateElement("xpath", "//button[@id='sysverb_delete']"));
		click(locateElement("xpath", "//button[@id='ok_button']"));
		defaultContent();
		return new IncidentsPage(driver, node, test);
	}
	
	
}
