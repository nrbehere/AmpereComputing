package ampere.qa.customeconnect.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

public class IndividualTechnicalBulletinPageTest extends BaseTest {
	
	@BeforeClass
	public void IndividaulTechDocPageSetup() throws InterruptedException
	{
		LoggedInHomePage.Login();
		TechBulletinUpadtesPage=LoggedInHomePage.TechBulletinViewAllClickPageSetup();
		IndividualTechnicalBulletinPage=TechBulletinUpadtesPage.IndividualTechBulletinPageSetup();
				
	}
	
	Boolean B;
	String ActualText;
	String ExpectedText;
	
	@Description("Test Case - Verification whether Hero Image is present")
	@Test (priority=1)
    public void HeroImageVerfication()
	{
		B=IndividualTechnicalBulletinPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}
	

	@Description("Test Case - Verification whether Text On Hero Image is present on Page")
	@Test (priority=2)
    public void TextOnImageIsPresent()
	{
		B=IndividualTechnicalBulletinPage.TextOnImageIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Text On Hero Image is present on Page")
	@Test (priority=3)
    public void TextOnImageVerification()
	{
		ActualText=IndividualTechnicalBulletinPage.TextOnImageVerification();
		Assert.assertEquals(ActualText, Constants.INDI_TECH_BULLETIN_TEXT_ON_HERO_IMAGE);
		
	}
	
	@Description("Test Case - Verification whether Breadcrumb is present on Page")
	@Test (priority=4)
    public void BreadCrumbVerfication()
	{
		B=IndividualTechnicalBulletinPage.BreadCrumbIsPresent();
		Assert.assertTrue(B);
	}
	

	@Description("Test Case - Verification whether Name of the Technical Bulletin is present on Page")
	@Test (priority=5)
    public void NameOfTechDoc()
	{
		B=IndividualTechnicalBulletinPage.NameOfFileIsPresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification whether Release Date of the Technical Bulletin is present on Page")
	@Test (priority=6)
    public void ReleaseDateOfTechDoc()
	{
		B=IndividualTechnicalBulletinPage.RelDateOfFileIsPresent();
		Assert.assertTrue(B);
	}
	
	
	@Description("Test Case - Verification whether Size of the Technical Bulletin is present on Page")
	@Test (priority=7)
    public void SizeOfTechDoc()
	{
		B=IndividualTechnicalBulletinPage.SizeOfFileIsPresent();
		Assert.assertTrue(B);
	}
	
	
	@Description("Test Case - Verification whether Type of the Technical Bulletin is present on Page")
	@Test (priority=8)
    public void TypeOfTechDoc()
	{
		B=IndividualTechnicalBulletinPage.TypeOfFileIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether button to download Technical Bulletin is present on Page")
	@Test (priority=9)
    public void DownloadButtonTechDocIsPresent()
	{
		B=IndividualTechnicalBulletinPage.DownloadButtonIsPresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification whether Downloading Started meesage appears on Page once Downloads is clicked and whether the Technical Bulletin is successfully downloaded")
	@Test (priority=10)
    public void FileDownloadVerification() throws InterruptedException
	{
		String ExpectedFileName=IndividualTechnicalBulletinPage.DownloadButtonClick();
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
