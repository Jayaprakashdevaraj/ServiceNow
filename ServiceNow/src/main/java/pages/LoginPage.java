package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import testng.api.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	
	public WebElement frame;
	
	public LoginPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	 	
	
	@Given("Enter username as (.*)")
	public LoginPage enterUserName(String UserName) {	
		
		frame = locateElement("Xpath", "//iframe[@title='Main Content']");
		switchToFrame(frame);

		WebElement eleUsername = locateElement("xpath", "//input[@id='user_name']");
		clearAndType(eleUsername, UserName);
		defaultContent();

		return this;
	}	

	@Given("Enter password as (.*)")
	public LoginPage enterPassword(String PassWord) {
		switchToFrame(frame);
		WebElement elePassword = locateElement("xpath", "//input[@id='user_password']");
		clearAndType(elePassword, PassWord);
		defaultContent();
		return this;
	}	
	
	@When("Click on the Login")
	public HomePage clickLogin() {
		switchToFrame(frame);
		click(locateElement("id", "sysverb_login"));
		defaultContent();
		return new HomePage(driver, node, test);		
	}
	
}
