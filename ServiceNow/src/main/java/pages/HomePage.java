package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import testng.api.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{

	public HomePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	

	public HomePage enteroptionInSearch(String SearchReqvalue) throws InterruptedException {
		Thread.sleep(2000);
		WebElement searchLHS = locateElement("xpath", "//input[@type='search' and @name='filter']");
		clearAndType(searchLHS, SearchReqvalue);
		
		Thread.sleep(2000);
		return this;
	}

	public IncidentsPage selectIncidents() {
		click(locateElement("xpath", "//div[text()='Incidents']"));
		return new IncidentsPage(driver, node, test);
		
	}
	public ServiceCatalogPage ClickServiceCatelog() {
		click(locateElement("xpath", "//div[text()='Service Catalog']"));
		return new ServiceCatalogPage(driver, node, test);
	}
	
	public ServiceCatalogRequestPage ClickServiceCatelogRequest() {
		click(locateElement("xpath", "//span[text()='Service Catalog']/following::div[text()='Requests']"));
		return new ServiceCatalogRequestPage(driver, node, test);
	}
	
	
	
	
	public ChangeRequestpage clickChange() {
		click(locateElement("xpath", "//span[text()='Change']/following::div[text()='Open']"));
		return new ChangeRequestpage(driver, node, test);
		
	}

	public ProblemsPage clickProblem() {
		click(locateElement("xpath", "//span[text()='Problem']/following::div[text()='Open']"));
		return new ProblemsPage(driver, node, test);
		
	}
	
	public StdChangeProposalsPage ClickMyProposal() {
		click(locateElement("xpath", "//span[text()='Standard Change']/following::div[text()='My Proposals']"));
		return new StdChangeProposalsPage(driver, node, test);
	}
	

}
