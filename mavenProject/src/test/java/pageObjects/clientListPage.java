package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class clientListPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//img[@alt='homepage']") public WebElement clientListLogo;
	@FindBy(xpath="//a[@title='Settings']") public WebElement settingsButton;
	@FindBy(id="inputtxt") public WebElement searchBox;
	@FindBy(xpath="//button[@title='Search']") public WebElement searchGlassIcon;
	@FindBy(xpath="//button[@title='Reset']") public WebElement resetButton;
	@FindBy(xpath="//button[starts.with (@title,'Create')]") public WebElement createClientButton;

	public clientListPage(WebDriver driver2) {
		this.driver=driver2;
	}
	
	public void checkLogoOnClientList() {
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", clientListLogo);
        if (!ImagePresent)
        {
             System.out.println("Logo on Client List is NOT displayed.");
        }
        else
        {
            System.out.println("Logo on Client List is displayed.");
        }
	}
	
	public void verifySettingsMenuItems() {
		try {
		settingsButton.click();
		System.out.println("Clicked on the Settings menu ");
		}
		catch(Exception e)
		{
			System.out.println("Couldnot locate the Settings menu button due to this exception--> "+e);
		}
		
		
	}

	
	
}
