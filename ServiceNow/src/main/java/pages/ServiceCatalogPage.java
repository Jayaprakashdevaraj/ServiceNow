package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class ServiceCatalogPage extends ProjectSpecificMethods {

	public WebElement frameInServiceCatalogPage;

	public ServiceCatalogPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}
	
	public MobilePage clickMobile() {
		frameInServiceCatalogPage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInServiceCatalogPage);
		click(locateElement("link", "Mobiles"));
		
		defaultContent();
		return new MobilePage(driver, node, test);
	}

}
