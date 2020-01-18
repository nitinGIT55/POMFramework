package testNGpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.guru99HomePage;

public class SmokeTests {
	
	WebDriver driver;
	guru99HomePage objHome;
	
	
	@BeforeMethod
	public void setUpBrowser() {
		String chrome="webdriver.chrome.driver";
		String chrome_path="D:\\SeleniumJars\\chromedriver_win32\\chromedriver.exe";
		System.setProperty(chrome,chrome_path);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://live.demoguru99.com/");
	}
	
	@Test
	public void printPageTitle() {
		String page_title=objHome.getpageTitle();
		System.out.println("The title of the page is "+page_title);
		Assert.assertEquals(page_title, "THIS IS DEMO SITE");
		Reporter.log("printPageTitle Executed",true);
		
		
		
	}
	
	@Test 
	public void clickMenuPrintTitle() {
		objHome.clickMobileMenuLink();
		String mobile_page_title=objHome.getpageTitle();
		System.out.println("The title of the page is "+mobile_page_title);
	}

}
