package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class uatLoginPage {
	
	public WebDriver driver;
	
	
	
	//Creating WebElements present on the uat login page
	
	@FindBy(id="logonIdentifier") public WebElement username;
	@FindBy(id="password") public WebElement password;
	@FindBy(id="next") public WebElement signIn;
	@FindBy(id="forgotPassword") public WebElement forgotPassword;
	
	public uatLoginPage(WebDriver ldriver) {
		this.driver=ldriver;
			}
	
	public  void getLoginPageTitle() {
		    String loginPageTitle=driver.getTitle();
			System.out.println("The Title of the page is "+loginPageTitle) ;
				
	}
	
	public WebDriver enterUserName(String usrnm) {
		username.sendKeys(usrnm);
		return driver;
	}
	
	public WebDriver enterPassword(String pwd) {
		password.sendKeys(pwd);
		return driver;
	}
	
	public WebDriver clickSignIn() {
		signIn.click();
		return driver;
	}

}
