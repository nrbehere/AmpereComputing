package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class LoggedInUserHomePage {
	
	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	Boolean b;
	String title;
	Actions action;
	WebElement mainMenu;
	
	public LoggedInUserHomePage (WebDriver driver, Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);	
		action=new Actions(driver);
	}

    private By loginLink=By.xpath("(//span[@class='css-722v25'])[1]");	 
	private By heroImage= By.xpath("//img[@alt='Hero Image']");
	private By welcomeText= By.xpath("//p[@class='chakra-text css-bxak8j']");
	private By accessMsg= By.xpath("//div[@class='css-1a0i1ol']");
	private By techDocCard= By.xpath("//div[@class='css-1kcc3za'][1]");
	private By techDocViewAll=By.xpath("//button[@class='chakra-button css-dsbiu9'][1]");
	private By softDesCard=By.xpath("//div[@class='css-1kcc3za'][2]");
	private By softDesViewAll=By.xpath("(//button[@class='chakra-button css-dsbiu9'])[2]");
	private By techBullCard=By.xpath("//div[@class='css-1kcc3za'][3]");
	private By techBullViewAll=By.xpath("(//button[@class='chakra-button css-dsbiu9'])[3]");
	private By faqHelpCard= By.xpath("//div[@class='css-11094vn']");
	private By faqHelpReadMore=By.xpath("//div[@class='css-whl708']");
	private By loggedInWidget=By.xpath("//div[@class='css-t1b7l']");
	private By loggedInWidget2=By.xpath("//div[@class='css-1tbo71r']");
	private By UserNameField=By.xpath("//input[@type='text']");
	private By NextButton=By.xpath("//input[@class='button button-primary']");
	private By PasswordField=By.xpath("//input[@id='input59']");
	private By VerifyButton=By.xpath("//input[@value='Verify']");
	private By WidgetProfile=By.xpath("//div[@class='css-1tbo71r']//div");
	private By WidgetLogOut=By.xpath("//div[@class='css-1tbo71r']//button");
	private By documentLinks=By.xpath("//div[@class='css-1mxhkmy']");
	private By docDates=By.xpath("//div[@class='css-x5oct']");
	private By TDLoginLink = By.xpath("(//span[@class='css-722v25'])[1]");
	
	
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
	 Thread.sleep(3000);
	 String pass=prop.getProperty("password");
	 eleUtil.doSendKeys(PasswordField, pass);
	 eleUtil.doClick(VerifyButton);
	 eleUtil.waitForTitleToBe(Constants.HOMEPAGE_TITLE, 5000);
	 
 }

 // Test Case 4.2. Verify the Page Tile. Verify that "Welcome to Customer Connect" message is present. Verify that the hero image is present.

 public String WelcomeMesaagePresent()
 {
	 String welcometext=eleUtil.getElement(welcomeText).getText();
	 return welcometext;
 }

 public String PageTitleCheck()
 {
    String pagetitle=eleUtil.doGetTitle(Constants.HOMEPAGE_TITLE, 1000);
    return pagetitle;
 }
 
 
 public Boolean HeroImageIsPresent()
 {
	 
	 b=eleUtil.doIsDisplayed(heroImage);
     return b;
	 
 }

 //Test Case 4.3. Verify that the message related to Access to the Customer Connect is present below the Hero Image.

 public String AccessMessageIsPresent()
 {   String ActText=eleUtil.getElement(accessMsg).getText();
 	 return ActText;
 
 }

 
//Test Case 4.4 Verify the "Technical Document Updates" card is present with Recently Updated Technical Documents being displayed. Verify that there is a View All Button which navigates User to "Technical Documents Recently Updated" page

public Boolean TechDocCardPresent()
{
 b=eleUtil.getElement(techDocCard).isDisplayed(); 
 return b;
}

public String TechDocViewAllClick()
{
  eleUtil.doClick(techDocViewAll);
  title= eleUtil.doGetTitle(Constants.TECH_DOC_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
  driver.navigate().back();
  eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
	return title;
  

}

public TechnicalDocumentUpdatesPage TechDocViewAllClickPageSetUp()
{
	eleUtil.doClick(techDocViewAll);
	eleUtil.doGetTitle(Constants.TECH_DOC_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	return new TechnicalDocumentUpdatesPage(driver, prop);
	
}


//Test Case 4.5 Verify that the "Software and Design Files Updates" card is present with  recently Updated Software & Design Files being displayed. Verify that there is a 'View All' Button that navigates User to "Software Recently Updated" page

public Boolean SoftwareDesignFilesCardPresent()
{
 b=eleUtil.getElement(softDesCard).isDisplayed(); 
 return b;
}

public String SoftwareDesignFilesViewAllClick()
{
  eleUtil.doClick(softDesViewAll);
  title= eleUtil.doGetTitle(Constants.SW_DES_FILES_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
  driver.navigate().back();
  eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
	return title;
  
}

public SWUpdatesPage SWDesFilesViewAllClickPageSetUp()
{
	eleUtil.doClick(softDesViewAll);
	eleUtil.doGetTitle(Constants.SW_DES_FILES_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	return new SWUpdatesPage(driver, prop);
	
}

// Test Case 4.6  Verify that the "Technical Bulletin" card is present with recently updated Technical Bulletins being displayed. Verify that there is a 'View All' Button that navigates the User to "Technical Bulletins Recently Updated" page

public Boolean TechBulletinCardPresent()
{
 b=eleUtil.getElement(techBullCard).isDisplayed(); 
 return b;
}

public String TechBulletinViewAllClick()
{
  eleUtil.doClick(techBullViewAll);
  title= eleUtil.doGetTitle(Constants.TECH_BULLETIN_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
  driver.navigate().back();
  eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
  return title;
  
}


//Test Case 4.7 Verify that the "Read More" link is present for FAQ & Help page and clicking it User is navigated to Help page  

public Boolean HelpFAQCardPresent()
{
 b=eleUtil.getElement(faqHelpCard).isDisplayed(); 
 return b;
}

public String HelpReadMoreClick()
{
  eleUtil.doClick(faqHelpReadMore);
  title= eleUtil.doGetTitle(Constants.HELP_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
  driver.navigate().back();
  eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
  return title;
  
}

//Test Case 4.8 Verify a Logged In widget is present on the right side of home page with Profile & Logout Links

public Boolean LoggedInWidgetIsPresent() throws InterruptedException
{
	eleUtil.getElement(loggedInWidget).isDisplayed();
	Thread.sleep(2000);
	return b;

}

public String ProfileLinkClick() throws InterruptedException
{   
	mainMenu=eleUtil.getElement(loggedInWidget);
	action.moveToElement(mainMenu).build().perform();
	Thread.sleep(2000);
	
	eleUtil.getElement(WidgetProfile).click();
	
	 title= eleUtil.doGetTitle(Constants.PROFILE_PAGE_TITLE,Constants.DEFAULT_TIMEOUT); 
	 driver.navigate().back();
	 eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
	 Thread.sleep(2000);
	 return title;
	 
}

public Boolean LogoutLinkClick() throws InterruptedException
{  
	mainMenu=eleUtil.getElement(loggedInWidget2);
	Thread.sleep(2000);
	action.moveToElement(mainMenu).build().perform();
	Thread.sleep(2000);
	eleUtil.getElement(WidgetLogOut).click();
	eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT); 
	Thread.sleep(2000);
    b=eleUtil.getElement(TDLoginLink).isDisplayed();
    return b;
	
}


}
