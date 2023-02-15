package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class NavBarToHomePage {
	
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
  
	// Test Case 1- Verify that the user can navigate to the Customer Connect Home page via Navigation Bar on Solutions Homepage / Ampere website
	 public void visitSolutionsHomepage()
	 {
		 driver.get(Constants.AMPERE_HOMEPAGE_URL);
		 
	 }
			
	 	 public String clickSupportHome() throws InterruptedException
	 {
		 visitSolutionsHomepage();	 
		 eleUtil.doMoveToElement(SupportLink);
		 Thread.sleep(1000);
		 eleUtil.doActionClick(SupportHomeLink);
		 Thread.sleep(2000);
		 
		 String title= eleUtil.doGetTitle(Constants.HOMEPAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		 return title;
		  
	 }
}
