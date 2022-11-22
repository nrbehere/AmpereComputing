package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;

public class TechnicalDocumentsUpdatesPageTest extends BaseTest{
	
	@BeforeClass
	public void TechDocUpdatesPageSetup() throws InterruptedException
	{
		LoggedInHomePage.Login();
		 TechDocUpdatesPage=LoggedInHomePage.TechDocViewAllClickPageSetUp();
	}
	
	
	String ActTitle;
	Boolean B;
	String text;
	
	@Test (priority=1)
	public void PageTitleVerification()
	{
		
		ActTitle=TechDocUpdatesPage.getPageTitle();
		Assert.assertEquals(ActTitle,Constants.TECH_DOC_UPDATE_PAGE_TITLE );
	}
	
	@Test (priority=2)
    public void HeroImageVerfication()
	{
		B=TechDocUpdatesPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}

	@Test (priority=3)
    public void TextOnImageVerfication()
	{
		text=TechDocUpdatesPage.getTextOnImage();
		Assert.assertEquals(text, Constants.TECH_DOC_UPDATES_PAGE_TEXTONIMAGE);
	}

	@Test (priority=4)
    public void WaterMarkNoteVerfication()
	{
		B=TechDocUpdatesPage.waterMarkNoteIsPresent();
		Assert.assertTrue(B);
	}

	@Test (priority=5)
    public void PasswordProtectionNoteVerfication()
	{
		B=TechDocUpdatesPage.PasswordProtectionNoteIsPresent();
		Assert.assertTrue(B);
	}
	
	@Test (priority=6)
    public void TableColumnTitleVerfication()
	{
		B=TechDocUpdatesPage.TableColumnTitleIspresent();
		Assert.assertTrue(B);
	}	

	@Test (priority=7)
    public void TableColumnTypeVerfication()
	{
		B=TechDocUpdatesPage.TableColumnTypeIspresent();
		Assert.assertTrue(B);
	}	
	
	@Test (priority=8)
    public void TableColumnRevVerfication()
	{
		B=TechDocUpdatesPage.TableColumnRevIspresent();
		Assert.assertTrue(B);
	}
	
	
	@Test (priority=9)
    public void TableColumnDateVerfication()
	{
		B=TechDocUpdatesPage.TableColumnDateIspresent();
		Assert.assertTrue(B);
	}

	@Test (priority=10)
    public void TableColumnFileVerfication()
	{
		B=TechDocUpdatesPage.TableColumnFileIspresent();
		Assert.assertTrue(B);
	}

	@Test (priority=11)
    public void TableColumnSizeVerfication()
	{
		B=TechDocUpdatesPage.TableColumnSizeIspresent();
		Assert.assertTrue(B);
	}
	
	

}
