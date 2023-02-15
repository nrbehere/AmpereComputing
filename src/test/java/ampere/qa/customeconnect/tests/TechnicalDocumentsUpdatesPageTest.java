package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

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
	
	@Description("Test Case - Verification of Page title for Technical Documents Updates Page")
	@Test (priority=1)
	public void PageTitleVerification()
	{
		
		ActTitle=TechDocUpdatesPage.getPageTitle();
		Assert.assertEquals(ActTitle,Constants.TECH_DOC_UPDATE_PAGE_TITLE );
	}
	
	@Description("Test Case - Verification of Hero Image for Technical Documents Updates Page")
	@Test (priority=2)
    public void HeroImageVerfication()
	{
		B=TechDocUpdatesPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification of Text on Hero Image for Technical Documents Updates Page")
	@Test (priority=3)
    public void TextOnImageVerfication()
	{
		text=TechDocUpdatesPage.getTextOnImage();
		Assert.assertEquals(text, Constants.TECH_DOC_UPDATES_PAGE_TEXTONIMAGE);
	}

	@Description("Test Case - Verification That Watermark Note is present for Technical Documents Updates Page")
	@Test (priority=4)
    public void WaterMarkNoteVerfication()
	{
		B=TechDocUpdatesPage.waterMarkNoteIsPresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification That Password Protection note is present for Technical Documents Updates Page")
	@Test (priority=5)
    public void PasswordProtectionNoteVerfication()
	{
		B=TechDocUpdatesPage.PasswordProtectionNoteIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of Title Column in the Files Table for Technical Documents Updates Page")
	@Test (priority=6)
    public void TableColumnTitleVerfication()
	{
		B=TechDocUpdatesPage.TableColumnTitleIspresent();
		Assert.assertTrue(B);
	}	

	@Description("Test Case - Verification of Type Column in the Files Table for Technical Documents Updates Page")
	@Test (priority=7)
    public void TableColumnTypeVerfication()
	{
		B=TechDocUpdatesPage.TableColumnTypeIspresent();
		Assert.assertTrue(B);
	}	
	
	@Description("Test Case - Verification of Revision Column in the Files Table for Technical Documents Updates Page")
	@Test (priority=8)
    public void TableColumnRevVerfication()
	{
		B=TechDocUpdatesPage.TableColumnRevIspresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of Dates Column in the Files Table for Technical Documents Updates Page")
	@Test (priority=9)
    public void TableColumnDateVerfication()
	{
		B=TechDocUpdatesPage.TableColumnDateIspresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification of File Column in the Files Table for Technical Documents Updates Page")
	@Test (priority=10)
    public void TableColumnFileVerfication()
	{
		B=TechDocUpdatesPage.TableColumnFileIspresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification of Size Column in the Files Table for Technical Documents Updates Page")
	@Test (priority=11)
    public void TableColumnSizeVerfication()
	{
		B=TechDocUpdatesPage.TableColumnSizeIspresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of clicking a Technical Document from Technical Documents Updates Page")
	@Test (priority=12)
	public void TechnicalDocumentClick() throws InterruptedException
	{
		B=TechDocUpdatesPage.TechDocClick();
		Assert.assertTrue(B);
		
	}

}
