package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.ElementUtil;

public class LoggedInUserHomePage {
	
	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	
	public LoggedInUserHomePage (WebDriver driver, Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);		
	}

	
	private By heroImage= By.xpath("//img[@alt='Hero Image']");
	private By welcomeText= By.xpath("//p[@class='chakra-text css-bxak8j']");
	private By accessMsg= By.xpath("//div[@class='css-1a0i1ol']");
	private By techDocCard= By.xpath("//div[@class='css-1kcc3za'][1]");
	private By techDocViewAll=By.xpath("//button[@class='chakra-button css-1ww01b9'][1]");
	private By softDesCard=By.xpath("//div[@class='css-1kcc3za'][2]");
	private By softDesViewAll=By.xpath("//button[@class='chakra-button css-1ww01b9'][2]");
	private By techBullCard=By.xpath("//div[@class='css-1kcc3za'][3]");
	private By techBullViewAll=By.xpath("//button[@class='chakra-button css-1ww01b9'][3]");
	private By faqHelpCard= By.xpath("//div[@class='css-11094vn']");
	private By faqHelpReadMore=By.xpath("//div[@class='css-whl708']");
	private By loggedInWidget=By.xpath("//div[@class='css-t1b7l']");
	
	private By documentLinks=By.xpath("//div[@class='css-1mxhkmy']");
	private By docDates=By.xpath("//div[@class='css-x5oct']");
	
	



}
