package ampere.qa.customeconnect.tests;



import java.io.File;
import java.util.Date;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.factory.FolderFactory;
import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

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
	
	
	@Description("Test Case - Verification of Page title for Technical Bulletins Page")
	@Test (priority=1)
      public void PageTitleVerfication()
	{
		ActTitle=TechnicalBulletinPage.getPageTitle();
		Assert.assertEquals(ActTitle, Constants.TECH_BULLETIN_TITLE);
	}

	@Description("Test Case - Verification of Hero Image for Technical Bulletins Page")
	@Test (priority=2)
    public void HeroImageVerfication()
	{
		B=TechnicalBulletinPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification of Text on Hero Image for Technical Bulletins Page")
	@Test (priority=3)
    public void TextOnImageVerfication()
	{
		text=TechnicalBulletinPage.getTextOnImage(); 
		Assert.assertEquals(text, Constants.TECH_BULLETIN_PAGE_TEXT_ON_HERO_IMAGE);
	}


	@Description("Test Case - Verification of Watermark Note for Technical Bulletins Page")
	@Test (priority=4)
	public void WMNoteVerification()
	{
		B=TechnicalBulletinPage.isWaterMarkNotePresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of Watermark peresnt for Technical Bulletins on Technical Bulletins Page")
	@Test (priority=5)
	public void WMNInFileVerification()
	{
		B=TechnicalBulletinPage.IsWaterMarkPresentInFile();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of download of a Technical Bulletins on Technical Bulletins Page")
	@Test (priority=6)
	public void FileDownload() throws InterruptedException
	{
	    String ExpectedFileName=TechnicalBulletinPage.RandomFileSelectionForDownload();
	    File listOfFiles[]= folder.listFiles();
	    
	    if (listOfFiles.length>0)
	    {  for(int i=0;i<listOfFiles.length;i++)
	        {
	          if (listOfFiles[i].getName().contains(ExpectedFileName)) {
				B=true;
		    	}	  
	         }
		   
	    }  
	    
	    Assert.assertTrue(B);
	}
}

