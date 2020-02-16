package testNGpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.clientListPage;
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
	static clientListPage onClientListPage;
	
	
		
	
	@BeforeSuite
	public void setUpBrowser() {
		System.setProperty(browser,browser_path);
		driver = new ChromeDriver();
		onLoginPage= PageFactory.initElements(driver, uatLoginPage.class);
		onClientListPage= PageFactory.initElements(driver, clientListPage.class);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseurl);
		String page_title=driver.getTitle();
		Assert.assertEquals(page_title,"GPComplyLogin");
		if( page_title.contains("GPComply")) {
		System.out.println("The correct page has been loaded successfully");
		}
		else {
			System.out.println("Incorrect page has been loaded with title "+page_title);
		}
	}
		

	
	@Test (description="Verify the page title after login", dependsOnMethods= {"loginOnUat"})
	public void verifyPageTitle() {

		onLoginPage.getLoginPageTitle();
				
	}
		
		
	@Test (priority=0, description="This test will enter username,password and then click sign in")
	public void loginOnUat () {
		boolean a;
		
		try {
			onLoginPage.enterUserName(username);
			onLoginPage.enterPassword(password);
			onLoginPage.clickSignIn();
			a=true;
		} catch (Exception e) {
			System.out.println("Test Case didnot pass and Exception occured while execution: "+e);
			a=false;
		}
		if(a==true)
		System.out.println("User "+username+" has logged in successfully !!");
		Assert.assertEquals(a, true);
		
		
	}
	
	@Test (priority=2, description="Verify the logo on client list page", dependsOnMethods= {"loginOnUat"})
	public void logoOnClientList() {
		System.out.println("The title of client list page is :"+driver.getTitle());
		onClientListPage.checkLogoOnClientList();
		
	}
	
	@Test (priority=3, description="Verify the Settings Menu Items", dependsOnMethods= {"loginOnUat"})
	public void settingsMenuList() {
		onClientListPage.verifySettingsMenuItems();
		
	}
	
	@Test (priority=4)
	public void searchingClient() {
		System.out.println("Started doing the search on Client list");
		onClientListPage.searchBox.sendKeys("shubh");
		onClientListPage.searchGlassIcon.click();
		onClientListPage.resetButton.click();
	}
	
	/*
	
	@DataProvider (name="searchtexts")
	public String[] createData() {
		return new String[] {"vishal","tushar","shubh"};
				
				
		}*/
	
	
		
		
		
	
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Closed the Browser",true);
	}
	
	}


