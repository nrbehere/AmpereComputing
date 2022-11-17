package ampere.qa.customerconnect.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ampere.qa.customerconnect.utils.ElementUtil;

public class LoggedOutUserNavigation {
	
	// Test Case 2.3 Verify that for a logged-out user only the following links are visible on the Support Navigation Bar - Support Home, Products, Help
	// Test Case 2.4 Verify  that when logged out user can accesses Product Page and Help Page 

	private WebDriver driver;
	private ElementUtil eleUtil;
	Actions action;
	WebElement mainMenu;

	// By locators for Support, Customer Homepage, product, Help
	By SupportNavBar= By.xpath("(//div[@class='css-rjt1dr'])[3]");
	By SupportNavBarLinks=By.xpath("//div[@class='css-1xasjpp']//a");
	By SupportLink= By.xpath("(//div[@class='css-rjt1dr']) [3]");
	By SupportHomeLink=By.xpath("//a[@class='c']");
	By ProductLink= By.xpath("((//div[@class='css-1u1hse0']) //a)[2]");
	By HelpLink=By.xpath("(//div[@class='css-jxbglg'])[5]//a[3]");
	

	public LoggedOutUserNavigation(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		action= new Actions(driver);
		
	}

	
	public boolean SupportIsPresent() {
      return eleUtil.doIsDisplayed(SupportNavBar);
	}

	public void SupportLinkClick()
	{
		eleUtil.doActionClick(SupportNavBar);
		
	}
	
	public List<String> SupportNavBarLinksArePresent() throws InterruptedException {
	
	   
		eleUtil.doMoveToElement(SupportNavBar);
		Thread.sleep(5000);
		
		
		List<WebElement> ele= eleUtil.getElements(SupportNavBarLinks);
		List<String> stringList= new ArrayList<String>();
		
		
		System.out.println(ele.size());
		
		for (int i=0; i<ele.size();i++) {
	      
			String text=ele.get(i).getText();
			stringList.add(text);
			}
		 return stringList;

	} 

	public LoggedOutUserProductPage ProductClick() {
		
		SupportLinkClick();
		eleUtil.doClick(ProductLink);
		return new LoggedOutUserProductPage(driver);

	}

    public LoggedOutUserHelpPage HelpLinkClick() throws InterruptedException {
		
    	 eleUtil.doMoveToElement(SupportLink);
		 Thread.sleep(1000);
		 eleUtil.doActionClick(HelpLink);
		 return new LoggedOutUserHelpPage(driver);

	}

}
