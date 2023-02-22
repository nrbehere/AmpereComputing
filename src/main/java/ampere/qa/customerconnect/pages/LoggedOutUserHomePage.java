	package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class LoggedOutUserHomePage {

	
	// Test Case - Sr. No 2.1, 2.2, 2.4, 2.5
	// This is a action page for Homepage as reflected to logged out user

	private WebDriver driver;
	Boolean B;
	private Properties prop;
	private ElementUtil eleUtil;

	public LoggedOutUserHomePage(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop=prop;
		eleUtil=new ElementUtil(driver);
	}

	private By TechDocNotLoginMsg = By.xpath("((//div[@class='css-11094vn'][1])//div)[2]");
	private By SoftwareFilesLoginMsg = By.xpath("(((//div[@class='css-11094vn'])[2])//div)[2]");
	private By TDLoginLink = By.xpath("(//span[@class='css-722v25'])[1]");
	private By TDRegisterLink = By.xpath("(//span[@class='css-722v25'])[2]");
	private By SWFLoginLink = By.xpath("(//span[@class='css-722v25'])[3]");
	private By SWFRegisterLink = By.xpath("(//span[@class='css-722v25'])[4]");

	// Method to get homepage title 
	public String getHomePageTitle() {
		return eleUtil.doGetTitle(Constants.HOMEPAGE_TITLE, Constants.DEFAULT_TIMEOUT);
			
	} 

	// Method to verify the homepage url
	public boolean HomePageURL() {
		return eleUtil.waitForURLToContain(Constants.HOMEPAGE_URL_FRACTION, Constants.DEFAULT_TIMEOUT);
	}

	// Method to verify that there is a message "You are not logged in" for Technical documents
	public String TDLoginMsg() {

		return driver.findElement(TechDocNotLoginMsg).getText();
	}

	// Method to verify that there is a message "You are not logged in" for Software & Design Files
	public String SWFLoginMsg() {

		return driver.findElement(SoftwareFilesLoginMsg).getText();
	}

	// Method to verify that there Login Link for Technical documents
	public Boolean TDLoginLinkexists() {
		return eleUtil.doIsDisplayed(TDLoginLink);
				

	}

	// Method to verify that there Register Link for Technical documents
	public Boolean TDRegisterLinkexists() {
		return eleUtil.doIsDisplayed(TDRegisterLink);

	}

	// Method to verify that there Login Link for Software & Design Files
	public Boolean SWFLoginLinkExists() {
		return eleUtil.doIsDisplayed(SWFLoginLink);
	}

	// Method to verify that there Register Link for Software & Design Files
	public Boolean SWFRegisterLinkExists() {
		return eleUtil.doIsDisplayed(SWFRegisterLink);
	}
	
	
	//Method verify that login link  for Technical Document is clickable
	public String TDRegisterClick()
	{   String title;
		eleUtil.doClick(TDRegisterLink);
		title= eleUtil.doGetTitle(Constants.REGISTRATION_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		driver.navigate().back();
		eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
		return title;
		
	}

	public String TDloginClick()
	{   String title;
		eleUtil.doClick(TDLoginLink);
		title= eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		driver.get(prop.getProperty("url"));
		eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
		
		return title;
		
	}
	
  public String SWRegisterClick()
  {
	  String title;
		eleUtil.doClick(SWFRegisterLink);
		title= eleUtil.doGetTitle(Constants.REGISTRATION_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		driver.navigate().back();
		eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
		
		return title;
  }

  
  public String SWloginClick()
	{   String title;
		eleUtil.doClick(SWFLoginLink);
		title= eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		driver.get(prop.getProperty("url"));
		eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
		
		return title;
		
	}
  
  public RegistrationPage gotoRegistrationPage()
  {
	  eleUtil.doClick(TDRegisterLink);
	  return new RegistrationPage();
	  
  } 

// Test Case - Sr No 2.5 - Verify that when logged out user accesses Technical Bulletins / Documents Page, user is navigated to the login page. 
  
  public String VisitingTechDocPage()
  {
	  driver.get(prop.getProperty("techdocurl"));
	  String title= eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	  driver.get(prop.getProperty("url"));
	  return title;
	  
  }

}
