package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class NavBarToHomePage {
	
	// Test Case - Sr. No. 2.3
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	public Properties prop;
	Actions action;
	WebElement mainMenu;
		

	By SupportLink= By.xpath("(//div[@class='css-rjt1dr']) [3]");
	By SupportHomeLink= By.xpath("(//div[@class='css-1xasjpp']) //a[@class='chakra-link css-nls56r']");
	
	
	public NavBarToHomePage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
		action= new Actions(driver);
		
	}
  
	// Visitng Solutions Homepage
	 public String visitSolutionsHomepage()
	 {
		 driver.get(Constants.SOLUTIONS_HOMEPAGE_URL);
		 String title= eleUtil.doGetTitle(Constants.SOLUTIONS_HOMEPAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		 return title;
	 }
			
	 
	 //Navigating to Solutions Homepage via Nav Bar
	 public String clickSupportHome() throws InterruptedException
	 {
		 eleUtil.doMoveToElement(SupportLink);
		 Thread.sleep(1000);
		 eleUtil.doActionClick(SupportHomeLink);
		 
		 String title= eleUtil.doGetTitle(Constants.HOMEPAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		 return title;
		  
	 }
	 
	 
	 
	 


}
