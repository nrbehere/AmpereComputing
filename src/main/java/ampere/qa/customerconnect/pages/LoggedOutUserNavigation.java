package ampere.qa.customerconnect.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ampere.qa.customerconnect.utils.ElementUtil;

public class LoggedOutUserNavigation {
	
	// Test Case - Sr. No. 1

	private WebDriver driver;
	private ElementUtil eleUtil;

	// By locators for Support, Customer Homepage, product, Help
	By SupportNavBar= By.xpath("(//div[@class='css-rjt1dr'])[3]");
	By SupportNavBarLinks=By.xpath("//div[@class='css-1xasjpp']//a");
	By SupportHomeLink=By.xpath("//a[@class='c']");
	By ProductLink= By.xpath("((//div[@class='css-1u1hse0']) //a)[2]");
	By HelpLink=By.xpath("((//div[@class='css-1u1hse0']) //a)[3]");
	

	public LoggedOutUserNavigation(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	/*
	 * Actions 1. Check whether Support is present in navigation bar 2. Check
	 * whether 3 Links are shown for logged out user
	 */

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

    public LoggedOutUserHelpPage HelpLinkClick() {
		
		SupportLinkClick();
		eleUtil.doClick(HelpLink);
		return new LoggedOutUserHelpPage(driver);

	}

}
