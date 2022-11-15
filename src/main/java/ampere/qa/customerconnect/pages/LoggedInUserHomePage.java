package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.Constants;
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

    private By loginLink=By.xpath("(//span[@class='css-722v25'])[1]");	 
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
	private By UserNameField=By.xpath("//input[@type='text']");
	private By NextButton=By.xpath("//input[@class='button button-primary']");
	private By PasswordField=By.xpath("//input[@id='input59']");
	private By VerifyButton=By.xpath("//input[@value='Verify']");
	
	private By documentLinks=By.xpath("//div[@class='css-1mxhkmy']");
	private By docDates=By.xpath("//div[@class='css-x5oct']");
	
	
 public void Login() throws InterruptedException 
 {
	 eleUtil.doClick(loginLink);
	 try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 String value=prop.getProperty("username");
	 eleUtil.doSendKeys(UserNameField, value);
	 Thread.sleep(1000);
	 eleUtil.doClick(NextButton);
	 Thread.sleep(1000);
	 String pass=prop.getProperty("password");
	 eleUtil.doSendKeys(PasswordField, pass);
	 eleUtil.doClick(VerifyButton);
	 eleUtil.waitForTitleToBe(Constants.HOMEPAGE_TITLE, 5000);
	 
 }

 public void WelcomeMesaagePresent()
 {
	 
 }

 public void PageTileCheck()
 {
	 
 }
}
