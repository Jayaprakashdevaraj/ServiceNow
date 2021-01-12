package pages;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import testng.api.base.ProjectSpecificMethods;

public class MobilePage extends ProjectSpecificMethods {

	public WebElement frameInMobilePage;

	public MobilePage(RemoteWebDriver driver, ExtentTest node, ExtentTest test) {
		this.driver = driver;
		this.node = node;
		this.test = test;
	}

	public Iphone6spage clickMobileModel(String MobileModel) {
		frameInMobilePage = locateElement("xpath", "//iframe[@id='gsft_main']");
		switchToFrame(frameInMobilePage);

		click(locateElement("xpath", "//strong[text()='"+MobileModel+"']"));
		defaultContent();
		return new Iphone6spage(driver, node, test);
		}
	}
	
