package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

public class LoggedOutUserHomePageTest extends BaseTest{

	@Description("Test Case - Verification of Customer Connect Homepage title as logged out user")
	@Test (priority=1) 
	public void HomePageTitleTest()
	{
		String title= LoHomepage.getHomePageTitle();
		Assert.assertEquals(title, Constants.HOMEPAGE_TITLE);
	}
	
	@Description("Test Case - Verification of Customer Connect Homepage URL as logged out user")
	@Test (priority=2) 
	public void HomePageURLTest()
	{
		boolean actURL= LoHomepage.HomePageURL();
		Assert.assertTrue(actURL);
	}

	@Description("Test Case - Verification that 'You are not logged in' message appears on Customer Connect Homepage for Technical Document card ")
	@Test (priority=3) 
	public void TDLoginMessage()
	{
		String actMsg= LoHomepage.TDLoginMsg();
		Assert.assertTrue(actMsg.contains(Constants.TD_LOGIN_MSG));
		
	}
	
	@Description("Test Case - Verification that 'You are not logged in' message appears on Customer Connect Homepage for 'Software and Design Files Updates' card ")
	@Test (priority=4)
	public void SWFLoginMessage()
	{
		String actMsg=LoHomepage.SWFLoginMsg();
		Assert.assertTrue(actMsg.contains(Constants.SWF_LOGIN_MSG));
	}
	
   @Description("Test Case - Verification that 'Login' & 'Register' links are present on Customer Connect Homepage for Technical Document card ")	
   @Test(priority=5)
   public void TDLoginRegisterLinkTest()
   {
	   Assert.assertTrue(LoHomepage.TDLoginLinkexists());
	   Assert.assertTrue(LoHomepage.TDRegisterLinkexists());
   }
   

   @Description("Test Case - Verification that 'Login' & 'Register' links are present on Customer Connect Homepage for 'Software and Design Files Updates'card ")	 
   @Test (priority=6)
   public void SWFLoginRegisterLinkTest()
   {
	   Assert.assertTrue(LoHomepage.SWFLoginLinkExists());
	   Assert.assertTrue(LoHomepage.SWFRegisterLinkExists());
	      }
   
   
   @Description("Test Case - Verification that 'Login' link present on Customer Connect Homepage for Technical Document card ")
   @Test (priority=7)
   public void TDLoginClick()
   {
	   String title= LoHomepage.TDloginClick();
	   Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
   }
   
   @Description("Test Case - Verification that 'Login' link present on Customer Connect Homepage for 'Software and design Files Updates' card ")
   @Test (priority=8)
   public void SWFLoginClick()
   {
	   String title= LoHomepage.SWloginClick();
	   Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
   }
   
   @Description("Test Case - Verification that 'Register' link present on Customer Connect Homepage for Technical Document card ")
   @Test (priority=9)
   public void TDRegisterClick()
   {   String regtitle = LoHomepage.TDRegisterClick();
	   Assert.assertEquals(regtitle, Constants.REGISTRATION_PAGE_TITLE);
   }
   
   
   @Description("Test Case - Verification that 'Register' link present on Customer Connect Homepage for 'Software and design Files Updates' card ")
   @Test (priority=10)
   public void SWFRegisterClick()
   {
	 String regtitle= LoHomepage.SWRegisterClick();
	 Assert.assertEquals(regtitle, Constants.REGISTRATION_PAGE_TITLE);
   }
     

   @Description("Test Case - Verification that when logged out user accesses Technical Bulletins Page, user is navigated to the login page.")
   @Test (priority=11)
   public void TechDocPage()
   {
	   String actTitle= LoHomepage.VisitingTechDocPage();
	   Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	   
   }
   
   
   
}
