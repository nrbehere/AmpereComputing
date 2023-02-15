package ampere.qa.customeconnect.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

public class IndividualSoftwareDesignFilesPageTest extends BaseTest {

	@BeforeClass
	public void IndividaulTechDocPageSetup() throws InterruptedException
	{
		LoggedInHomePage.Login();
		SWUpdatesPage=LoggedInHomePage.SWDesFilesViewAllClickPageSetUp();
		IndividualSoftwareDesignFilesPage=SWUpdatesPage.IndividualSoftwareDesignFilesPageSetup();
		}
	
	Boolean B;
	String ActualText;
	String ExpectedText;
	
	@Description("Test Case - Verification whether Hero Image is present")
	@Test (priority=1)
    public void HeroImageVerfication()
	{
		B=IndividualSoftwareDesignFilesPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Text On Hero Image is present on Page")
	@Test (priority=2)
    public void TextOnImageIsPresent()
	{
		B=IndividualSoftwareDesignFilesPage.TextOnImageIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Text On Hero Image is present on Page")
	@Test (priority=3)
    public void TextOnImageVerification()
	{
		ActualText=IndividualSoftwareDesignFilesPage.TextOnImageVerification();
		Assert.assertEquals(ActualText, Constants.INDI_SW_PCK_PAGE_TEXT_ON_HERO_IMAGE);
		
	}

	@Description("Test Case - Verification whether Breadcrumb is present on Page")
	@Test (priority=4)
    public void BreadCrumbVerfication()
	{
		B=IndividualSoftwareDesignFilesPage.BreadCrumbIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Details of the Software Package is present on Page")
	@Test (priority=5)
    public void DetailsOfSWPack()
	{
		B=IndividualSoftwareDesignFilesPage.SoftwarePackageDeatilsArePresent();
		Assert.assertTrue(B);
	}
	

	@Description("Test Case - Verification whether Name of the File is present on Page")
	@Test (priority=6)
    public void NameOfFileIsPresent()
	{
		B=IndividualSoftwareDesignFilesPage.FileNameIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Type of the File is present on Page")
	@Test (priority=7)
    public void TypeOfFileIsPresent()
	{
		B=IndividualSoftwareDesignFilesPage.FileTypeIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Size of the File is present on Page")
	@Test (priority=8)
    public void SizeOfFileIsPresent()
	{
		B=IndividualSoftwareDesignFilesPage.FileSizeIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Downloading Started meesage appears on Page once File is clicked and whether the File of the Software Package is successfully downloaded")
	@Test (priority=9)
    public void FileDownloadVerification() throws InterruptedException
	{
		 String ExpectedFileName=IndividualSoftwareDesignFilesPage.FileClickForDownload();
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
