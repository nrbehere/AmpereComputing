package ampere.qa.customerconnect.pages;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;
import io.qameta.allure.Step;

public class LoggedInUserHomePage {
	
	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	private List<WebElement> ele;
	private Boolean b;
	private String title;
	private int i;
	private Actions action;
	private WebElement mainMenu;
	
	public LoggedInUserHomePage (WebDriver driver, Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);	
		action=new Actions(driver);
	}

    private By loginLink=By.xpath("(//span[@class='css-722v25'])[1]");	 
	private By heroImage= By.xpath("(//img)[3]");
	private By welcomeText= By.xpath("(//p[@class='chakra-text css-bxak8j'])[1]");
	private By accessMsg= By.xpath("//div[@class='css-1a0i1ol']");
	private By ProductCard=By.xpath("(//div[@class='css-klktgf'])[1]");
	private By SearchBar=By.xpath("//input[@class='chakra-input css-ix76ss']");
	private By ProductFamily=By.xpath("//div[@class='css-1urlnhj']");
	private By ProductCategory=By.xpath("//div[@class='chakra-accordion__item css-ka586j']");
	private By Products=By.xpath("//div[@class='css-1lbcusb']//a");
	private By techDocCard= By.xpath("//div[@class='css-1kcc3za'][2]");
	private By techDocViewAll=By.xpath("(//div[@class='css-18qkft1']//a)[1]");
	private By softDesCard=By.xpath("(//div[@class='css-18qkft1']//a)[2]");
	private By softDesViewAll=By.xpath("(//a[@class='chakra-link chakra-button css-1hkhk0c'])[2]");
	private By techBullCard=By.xpath("(//div[@class='css-1kcc3za'])[3]");
	private By techBullViewAll=By.xpath("//div[@class='css-ldihrc']");
	private By faqHelpCard= By.xpath("(//div[@class='css-1kcc3za'])[4]");
	private By faqHelpReadMore=By.xpath("//div[@class='css-1kjc77f']//a[1]");
	private By faqHelpRMALink=By.xpath("//div[@class='css-1kjc77f']//a[2]");
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
	private By FnLnLocator=By.xpath("//span[@class='css-puvmh4']");
	private By SupportNavBar=By.xpath("(//div[@class='css-rjt1dr'])[3]");
	private By NavBarTechBulletinLink=By.xpath("(//a[@class='chakra-link css-6k6rnv'])[10]");
	private By NavBarProductLink= By.xpath("(//a[@class='chakra-link css-6k6rnv'])[7]");
	private By LastElementOfBreadCrumb=By.xpath("(//li[@class='chakra-breadcrumb__list-item css-1av8uke'])[4]");
	private By AcceptAllCookiesButton=By.xpath("//button[@class='chakra-button css-n9n0wy']");
	
 public void Login() throws InterruptedException 
 {
	 eleUtil.doClick(loginLink);
	 Thread.sleep(2000);
	 driver.manage().window().fullscreen();
	 Thread.sleep(2000);
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

 
 @Step ("Step to check whether Welcome text is present")
 public String WelcomeMesaagePresent()
 {
	 eleUtil.windowMaximise();
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
	 eleUtil.windowMaximise(); 
	 b=eleUtil.doIsDisplayed(heroImage);
     return b;
	 
 }

 //Test Case 4.3. Verify that the message related to Access to the Customer Connect is present below the Hero Image.

 public String AccessMessageIsPresent()
 {   String ActText=eleUtil.getElement(accessMsg).getText();
 	 return ActText;
 
 }

 
	/*
	 * Test Case 4.4 Verify that Products card is present. Verify that Product Family, Product
	 * Category and product is present in the Product Card. Verify that when user
	 * clicks a particular product, user is navigated to that product's page.
	 */
 
 public Boolean ProductCardPresent()
{
 eleUtil.windowMaximise();
 return eleUtil.getElement(ProductCard).isDisplayed();
}
 
 
 public Boolean ProductFamilPyresent()
 {
	 eleUtil.windowMaximise();
	 ele= eleUtil.getElements(ProductFamily);
	 i=ele.size();
	 System.out.println("Number of Product Faimly in Product Card:  "+i);
	 if (i>0) {
		return true;
	} else {
        return false;
	}
	
	 
 }
 
 
 public Boolean ProductCategoryPresent()
 {
	 eleUtil.windowMaximise();
	 eleUtil.doMoveToElement(ProductCategory);
	 ele=eleUtil.getElements(ProductCategory);
	 i=ele.size();
	 System.out.println("Number of Product Category in Product Card:  "+i);
	 if (i>0) {
		return true;
	} else {
        return false;
	}
 }
 
 
 public void ExpandProductCategory() throws InterruptedException
 {
	 eleUtil.windowMaximise();
	 //eleUtil.doMoveToElement(ProductCategory);
	 ele=eleUtil.getElements(ProductCategory);
	 for (int i = 0; i <ele.size(); i++) {
		 ele.get(i).click();
		 Thread.sleep(1000);
	    		
	}
 }

 public boolean ProductsArePresent() throws InterruptedException
 {
	Thread.sleep(5000);
	ele=eleUtil.getElements(Products); 
	i=ele.size();
	 System.out.println("Number of Product in Product Card:  "+i);
	 if (i>0) {
		return true;
	} else {
        return false;
	}
	 	 
 }
 
 public Boolean ProductClick() throws InterruptedException
 {
	 eleUtil.windowMaximise();
	 
	 ele=eleUtil.getElements(Products);
	 i=ele.size();
	 
	 Random r=new Random();
	 
	 int randomFile=r.nextInt(i);
	 
	 System.out.println("Random File Number-" +randomFile);
	 
	 String ExpectedFileName= ele.get(randomFile).getText();
	 System.out.println("Product clicked: "+ ExpectedFileName);
	 
	 randomFile=randomFile+1;
	 By RandomProduct= By.xpath("(//div[@class='css-1lbcusb']//a)["+randomFile+"]");
	 eleUtil.doMoveToElement(RandomProduct);
	 Thread.sleep(2000);
	 eleUtil.getElement(RandomProduct).click();
	 Thread.sleep(2000);
	 eleUtil.windowMaximise();
	 String ActualFileName=eleUtil.getElement(LastElementOfBreadCrumb).getText();
	 System.out.println("Product Page opened: "+ ActualFileName);
	 Thread.sleep(3000);
	 if (ExpectedFileName.equalsIgnoreCase(ActualFileName)) {
		driver.navigate().back(); 
		Thread.sleep(3000);
		return true;
	} else {
		driver.navigate().back();
		Thread.sleep(3000);
        return false;
	}
	 
 }
 
 public Boolean SearchBarIsPresent()
 {
	
	 eleUtil.windowMaximise();
	 return eleUtil.getElement(SearchBar).isDisplayed();
 }
 
 
 
 public ProductsPage ProductPageSetup() throws InterruptedException
 {
	 
	 eleUtil.doActionMoveToElementClick(SupportNavBar);
	 eleUtil.doActionMoveToElementClick(NavBarProductLink);
	
	 Thread.sleep(3000);
	 eleUtil.windowMaximise();
	 return new ProductsPage(driver,prop);
 
 }
 
 
/*
 * Test Case 4.5 Verify that search bar is present in Products card. Verify that
 * when user searches for a particular product, user is navigated to the Search
 * page with appropriate search results being displayed
 */
 
 
 public Boolean SearchBarPresent()
 {
	 return eleUtil.getElement(SearchBar).isDisplayed();
 }

 
 public Boolean TechDocCardIsPresent()
 {   
	 eleUtil.doMoveToElement(techDocCard);
	 return eleUtil.getElement(techDocCard).isDisplayed();
 }
 
public String TechDocViewAllClick()
{
  eleUtil.windowMaximise();	
  eleUtil.doMoveToElement(techDocCard);
  eleUtil.getElement(techDocViewAll).click();
  title= eleUtil.doGetTitle(Constants.TECH_DOC_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
  driver.navigate().back();
  eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
  return title;
  

}

public TechnicalDocumentUpdatesPage TechDocViewAllClickPageSetUp()
{
	eleUtil.windowMaximise();
	eleUtil.doClick(techDocViewAll);
	eleUtil.doGetTitle(Constants.TECH_DOC_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	return new TechnicalDocumentUpdatesPage(driver, prop);
	
}


//Test Case 4.5 Verify that the "Software and Design Files Updates" card is present with  recently Updated Software & Design Files being displayed. Verify that there is a 'View All' Button that navigates User to "Software Recently Updated" page



public String SoftwareDesignFilesViewAllClick() throws InterruptedException
{ 
  eleUtil.windowMaximise();	
  eleUtil.doMoveToElement(techDocCard);
  Thread.sleep(5000);
  CookiesAcceptAllClick();
  eleUtil.doActionMoveToElementClick(softDesViewAll);
  title= eleUtil.doGetTitle(Constants.SW_DES_FILES_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
  driver.navigate().back();
  eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
  return title;
  
}

public void CookiesAcceptAllClick()
{
   b=eleUtil.getElement(AcceptAllCookiesButton).isDisplayed();	
   
   if (b) {
	   eleUtil.getElement(AcceptAllCookiesButton).click();
	
   }
   
}

public SWUpdatesPage SWDesFilesViewAllClickPageSetUp()
{   eleUtil.windowMaximise();
    CookiesAcceptAllClick(); 
	eleUtil.doClick(softDesViewAll);
	eleUtil.doGetTitle(Constants.SW_DES_FILES_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	return new SWUpdatesPage(driver, prop);
	
}

// Test Case 4.6  Verify that the "Technical Bulletin" card is present with recently updated Technical Bulletins being displayed. Verify that there is a 'View All' Button that navigates the User to "Technical Bulletins Recently Updated" page

public Boolean TechBulletinCardPresent()
{
 eleUtil.windowMaximise();	
 eleUtil.doMoveToElement(techBullCard);	
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

public TechnicalBulletinUpdatesPage TechBulletinViewAllClickPageSetup()
{
  eleUtil.doClick(techBullViewAll);
  eleUtil.windowMaximise();
  eleUtil.doGetTitle(Constants.TECH_BULLETIN_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
  return new TechnicalBulletinUpdatesPage(driver,prop);
  
}

//Test Case 4.7 Verify that the "Read More" link is present for FAQ & Help page and clicking it User is navigated to Help page  

public Boolean HelpFAQCardPresent()
{
 eleUtil.windowMaximise();	
 eleUtil.doMoveToElement(faqHelpCard);	
 b=eleUtil.getElement(faqHelpCard).isDisplayed(); 
 return b;
}

public Boolean RMALinkPresent()
{
	
	eleUtil.windowMaximise();
	eleUtil.doMoveToElement(faqHelpCard);
	 return eleUtil.getElement(faqHelpRMALink).isDisplayed();
	
}

public String HelpReadMoreClick() throws InterruptedException
{
  eleUtil.doClick(faqHelpReadMore);
  title= eleUtil.doGetTitle(Constants.HELP_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
  driver.navigate().back();
  eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT);
  Thread.sleep(3000);
  return title;
  
}

public FAQandHelpPage HelpPageSetup()
{
	eleUtil.doClick(faqHelpReadMore);
	eleUtil.windowMaximise();
	title= eleUtil.doGetTitle(Constants.HELP_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
  	return new FAQandHelpPage(driver,prop);

}


//Test Case 4.8 Verify a Logged In widget is present on the right side of home page with Profile & Logout Links

public Boolean LoggedInWidgetIsPresent() throws InterruptedException
{
	eleUtil.windowMaximise();
	b= eleUtil.getElement(loggedInWidget).isDisplayed();
	Thread.sleep(2000);
	return b;

}

public String ProfileLinkClick() throws InterruptedException
{   
   
	eleUtil.windowMaximise();
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

public ProfilePage ProfilePageSetup() throws InterruptedException
{
	eleUtil.windowMaximise();
	Thread.sleep(3000);
	eleUtil.doMoveToElement(ProductCard); // just to move the cursor
	Thread.sleep(2000);
	
	mainMenu=eleUtil.getElement(loggedInWidget);
	action.moveToElement(mainMenu).build().perform();
	Thread.sleep(2000);
	
	
	eleUtil.getElement(WidgetProfile).click();
	title= eleUtil.doGetTitle(Constants.PROFILE_PAGE_TITLE,Constants.DEFAULT_TIMEOUT);
	return new ProfilePage(driver,prop);
	
	

}


public Boolean LogoutLinkClick() throws InterruptedException
{
	eleUtil.windowMaximise();
	eleUtil.getElement(welcomeText).isDisplayed();
	eleUtil.doMoveToElement(ProductCard);
	
	
	eleUtil.doMoveToElement(loggedInWidget);
	Thread.sleep(2000);
	eleUtil.getElement(WidgetLogOut).click();
	eleUtil.waitForTitleContains(Constants.HOMEPAGE_TITLE,Constants.DEFAULT_TIMEOUT); 
	Thread.sleep(2000);
    b=eleUtil.getElement(TDLoginLink).isDisplayed();
    return b;
	
}



public boolean FirstNameLastNameVisible()
{
	
 WebElement ele= eleUtil.getElement(FnLnLocator);
 String info=ele.getText();
 if (info.startsWith("Hi")) {
	 b=true;
	 
} else {
       b=false;
}
 return b;
}



public TechnicalBulletinPage TechnicalBulletinPageSetup() throws InterruptedException {
	
	eleUtil.doActionMoveToElementClick(SupportNavBar);
	eleUtil.doActionMoveToElementClick(NavBarTechBulletinLink);
	Thread.sleep(5000);
	
	eleUtil.windowMaximise();
	title= eleUtil.doGetTitle(Constants.TECH_BULLETIN_TITLE, Constants.DEFAULT_TIMEOUT);
  	return new TechnicalBulletinPage(driver,prop);
	
}




}
