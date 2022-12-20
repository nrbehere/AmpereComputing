package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;

public class FAQandHelpPageTest extends BaseTest {

	@BeforeClass
	public void FAQHelpPageSetUp() throws InterruptedException
	{
		LoggedInHomePage.Login();
	     FAQandHelpPage=LoggedInHomePage.HelpPageSetup();
		
	}
	
	
	String ActTitle;
	Boolean B;
	String text;
	
	@Test (priority=1)
      public void PageTitleVerfication()
	{
		ActTitle=FAQandHelpPage.getPageTitle();
		Assert.assertEquals(ActTitle, Constants.HELP_PAGE_TITLE);
	}

	@Test (priority=2)
    public void HeroImageVerfication()
	{
		B=FAQandHelpPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}

	@Test (priority=3)
    public void TextOnImageVerfication()
	{
		text=FAQandHelpPage.getTextOnImage();
		Assert.assertEquals(text, Constants.HELP_PAGE_TEXT_ON_HERO_IMAGE);
	}

	
	@Test(priority=4)
	public void TextBelowHeroImage()
	{
		B=FAQandHelpPage.TextBelowHeroImage();
		Assert.assertTrue(B);
	}
	
	
	@Test(priority=5)
	public void HelpFormIsPresent()
	{
		B=FAQandHelpPage.HelpFormIsPresent();
		Assert.assertTrue(B);
	}
	
	@Test(priority=6)
	public void FAQSectionIsPresent()
	{
		
		B=FAQandHelpPage.FAQSectionPresent();
		Assert.assertTrue(B);
		
	}
	
	
	@Test(priority=7)
	public void FAQAccordianExpandCollapse() throws InterruptedException
	{
		B=FAQandHelpPage.FAQExpandCollapse();
		Assert.assertTrue(B);
	}
}
