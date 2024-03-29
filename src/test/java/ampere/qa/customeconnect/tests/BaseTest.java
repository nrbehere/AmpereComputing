package ampere.qa.customeconnect.tests;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ampere.qa.customerconnect.factory.DriverFactory;
import ampere.qa.customerconnect.factory.FolderFactory;
import ampere.qa.customerconnect.pages.FAQandHelpPage;
import ampere.qa.customerconnect.pages.IndividualProductPage;
import ampere.qa.customerconnect.pages.IndividualSoftwareDesignFilesPage;
import ampere.qa.customerconnect.pages.IndividualTechDocPage;
import ampere.qa.customerconnect.pages.IndividualTechnicalBulletinPage;
import ampere.qa.customerconnect.pages.LoggedInUserHomePage;
import ampere.qa.customerconnect.pages.LoggedOutUserHelpPage;
import ampere.qa.customerconnect.pages.LoggedOutUserHomePage;
import ampere.qa.customerconnect.pages.LoggedOutUserNavigation;
import ampere.qa.customerconnect.pages.LoggedOutUserProductPage;
import ampere.qa.customerconnect.pages.NavBarToHomePage;
import ampere.qa.customerconnect.pages.ProductsPage;
import ampere.qa.customerconnect.pages.ProfilePage;
import ampere.qa.customerconnect.pages.SWUpdatesPage;
import ampere.qa.customerconnect.pages.TechnicalBulletinPage;
import ampere.qa.customerconnect.pages.TechnicalBulletinUpdatesPage;
import ampere.qa.customerconnect.pages.TechnicalDocumentUpdatesPage;

public class BaseTest {
	
	DriverFactory df;
	Properties prop;
	WebDriver  driver;
	FolderFactory folderfac;
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
	TechnicalBulletinPage TechnicalBulletinPage;
	ProfilePage ProfilePage;
	IndividualTechDocPage IndividaulTechDocPage;
	IndividualSoftwareDesignFilesPage IndividualSoftwareDesignFilesPage;
	IndividualTechnicalBulletinPage IndividualTechnicalBulletinPage;
	ProductsPage ProdPage;
	IndividualProductPage IndividualProductPage;
	
	
	public static File folder;
	
	
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
	   	df= new DriverFactory();
	   	folderfac=new FolderFactory(folder);
	   	folder=folderfac.CreateFolder();
	   	prop=df.init_prop();
	   	driver= df.init_driver(prop,folder);
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
