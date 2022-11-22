package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;

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
	
	@Test (priority=1)
      public void PageTitleVerfication()
	{
		ActTitle=SWUpdatesPage.getPageTitle();
		Assert.assertEquals(ActTitle, Constants.SW_DES_FILES_UPDATE_PAGE_TITLE);
	}

	@Test (priority=2)
    public void HeroImageVerfication()
	{
		B=SWUpdatesPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}

	@Test (priority=3)
    public void TextOnImageVerfication()
	{
		text=SWUpdatesPage.getTextOnImage();
		Assert.assertEquals(text, Constants.SW_UPDATE_PAGE_TEXT_ON_HEROIMAGE);
	}
	
	@Test (priority=4)
    public void WaterMarkNoteVerfication()
	{
		B=SWUpdatesPage.waterMarkNoteIsPresent();
		Assert.assertTrue(B);
	}

	@Test (priority=5)
    public void PasswordProtectionNoteVerfication()
	{
		B=SWUpdatesPage.PasswordProtectionNoteIsPresent();
		Assert.assertTrue(B);
	}
	
	@Test (priority=6)
    public void TableColumnTitleVerfication()
	{
		B=SWUpdatesPage.TableColumnTitleIspresent();
		Assert.assertTrue(B);
	}	
	
	@Test (priority=7)
    public void TableColumnRevVerfication()
	{
		B=SWUpdatesPage.TableColumnRevIspresent();
		Assert.assertTrue(B);
	}	
	
	@Test (priority=8)
    public void TableColumnDateVerfication()
	{
		B=SWUpdatesPage.TableColumnDateIspresent();
		Assert.assertTrue(B);
	}		
	
	
	@Test (priority=9)
	public void NoFileWithWorPPVerification() throws InterruptedException
	{
		B=SWUpdatesPage.NoWMPPatEndOfFiles();
		Assert.assertTrue(B);
	}
	
	@Ignore
	@Test (priority=10)
	public void FirstFileClickVerification() throws InterruptedException
	{
		B=SWUpdatesPage.FirstFileClick();
	}
}
