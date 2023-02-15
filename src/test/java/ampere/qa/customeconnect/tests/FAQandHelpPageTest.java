package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

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
	
	@Description("Test Case - Verification of Page title for FAQ & Help Page")
	@Test (priority=1)
      public void PageTitleVerfication()
	{
		ActTitle=FAQandHelpPage.getPageTitle();
		Assert.assertEquals(ActTitle, Constants.HELP_PAGE_TITLE);
	}

	@Description("Test Case - Verification of Hero Image for FAQ & Help Page")
	@Test (priority=2)
    public void HeroImageVerfication()
	{
		B=FAQandHelpPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of Text on Hero Image for FAQ & Help Page")
	@Test (priority=3)
    public void TextOnImageVerfication()
	{
		text=FAQandHelpPage.getTextOnImage();
		Assert.assertEquals(text, Constants.HELP_PAGE_TEXT_ON_HERO_IMAGE);
	}

	@Description("Test Case - Verification of Text below Hero Image for FAQ & Help Page")
	@Test(priority=4)
	public void TextBelowHeroImage()
	{
		B=FAQandHelpPage.TextBelowHeroImage();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of Help Form on FAQ & Help Page")
	@Test(priority=5)
	public void HelpFormIsPresent()
	{
		B=FAQandHelpPage.HelpFormIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of FAQ section on FAQ & Help Page")
	@Test(priority=6)
	public void FAQSectionIsPresent()
	{
		
		B=FAQandHelpPage.FAQSectionPresent();
		Assert.assertTrue(B);
		
	}
	
	@Description("Test Case - Verification of FAQ section expand and collapse on FAQ & Help Page")
	@Test(priority=7)
	public void FAQAccordianExpandCollapse() throws InterruptedException
	{
		B=FAQandHelpPage.FAQExpandCollapse();
		Assert.assertTrue(B);
	}


	@Description("Test Case - Verification of Help form submission on FAQ & Help Page")
    @Test(priority=8)
    public void HelpFormSubmission()
    {
        text=FAQandHelpPage.SuccessFulHelpFormSubmission();
        Assert.assertEquals(text, Constants.HELP_SUCCESSFUL_FORM_SUBMISSION);
    	
    }


}
