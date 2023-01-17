package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class TechnicalBulletinPage {

	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	boolean b;
	
	public TechnicalBulletinPage(WebDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);
	}

	private By HeroImage= By.xpath("//img[@alt='Hero Image']");
	private By TextOnImage=By.xpath("//p[@class='chakra-text css-bxak8j']");
	private By WMNote=By.xpath("//div[@class='css-sn9nxz']");
	private By TechBulletinList=By.xpath("//span[@class='css-4g6ai3']");
	
	public boolean HeroImageIsPresent()
	{
		eleUtil.windowMaximise();
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
		return eleUtil.doGetTitle(Constants.TECH_BULLETIN_TITLE, Constants.DEFAULT_TIMEOUT);
	}

	
	public boolean isWaterMarkNotePresent()
	{
		return  eleUtil.getElement(WMNote).isDisplayed();
	}
	
}
