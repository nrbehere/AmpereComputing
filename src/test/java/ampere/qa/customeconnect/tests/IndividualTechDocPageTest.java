package ampere.qa.customeconnect.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

public class IndividualTechDocPageTest extends BaseTest {
	
	@BeforeClass
	public void IndividaulTechDocPageSetup() throws InterruptedException
	{
		LoggedInHomePage.Login();
		TechDocUpdatesPage=LoggedInHomePage.TechDocViewAllClickPageSetUp();
		IndividaulTechDocPage=TechDocUpdatesPage.IndividualTechDocPageSetup();
		
	}
	
	Boolean B;
	String ActualText;
	String ExpectedText;
	
	@Description("Test Case - Verification whether Hero Image is present")
	@Test (priority=1)
    public void HeroImageVerfication()
	{
		B=IndividaulTechDocPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}
	

	@Description("Test Case - Verification whether Text On Hero Image is present on Page")
	@Test (priority=2)
    public void TextOnImageIsPresent()
	{
		B=IndividaulTechDocPage.TextOnImageIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Text On Hero Image is present on Page")
	@Test (priority=3)
    public void TextOnImageVerification()
	{
		ActualText=IndividaulTechDocPage.TextOnImageVerification();
		Assert.assertEquals(ActualText, Constants.INDI_TECH_DOC_PAGE_TEXT_ON_HERO_IMAGE);
		
	}
	
	@Description("Test Case - Verification whether Breadcrumb is present on Page")
	@Test (priority=4)
    public void BreadCrumbVerfication()
	{
		B=IndividaulTechDocPage.BreadCrumbIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Name of the Technical Document is present on Page")
	@Test (priority=5)
    public void NameOfTechDoc()
	{
		B=IndividaulTechDocPage.NameOfFileIsPresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification whether Revision of the Technical Document is present on Page")
	@Test (priority=6)
    public void RevOfTechDoc()
	{
		B=IndividaulTechDocPage.RevOfFileIsPresent();
		Assert.assertTrue(B);
	}
	
	
	@Description("Test Case - Verification whether Release Date of the Technical Document is present on Page")
	@Test (priority=7)
    public void ReleaseDateOfTechDoc()
	{
		B=IndividaulTechDocPage.RelDateOfFileIsPresent();
		Assert.assertTrue(B);
	}
	
	
	@Description("Test Case - Verification whether Size of the Technical Document is present on Page")
	@Test (priority=8)
    public void SizeOfTechDoc()
	{
		B=IndividaulTechDocPage.SizeOfFileIsPresent();
		Assert.assertTrue(B);
	}
	
	
	@Description("Test Case - Verification whether Type of the Technical Document is present on Page")
	@Test (priority=9)
    public void TypeOfTechDoc()
	{
		B=IndividaulTechDocPage.TypeOfFileIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether button to download Technical Document is present on Page")
	@Test (priority=10)
    public void DownloadButtonTechDocIsPresent()
	{
		B=IndividaulTechDocPage.DownloadButtonIsPresent();
		Assert.assertTrue(B);
	}
	
	
	@Description("Test Case - Verification whether Downloading Started meesage appears on Page once Downloads is clicked and whether the Technical document is successfully downloaded")
	@Test (priority=11)
    public void FileDownloadVerification() throws InterruptedException
	{
		String ExpectedFileName=IndividaulTechDocPage.DownloadButtonClick();
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
