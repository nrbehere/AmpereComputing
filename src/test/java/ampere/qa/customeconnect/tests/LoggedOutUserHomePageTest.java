package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;

public class LoggedOutUserHomePageTest extends BaseTest{

	
	@Test (priority=1) 
	public void HomePageTitleTest()
	{
		String title= LoHomepage.getHomePageTitle();
		Assert.assertEquals(title, Constants.HOMEPAGE_TITLE);
	}
	
	@Test (priority=2) 
	public void HomePageURLTest()
	{
		boolean actURL= LoHomepage.HomePageURL();
		Assert.assertTrue(actURL);
	}

	@Test (priority=3) 
	public void TDLoginMessage()
	{
		String actMsg= LoHomepage.TDLoginMsg();
		Assert.assertTrue(actMsg.contains(Constants.TD_LOGIN_MSG));
		
	}
	
	@Test (priority=4)
	public void SWFLoginMessage()
	{
		String actMsg=LoHomepage.SWFLoginMsg();
		Assert.assertTrue(actMsg.contains(Constants.SWF_LOGIN_MSG));
	}
	
   @Test(priority=5)
   public void TDLoginRegisterLinkTest()
   {
	   Assert.assertTrue(LoHomepage.TDLoginLinkexists());
	   Assert.assertTrue(LoHomepage.TDRegisterLinkexists());
   }
   
   
   @Test (priority=6)
   public void SWFLoginRegisterLinkTest()
   {
	   Assert.assertTrue(LoHomepage.SWFLoginLinkExists());
	   Assert.assertTrue(LoHomepage.SWFRegisterLinkExists());
	      }
   
   
   @Test (priority=7)
   public void TDLoginClick()
   {
	   
   }
   
   @Test (priority=8)
   public void SWFLoginClick()
   {
	   
   }
   @Test (priority=9)
   public void TDRegisterClick()
   {   String regtitle = LoHomepage.TDRegisterClick();
	   Assert.assertEquals(regtitle, Constants.REGISTRATION_PAGE_TITLE);
   }
   
   @Test (priority=10)
   public void SWFRegisterClick()
   {
	 String regtitle= LoHomepage.SWRegisterClick();
	 Assert.assertEquals(regtitle, Constants.REGISTRATION_PAGE_TITLE);
   }
     

}
