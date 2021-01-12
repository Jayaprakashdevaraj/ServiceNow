package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class Iphone6spage extends ProjectSpecificMethods {

	public WebElement frameIniPhonePage;

	public Iphone6spage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public Iphone6spage selectColor(String color) {
		frameIniPhonePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameIniPhonePage);
		WebElement chooseColor = locateElement("xpath", "//select[@class='form-control cat_item_option ']");
		selectDropDownUsingText(chooseColor, color);
		defaultContent();
		return this;	
	}
	
	public Iphone6spage selectStroage(String stroage) {
		frameIniPhonePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameIniPhonePage);
		WebElement chooseStroage = locateElement("xpath", "(//select[@class='form-control cat_item_option '])[2]");
		selectDropDownUsingText(chooseStroage, stroage);
		defaultContent();
		return this;	
	}
	
	public OrderStatusPage clickOrder() {
		frameIniPhonePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameIniPhonePage);
		click(locateElement("xpath", "//button[@id='oi_order_now_button']"));
		defaultContent();
		return new OrderStatusPage(driver, node, test);	
	}
	
	
	
	
}

