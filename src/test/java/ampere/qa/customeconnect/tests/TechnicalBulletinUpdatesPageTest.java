package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;

public class TechnicalBulletinUpdatesPageTest extends BaseTest {
	
	@BeforeClass
    public void TechBulletinPageSetup() throws InterruptedException {
		LoggedInHomePage.Login();
		TechBulletinUpadtesPage=LoggedInHomePage.TechBulletinViewAllClickPageSetup();
		
		
	}	
	
	
	String ActTitle;
	Boolean B;
	String text;
	
	@Test (priority=1)
      public void PageTitleVerfication()
	{
		ActTitle=TechBulletinUpadtesPage.getPageTitle();
		Assert.assertEquals(ActTitle, Constants.TECH_BULLETIN_UPDATE_PAGE_TITLE);
	}

	@Test (priority=2)
    public void HeroImageVerfication()
	{
		B=TechBulletinUpadtesPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}

	@Test (priority=3)
    public void TextOnImageVerfication()
	{
		text=TechBulletinUpadtesPage.getTextOnImage();
		Assert.assertEquals(text, Constants.TECH_BULLETIN_UPDATE_PAGE_TEXT_ON_HEROIMAGE);
	}
	
	@Test (priority=4)
    public void WaterMarkNoteVerfication()
	{
		B=TechBulletinUpadtesPage.waterMarkNoteIsPresent();
		Assert.assertTrue(B);
	}

	@Test (priority=5)
    public void TableColumnTitleVerfication()
	{
		B=TechBulletinUpadtesPage.TableColumnTitleIspresent();
		Assert.assertTrue(B);
	}	
	
	@Test (priority=6)
    public void TableColumnTypeVerfication()
	{
		B=TechBulletinUpadtesPage.TableColumnTypeIspresent();
		Assert.assertTrue(B);
	}	
	
	@Test (priority=7)
    public void TableColumnDateVerfication()
	{
		B=TechBulletinUpadtesPage.TableColumnDateIspresent();
		Assert.assertTrue(B);
	}
	
	@Test (priority=8)
    public void TableColumnFileVerfication()
	{
		B=TechBulletinUpadtesPage.TableColumnFileIspresent();
		Assert.assertTrue(B);
	}		
	
	@Test (priority=9)
    public void TableColumnSizeVerfication()
	{
		B=TechBulletinUpadtesPage.TableColumnSizeIspresent();
		Assert.assertTrue(B);
	}
	
	
	@Test (priority=10)
	public void FirstFileClickVerification() throws InterruptedException
	{
		B=TechBulletinUpadtesPage.FirstFileClick();
		Assert.assertTrue(B);
	}

}
