package testNGpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.uatLoginPage;
import utilities.PropertiesManager;

public class SmokeTests
{
	
	static String baseurl=	PropertiesManager.callPropInstance().getUrl();
	static String browser=PropertiesManager.callPropInstance().getDriverName();
	static String browser_path=PropertiesManager.callPropInstance().getDriverPath();
	static String username=PropertiesManager.callPropInstance().getUatUser();
	static String password=PropertiesManager.callPropInstance().getUatPassword();
	WebDriver driver;
	static uatLoginPage onLoginPage;
	
	
		
	
	@Test(priority=-1, description="Setup the browser and get page title of base URL")
	public void setUpBrowser() {
		System.setProperty(browser,browser_path);
		driver = new ChromeDriver();
		onLoginPage= PageFactory.initElements(driver, uatLoginPage.class);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseurl);
		String page_title=driver.getTitle();
		Assert.assertEquals("GPComply", page_title);
		if(page_title=="GPComply") {
		System.out.println("The correct page has been loaded successfully");
		}
		else {
			System.out.println("Incorrect page has been loaded with title "+page_title);
		}
	}
		

	
	@Test (priority=1, description="Verify the page title after login", dependsOnMethods= {"loginOnUat"})
	public void verifyPageTitle() {

		onLoginPage.getLoginPageTitle();
		System.out.println("The value of driver is:"+ driver);
		
		
	}
		
		
	@Test (priority=0, description="This test will enter username,password and then click sign in")
	public void loginOnUat () {
		int a;
		
		try {
			onLoginPage.enterUserName(username);
			onLoginPage.enterPassword(password);
			onLoginPage.clickSignIn();
			a=1;
		} catch (Exception e) {
			System.out.println("Test Case didnot pass and Exception occured while execution: "+e);
			a=0;
		}
		if(a==1)
		System.out.println("User"+username+" has logged in successfully !!");
		
	}
	
		
		
		

	/*
	@Test (enabled=false)
	public void clickMenuPrintTitle() {	
		objHome.clickMobileMenuLink();
		String mobile_page_title=objHome.getpageTitle();
		System.out.println("The title of the page is "+mobile_page_title);
	}
	*/
	
	/*
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Closed the Browser",true);
	}*/

}
