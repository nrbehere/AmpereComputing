package ampere.qa.customerconnect.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class FAQandHelpPage {

	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	private Boolean b;
	
	
	public FAQandHelpPage(WebDriver driver, Properties prop) {
	  this.driver=driver;
	  this.prop=prop;
	  eleUtil= new ElementUtil(driver);
	
	}
	
	
	private By HeroImage= By.xpath("//img[@alt='Hero Image']");
	private By TextOnImage=By.xpath("//p[@class='chakra-text css-bxak8j']");
	private By FAQAccordianList=By.xpath("//button[@class='chakra-accordion__button css-uttm9k']");
	private By WholeFAQAccordian=By.xpath("//div[@class='chakra-accordion css-0']");
	private By firstAccordian=By.xpath("//button[@id='accordion-button-:r28:']");
	private By HelpPageTextBelowHeroImage=By.xpath("//div[@class='css-9ngvyq']");
	private By HelpSubmmissonForm=By.xpath("//form[@action='#']");
	private By SubmitButton=By.xpath("//button[@class='chakra-button css-t2bxwr']");
	private By FAQSection=By.xpath("//div[@class='css-hihay']");
	
	
	public boolean HeroImageIsPresent()
	{
		return eleUtil.getElement(HeroImage).isDisplayed();
		
	}

	public String getTextOnImage()
	{
		String text;
		text=eleUtil.doGetText(TextOnImage);
		return text;
	}

	
	public String getPageTitle()
	{
		return eleUtil.doGetTitle(Constants.HELP_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	}

	public Boolean TextBelowHeroImage()
	{
		return eleUtil.getElement(HelpPageTextBelowHeroImage).isDisplayed();
				
	}
	
	
	public Boolean HelpFormIsPresent()
	{
		 return eleUtil.getElement(HelpSubmmissonForm).isDisplayed();
	}
	
	
	
	public boolean FAQSectionPresent()
	{
		eleUtil.doMoveToElement(FAQSection);
		return eleUtil.getElement(FAQSection).isDisplayed();
	}
	
	
	public boolean FAQExpandCollapse() throws InterruptedException
	{
		
		eleUtil.windowMaximise();
		
		
		
		eleUtil.doMoveToElement(WholeFAQAccordian);
		Thread.sleep(2000);
		String info;
		
		List <WebElement> ele= eleUtil.getElements(FAQAccordianList);
		int i=ele.size();
		
		for (int j=0;j<i;j++) {
			ele.get(j).click();
			Thread.sleep(1000);
			info=ele.get(j).getAttribute("aria-expanded");
			if (info.equalsIgnoreCase("true")) {
				b=true;
										
			} else {
				
				b=false;
				break;
			}	
			
		}
		
		
		return b;
		
	}
	

}
