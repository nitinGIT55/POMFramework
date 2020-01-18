package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guru99HomePage {
	
	@FindBy(className="level0") public WebElement mobile_link;
	private WebDriver homedriver;
	
	
	/* Calling constructor to initialize the page elements*/
	public guru99HomePage (WebDriver homedriver) {
		this.homedriver=homedriver;
		PageFactory.initElements(homedriver,this);
	}
	
	public String getpageTitle () {
		String page_title_home=homedriver.getTitle();
		return page_title_home;
	}
	
	public void clickMobileMenuLink() {
		mobile_link.click();
	}

}
