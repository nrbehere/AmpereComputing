package ampere.qa.customeconnect.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.pages.LoggedInUserHomePage;
import ampere.qa.customerconnect.utils.Constants;

public class LoggedInUserHomePageTest extends BaseTest {
	
	Boolean B;
	String ActTitle;
	String ActText;
	
	
	
	@BeforeClass
	public void LoginSetUp() throws InterruptedException
	{
		LoggedInHomePage.Login();
	}
	
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

	@Test (priority=2)
	public void AccessMessageVerification()
	{
		ActText=LoggedInHomePage.AccessMessageIsPresent();
		Assert.assertTrue(ActText.contains(Constants.HOMEPAGE_ACCESSMSG));
	}
	
	@Test (priority=3)
	public void TechnicalDocumentCardVerification()
	{
		B=LoggedInHomePage.TechDocCardPresent();
		Assert.assertTrue(B);
		ActTitle=LoggedInHomePage.TechDocViewAllClick();
		Assert.assertEquals(ActTitle, Constants.TECH_DOC_UPDATE_PAGE_TITLE);
	}
	
	@Test (priority=4)
	public void SoftwarePackageCardVerification()
	{
		B=LoggedInHomePage.SoftwareDesignFilesCardPresent();
		Assert.assertTrue(B);
		ActTitle=LoggedInHomePage.SoftwareDesignFilesViewAllClick();
		Assert.assertEquals(ActTitle, Constants.SW_DES_FILES_UPDATE_PAGE_TITLE);
				
	} 
	
	@Test (priority=5)
	public void TechnicalBulletinCardVerification()
	{
	  B=LoggedInHomePage.TechBulletinCardPresent();
	  Assert.assertTrue(B);
	  ActTitle=LoggedInHomePage.TechBulletinViewAllClick();
	  Assert.assertEquals(ActTitle, Constants.TECH_BULLETIN_UPDATE_PAGE_TITLE);
	}

	@Test (priority=6)
	public void HelpCardVerification()
	{
		B=LoggedInHomePage.HelpFAQCardPresent();
		Assert.assertTrue(B);
		ActTitle=LoggedInHomePage.HelpReadMoreClick();
		Assert.assertEquals(ActTitle, Constants.HELP_PAGE_TITLE);
	}

	@Test (priority=7)
	public void ProfileLogoutWidget() throws InterruptedException
	{
		B=LoggedInHomePage.LoggedInWidgetIsPresent();
		Assert.assertTrue(B);
	    
		
	}

	@Test (priority=8)
	public void ProfileLinkVerification() throws InterruptedException
	{
		ActTitle=LoggedInHomePage.ProfileLinkClick();
	    Assert.assertEquals(ActTitle, Constants.PROFILE_PAGE_TITLE);
	}
	
	@Test (priority=9)
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
