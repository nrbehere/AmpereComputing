package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

public class SWUpdatesPageTest extends BaseTest{
	
	
	@BeforeClass
	public void SWUpdatesPageSetup() throws InterruptedException
	{
		LoggedInHomePage.Login();
		SWUpdatesPage=LoggedInHomePage.SWDesFilesViewAllClickPageSetUp();
	}

	String ActTitle;
	Boolean B;
	String text;
	
	@Description("Test Case - Verification of Page title for Software and Design Files Updates Page")
	@Test (priority=1)
      public void PageTitleVerfication()
	{
		ActTitle=SWUpdatesPage.getPageTitle();
		Assert.assertEquals(ActTitle, Constants.SW_DES_FILES_UPDATE_PAGE_TITLE);
	}

	@Description("Test Case - Verification of Hero Image for Software and Design Files Updates Page")
	@Test (priority=2)
    public void HeroImageVerfication()
	{
		B=SWUpdatesPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification of Text on Hero Image for Software and Design Files Updates Page")
	@Test (priority=3)
    public void TextOnImageVerfication()
	{
		text=SWUpdatesPage.getTextOnImage();
		Assert.assertEquals(text, Constants.SW_UPDATE_PAGE_TEXT_ON_HEROIMAGE);
	}
	
	
	@Description("Test Case - Verification of Watermark Note for Software and Design Files Updates Page")
	@Test (priority=4)
    public void WaterMarkNoteVerfication()
	{
		B=SWUpdatesPage.waterMarkNoteIsPresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification of Password protection Note for Software and Design Files Updates Page")
	@Test (priority=5)
    public void PasswordProtectionNoteVerfication()
	{
		B=SWUpdatesPage.PasswordProtectionNoteIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of Title Column in the Files Table for Software and Design Files Updates Page")
	@Test (priority=6)
    public void TableColumnTitleVerfication()
	{
		B=SWUpdatesPage.TableColumnTitleIspresent();
		Assert.assertTrue(B);
	}	
	
	@Description("Test Case - Verification of Revision Column in the Files Table for Software and Design Files Updates Page")
	@Test (priority=7)
    public void TableColumnRevVerfication()
	{
		B=SWUpdatesPage.TableColumnRevIspresent();
		Assert.assertTrue(B);
	}	
	
	@Description("Test Case - Verification of Date Column in the Files Table for Software and Design Files Updates Page")
	@Test (priority=8)
    public void TableColumnDateVerfication()
	{
		B=SWUpdatesPage.TableColumnDateIspresent();
		Assert.assertTrue(B);
	}		
	
	
	@Description("Test Case - Verification that No water marked or password protected file for Software and Design Files Updates Page")
	@Test (priority=9)
	public void NoFileWithWorPPVerification() throws InterruptedException
	{
		B=SWUpdatesPage.NoWMPPatEndOfFiles();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of  first file from Files table for Software and Design Files Updates Page")
	@Test (priority=10)
	public void FirstFileClickVerification() throws InterruptedException
	{
		B=SWUpdatesPage.FirstFileClick();
		Assert.assertTrue(B);
	}
}
