package ampere.qa.customeconnect.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ampere.qa.customerconnect.factory.DriverFactory;
import ampere.qa.customerconnect.pages.LoggedOutUserHelpPage;
import ampere.qa.customerconnect.pages.LoggedOutUserHomePage;
import ampere.qa.customerconnect.pages.LoggedOutUserNavigation;
import ampere.qa.customerconnect.pages.LoggedOutUserProductPage;

public class BaseTest {
	
	DriverFactory df;
	Properties prop;
	WebDriver  driver;
	LoggedOutUserHomePage LoHomepage;
	LoggedOutUserNavigation LoNavigation;
  	LoggedOutUserProductPage LoProductPage;
	LoggedOutUserHelpPage HP;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
	   	df= new DriverFactory();
	   	prop=df.init_prop();
	   	driver= df.init_driver(prop);
	   	LoHomepage=new LoggedOutUserHomePage(driver);
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	

}
