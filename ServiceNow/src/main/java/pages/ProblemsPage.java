package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import testng.api.base.ProjectSpecificMethods;

public class ProblemsPage extends ProjectSpecificMethods {

	public WebElement frameInProblem;
	public WebElement problemInTable;
	public ProblemsPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public CreateProblemPage clickNewButton() {
		WebElement frameInProblem = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInProblem);
		click(locateElement("id", "sysverb_new"));
		defaultContent();
		return new CreateProblemPage(driver, node, test);
	}
	
	public ProblemsPage enterProblemNumInSearch(String problemNum) {

		WebElement frameInProblem = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInProblem);

		WebElement search = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(search, problemNum);
		search.sendKeys(Keys.ENTER);
		defaultContent();
		return this;
	}

	@Given("Verify the new pro")
	public ProblemsPage verifyProblem(String problemNum) {
		WebElement frameInProblem = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInProblem);
		problemInTable = locateElement("xpath","//a[@class='linked formlink']");
		verifyExactText(problemInTable , problemNum);
		defaultContent();
		return this;
	}

	public ProblemsPage searchExistingProblem(String ExistingProblem) {
		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement search = locateElement("xpath", "//input[@placeholder='Search' and @class ='form-control']");
		clearAndType(search, ExistingProblem);
		search.sendKeys(Keys.ENTER);
		defaultContent();
		return this;	
		}
	
	
	public UpdateProblemPage clickSearchProblem() {
		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement tableProblemNo = locateElement("xpath" ,"//table[@id='problem_table']/tbody//tr/td[3]");
		click(tableProblemNo);
		defaultContent();
		return new UpdateProblemPage(driver, node, test);
	}


	public ProblemsPage verifyImpact(String updateImpact) {
		WebElement searchFrameInTable = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrameInTable);
		List<WebElement> problemTable = locateElements("xpath", "//table[@id='problem_table']/tbody//tr");
		int size = problemTable.size();
		for (int i = 1; i <= size; i++) {
			WebElement checkImpact = locateElement("xpath", "//table[@id='problem_table']/tbody//tr["+i+"]/td[8]");
			verifyExactText(checkImpact, updateImpact);
			
		}
		defaultContent();
		return this;
	}

	public ProblemsPage verifyUrgency(String updateUrgency) {
		WebElement searchFrameInTable = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrameInTable);
		List<WebElement> problemTable = locateElements("xpath", "//table[@id='problem_table']/tbody//tr");
		int size = problemTable.size();
		for (int i = 1; i <= size; i++) {
			WebElement checkUrgency = locateElement("xpath", "//table[@id='problem_table']/tbody//tr["+i+"]/td[9]");
			verifyExactText(checkUrgency, updateUrgency);
			
		}
		defaultContent();
		return this;
	}
	public ProblemsPage verifyWorknote(String updateWorknote) {
		WebElement searchFrameInTable = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrameInTable);
		List<WebElement> problemTable = locateElements("xpath", "//table[@id='incident_table']/tbody//tr");
		int size = problemTable.size();
		for (int i = 1; i <= size; i++) {
			WebElement checkworknote = locateElement("xpath", "//table[@id='problem_table']/tbody//tr["+i+"]/td[12]");
			verifyExactText(checkworknote, updateWorknote);
			break;
		}
		defaultContent();
		return this;
	}
		
	public ProblemsPage problemNotIntable() {
		WebElement searchFrame = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(searchFrame);
		WebElement tableIncident = locateElement("xpath" ,"//table[@id='problem_table']/tbody//tr/td");
		verifyExactText(tableIncident,"No records to display");
		defaultContent();
		return this;	
		}
		
}
