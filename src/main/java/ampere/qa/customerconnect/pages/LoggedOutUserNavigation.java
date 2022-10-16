package ampere.qa.customerconnect.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ampere.qa.customerconnect.utils.ElementUtil;

public class LoggedOutUserNavigation {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// By locators for Support, Customer Homepage, product, Help
	By SupportNavBar= By.xpath("(//div[@class='css-rjt1dr'])[3]");
	By SupportNavBarLinks=By.cssSelector("div.css-1u1hse0 a");
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
		eleUtil.doClick(SupportNavBar);
	}
	
	public List<String> SupportNavBarLinksArePresent() {
		SupportLinkClick();
	
		List<WebElement> ele= eleUtil.getElements(SupportNavBarLinks);
		List<String> stringList= new ArrayList<String>();
		
		for (WebElement e: ele) {
			String text=e.getText();
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
