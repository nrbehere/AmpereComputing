package ampere.qa.customeconnect.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.pages.LoggedInUserHomePage;
import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

public class LoggedInUserHomePageTest extends BaseTest {
	
	Boolean B;
	String ActTitle;
	String ActText;
	
	
	@BeforeClass
	public void LoginSetUp() throws InterruptedException
	{
		LoggedInHomePage.Login();
	}
	
	
	@Description("Logged In User Home Page Test - Welcome Text Verification")
	@Test (priority=1)
	public void WelcomeTextVerification()
	{
	    ActTitle=LoggedInHomePage.PageTitleCheck();
	    Assert.assertEquals(ActTitle, Constants.HOMEPAGE_TITLE);
		
	   ActText=LoggedInHomePage.WelcomeMesaagePresent();	
	   Assert.assertEquals(ActText, Constants.WELCOME_TEXT_HOMEPAGE);
	   
	   B=LoggedInHomePage.HeroImageIsPresent();
	   Assert.assertTrue(B);
	}
	
	
	@Description("Logged In User Home Page Test- User First Name & Last Name is reflected post successful login")
    @Test(priority=2)
	public void UserNameVerification()
	{
		B=LoggedInHomePage.FirstNameLastNameVisible();
		Assert.assertTrue(B);
		
	}
	
	@Description("Logged In User Home Page Test - Access Message Verification")
	@Test (priority=3)
	public void AccessMessageVerification()
	{
		ActText=LoggedInHomePage.AccessMessageIsPresent();
		Assert.assertTrue(ActText.contains(Constants.HOMEPAGE_ACCESSMSG));
	}
	
	

	@Description("Logged In User Home Page Test - Product Card Verification")	
	@Test (priority=4)
	public void ProductCardVerification()
	{
		B=LoggedInHomePage.ProductCardPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Logged In User Home Page Test - Search Bar Verification")	
	@Test (priority=5)
	public void SearchBarPresent()
	{
		B=LoggedInHomePage.SearchBarIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Logged In User Home Page Test - Search Functionality Verification")	
	@Test (priority=6)
	public void SearchFunctionalityVerification()
	{
		// code to be written
	}
	
	
	
	@Description("Logged In User Home Page Test - Product Family Verification")	
	@Test (priority=8)
	public void ProductFamilyVerification()
	{
		B=LoggedInHomePage.ProductFamilPyresent();
		Assert.assertTrue(B);
	}
	
	@Description("Logged In User Home Page Test - Product Category Verification")	
	@Test (priority=9)
	public void ProductCategoryVerification()
	{
		B=LoggedInHomePage.ProductCategoryPresent();
		Assert.assertTrue(B); 
	}
	
	
	@Description("Logged In User Home Page Test - Product Verification")	
	@Test (priority=10)
	public void ProductVerification() throws InterruptedException
	{
		LoggedInHomePage.ExpandProductCategory();
		B=LoggedInHomePage.ProductsArePresent();
		Assert.assertTrue(B);
	}
	
	@Description("Logged In User Home Page Test - Product Click Verification")	
	@Test (priority=11)
	public void ProductClickVerification() throws InterruptedException
	{
		LoggedInHomePage.ExpandProductCategory();
	    B=LoggedInHomePage.ProductClick();
	    Assert.assertTrue(B);
	
	}
	
	@Description("Logged In User Home Page Test - Technical Document and Software Updates Card Verification")
	@Test (priority=12)
	public void TechnicalDocumentAndSoftwareUpdatesCardVerification() throws InterruptedException
	{
		B=LoggedInHomePage.TechDocCardIsPresent();
		Assert.assertTrue(B);
		ActTitle=LoggedInHomePage.TechDocViewAllClick();
		Assert.assertEquals(ActTitle, Constants.TECH_DOC_UPDATE_PAGE_TITLE);
		ActTitle=LoggedInHomePage.SoftwareDesignFilesViewAllClick();
		Assert.assertEquals(ActTitle, Constants.SW_DES_FILES_UPDATE_PAGE_TITLE);
	}
	
	
	@Description("Logged In User Home Page Test - Technical Bulletin Card Verification")
	@Test (priority=13)
	public void TechnicalBulletinCardVerification()
	{
	  B=LoggedInHomePage.TechBulletinCardPresent();
	  Assert.assertTrue(B);
	  ActTitle=LoggedInHomePage.TechBulletinViewAllClick();
	  Assert.assertEquals(ActTitle, Constants.TECH_BULLETIN_UPDATE_PAGE_TITLE);
	}

	@Description("Logged In User Home Page Test - FAQ & Help Card Verification")
	@Test (priority=14)
	public void HelpCardVerification() throws InterruptedException
	{
		B=LoggedInHomePage.HelpFAQCardPresent();
		Assert.assertTrue(B);
		B=LoggedInHomePage.RMALinkPresent();
		Assert.assertTrue(B);
		ActTitle=LoggedInHomePage.HelpReadMoreClick();
		Assert.assertEquals(ActTitle, Constants.HELP_PAGE_TITLE);
		
	}

	@Description("Logged In User Home Page Test - Widget Verification")
	@Test (priority=15)
	public void ProfileLogoutWidget() throws InterruptedException
	{
		B=LoggedInHomePage.LoggedInWidgetIsPresent();
		Assert.assertTrue(B);
	    
		
	}

	
	@Test (priority=16)
	public void ProfileLinkVerification() throws InterruptedException
	{
		ActTitle=LoggedInHomePage.ProfileLinkClick();
	    Assert.assertEquals(ActTitle, Constants.PROFILE_PAGE_TITLE);
	}
	
	@Test (priority=17)
	public void LogoutLinkVerification() throws InterruptedException
	{
		B=LoggedInHomePage.LogoutLinkClick();
		assertTrue(B);
		
	}
	
	
	@AfterClass
	public void LogoutSetUp()
	{
		
	}
}
