package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev68594.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@title='Main Content']"));
		driver.findElementByXPath("//input[@id='user_name']").sendKeys("admin");
		driver.findElementByXPath("//input[@id='user_password']").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@type='search' and @name='filter']").sendKeys("Incidents");
		driver.findElementByXPath("//div[text()='Incidents']").click();
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='gsft_main']"));
		Thread.sleep(3000);
		WebElement search = driver.findElementByXPath("//input[@placeholder='Search' and @class ='form-control']");
		search.sendKeys("INC0010213");
		search.sendKeys(Keys.ENTER);
		WebElement incidentTable = driver.findElementByXPath("//table[@id='incident_table']/tbody//tr");
		
		
			WebElement checkUrgency = driver.findElementByXPath("//table[@id='incident_table']/tbody//tr[1]/td[10]");
			System.out.println(checkUrgency.getText());
			if(checkUrgency.getText().equals("3 - Low")) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
		}
		
		
	}

