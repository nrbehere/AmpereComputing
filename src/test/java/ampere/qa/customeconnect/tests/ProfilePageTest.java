package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

public class ProfilePageTest extends BaseTest{

	@BeforeClass
    public void UserProfilePageSetup() throws InterruptedException {
		LoggedInHomePage.Login();
		ProfilePage=LoggedInHomePage.ProfilePageSetup();
	}
	
	
	String ActTitle;
	Boolean B;
	String text;

	
	
	@Description("User Profile Page Test - Page Title Verification")
	@Test (priority=1)
    public void PageTitleVerfication()
	{
		ActTitle=ProfilePage.getPageTitle();
		Assert.assertEquals(ActTitle, Constants.PROFILE_PAGE_TITLE);
	}

	@Description("User Profile Page Test - Hero Image Verification")
	@Test (priority=2)
  public void HeroImageVerfication()
	{
		B=ProfilePage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}

	@Description("User Profile Page Test -Text On Hero Image Verification")
	@Test (priority=3)
  public void TextOnImageVerfication()
	{
		text=ProfilePage.getTextOnImage();
		Assert.assertEquals(text, Constants.PROFILE_PAGE_TEXT_ON_HERO_IMAGE);
	}

	@Description("User Profile Page Test - Form Verification")
	@Test (priority=4)
  public void FormVerification()
	{
	   B=ProfilePage.isFormPresent();
	   Assert.assertTrue(B);
	
	}
	
	@Description("User Profile Page Test - Form Field Verification")
	@Test (priority=5)
  public void FormFieldsVerification() throws InterruptedException
	{
	   B=ProfilePage.AreProfileFieldsPresent();
	   Assert.assertTrue(B);
	
	}
	
	
	
	
	
}
