package pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class UpdateProblemPage extends ProjectSpecificMethods {

	public WebElement frameInUpdateProblemPage;

	public UpdateProblemPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}
	
	public UpdateProblemPage changeImpact(String updateImpact) {
		frameInUpdateProblemPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProblemPage);
		WebElement impact = locateElement("id", "problem.impact");
		selectDropDownUsingText(impact, updateImpact);
		defaultContent();
		return this;
	}

	public UpdateProblemPage changeUrgency(String updateUrgency) {
		frameInUpdateProblemPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProblemPage);
		WebElement impact = locateElement("id", "problem.urgency");
		selectDropDownUsingText(impact, updateUrgency);
		defaultContent();
		return this;
	}

	public UpdateProblemPage addWorknote(String updateWorknote) {
		frameInUpdateProblemPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProblemPage);
		WebElement worknote = locateElement("xpath", "//textarea[contains(@class,'sn-string-textarea form-control')]");
													  
		clearAndType(worknote, updateWorknote);
		defaultContent();
		return this;
	}

	public ProblemsPage clickUpdate() throws InterruptedException {
		frameInUpdateProblemPage= locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProblemPage);
		click(locateElement("xpath", "//button[@id='sysverb_update']"));
		Thread.sleep(3000);
		defaultContent();
		return new ProblemsPage(driver, node, test);
	}

	public ProblemsPage clickDelete() {
		frameInUpdateProblemPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInUpdateProblemPage);
		click(locateElement("xpath", "//button[@id='sysverb_delete']"));
		click(locateElement("xpath", "//button[@id='ok_button']"));
		defaultContent();
		return new ProblemsPage(driver, node, test);
	}

}
