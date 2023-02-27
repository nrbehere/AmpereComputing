package ampere.qa.customeconnect.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

public class IndividualProductPageTest extends BaseTest {
	
	@BeforeClass
	public void IndividualProductPageSetup() throws InterruptedException
	{
	    LoggedInHomePage.Login();
	    ProdPage=LoggedInHomePage.ProductPageSetup();
	    IndividualProductPage=ProdPage.IndividualProductPageSetup();
		   			
	}
	
	Boolean B;
	String ActualText;
	String ExpectedText;
	

	
	@Description("Test Case - Verification of Page title of the Page ")
	@Test (priority=1)
    public void PageTitle()
	{
		B=IndividualProductPage.PageTitle();
		Assert.assertTrue(B);
	}
	

	
	@Description("Test Case - Verification whether Breadcrumb is present on Page")
	@Test(priority=2)
	public void BreadCrumbVerfication() {
		B=IndividualProductPage.BreadCrumbIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Watermark Note is present on Page")
	@Test(priority=3)
	public void WaterMarkVerfication() {
		B=IndividualProductPage.waterMarkNoteIsPresent();
		Assert.assertTrue(B);
	}
	
	
	@Description("Test Case - Verification whether Password Note is present on Page")
	@Test(priority=4)
	public void PasswordVerfication() {
		B=IndividualProductPage.PasswordProtectionNoteIsPresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification whether 'Contact Our sales' button on the Page navigates user to Contact Sales page")
	@Test (priority=5)
    public void ConstactSalesVerification()
	{
		ActualText=IndividualProductPage.ContactOurSalesTeamClick();
		Assert.assertTrue(ActualText.contains(Constants.CONTACT_SALES));
	}
	
	
	@Description("Test Case - Verification whether 'Contact Our Product Support Team' button on the Page navigates user to Help page")
	@Test (priority=6)
    public void ContactOProductSupporteamVerification()
	{
		ActualText=IndividualProductPage.ContactOurProductSuppTeamClick();;
		Assert.assertTrue(ActualText.contains(Constants.HELP_PAGE_TITLE));
	}
	
	
	@Description("Test Case - Verification whether Product Name is displayed on Page")
	@Test(priority=7)
	public void ProductNameDisplayedOnPage() {
		B=IndividualProductPage.ProductNameDisplayedOnPageVerification();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification whether Title column is displayed in the Products Table on the Page")
	@Test(priority=8)
	public void TitleDisplayedOnPage() {
		B=IndividualProductPage.TitleColumnIsPresent();
		Assert.assertTrue(B);
	}
	
	
	
	@Description("Test Case - Verification whether Revision column is displayed in the Products Table on the Page")
	@Test(priority=9)
	public void RevisionColumnDisplayedOnPage() {
		B=IndividualProductPage.RevisionColumnIsPresent();
		Assert.assertTrue(B);
	}
	

	@Description("Test Case - Verification whether Date column is displayed in the Products Table on the Page")
	@Test(priority=10)
	public void DateColumnnDisplayedOnPage() {
		B=IndividualProductPage.DateColumnIsPresent();
		Assert.assertTrue(B);
	}
	
	
	@Description("Test Case - Verification whether Type column is displayed in the Products Table on the Page")
	@Test(priority=11)
	public void TypeColumnnDisplayedOnPage() {
		B=IndividualProductPage.TypeColumnIsPresent();
		Assert.assertTrue(B);
	}
	
	

	@Description("Test Case - Verification whether Type column is displayed in the Products Table on the Page")
	@Test(priority=12)
	public void SizeColumnnDisplayedOnPage() {
		B=IndividualProductPage.SizeColumnIsPresent();
		Assert.assertTrue(B);
	}
	
	@Description("Test Case - Verification of 'More About the Password' on the Page")
	@Test(priority=13)
	public void MoreAboutThePasswordOnPage() throws InterruptedException {
		B=IndividualProductPage.MoreAboutThePasswordOnPageVerification();
		Assert.assertTrue(B);
	}	
	
	
	@Description("Test Case - Verification of 'Go to All Products' on the Page")
	@Test(priority=14)
	public void GoToAllProducts() throws InterruptedException {
		ActualText=IndividualProductPage.GoToAllProductsVerification();
		Assert.assertTrue(ActualText.contains(Constants.PRODUCTS_PAGE_TITLE));
	}	
	
	
	@Description("Test Case - Verification whether Downloading Started message appears on Page once Downloads is clicked and whether the Technical document is successfully downloaded")
	@Test (priority=15)
    public void FileDownloadVerification() throws InterruptedException
	{
		String ExpectedFileName=IndividualProductPage.RandomFileSelectionForDownload();
		 File listOfFiles[]=folder.listFiles();
		    
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
