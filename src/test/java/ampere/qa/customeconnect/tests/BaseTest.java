package ampere.qa.customeconnect.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ampere.qa.customerconnect.factory.DriverFactory;
import ampere.qa.customerconnect.pages.FAQandHelpPage;
import ampere.qa.customerconnect.pages.LoggedInUserHomePage;
import ampere.qa.customerconnect.pages.LoggedOutUserHelpPage;
import ampere.qa.customerconnect.pages.LoggedOutUserHomePage;
import ampere.qa.customerconnect.pages.LoggedOutUserNavigation;
import ampere.qa.customerconnect.pages.LoggedOutUserProductPage;
import ampere.qa.customerconnect.pages.NavBarToHomePage;
import ampere.qa.customerconnect.pages.SWUpdatesPage;
import ampere.qa.customerconnect.pages.TechnicalBulletinUpdatesPage;
import ampere.qa.customerconnect.pages.TechnicalDocumentUpdatesPage;

public class BaseTest {
	
	DriverFactory df;
	Properties prop;
	WebDriver  driver;
	LoggedOutUserHomePage LoHomepage;
	LoggedOutUserNavigation LoNavigation;
  	LoggedOutUserProductPage LoProductPage;
	LoggedOutUserHelpPage HP;
	NavBarToHomePage NavBarHomePage;
	LoggedInUserHomePage LoggedInHomePage;
	SWUpdatesPage SWUpdatesPage;
	TechnicalDocumentUpdatesPage TechDocUpdatesPage;
	TechnicalBulletinUpdatesPage TechBulletinUpadtesPage;
	FAQandHelpPage FAQandHelpPage;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
	   	df= new DriverFactory();
	   	prop=df.init_prop();
	   	driver= df.init_driver(prop);
	   	LoHomepage=new LoggedOutUserHomePage(driver,prop);
	   	LoggedInHomePage=new LoggedInUserHomePage(driver,prop);
	   	
	   	NavBarHomePage= new NavBarToHomePage(driver);
	   	LoNavigation= new LoggedOutUserNavigation(driver);
	   	
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	

}
