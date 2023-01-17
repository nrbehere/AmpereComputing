package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;

public class TechnicalBulletinPageTest extends BaseTest {

	
	@BeforeClass
	public void TechincalBulletinPageSetup() throws InterruptedException
	{
		LoggedInHomePage.Login();
		TechnicalBulletinPage=LoggedInHomePage.TechnicalBulletinPageSetup();
				
	}
	
	
	String ActTitle;
	Boolean B;
	String text;
	
	@Test (priority=1)
      public void PageTitleVerfication()
	{
		ActTitle=TechnicalBulletinPage.getPageTitle();
		Assert.assertEquals(ActTitle, Constants.TECH_BULLETIN_TITLE);
	}

	@Test (priority=2)
    public void HeroImageVerfication()
	{
		B=TechnicalBulletinPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}

	@Test (priority=3)
    public void TextOnImageVerfication()
	{
		text=TechnicalBulletinPage.getTextOnImage(); 
		Assert.assertEquals(text, Constants.TECH_BULLETIN_PAGE_TEXT_ON_HERO_IMAGE);
	}


	@Test (priority=4)
	public void WMNoteVerification()
	{
		B=TechnicalBulletinPage.isWaterMarkNotePresent();
		Assert.assertTrue(B);
	}
	
}
