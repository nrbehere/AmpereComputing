package ampere.qa.customeconnect.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

public class ProductsPageTest extends BaseTest {

	@BeforeClass
	public void ProductPageSetup() throws InterruptedException
	{
		LoggedInHomePage.Login();
		ProdPage=LoggedInHomePage.ProductPageSetup();
		
	}
	
	String ActTitle;
	Boolean B;
	String text;
	
	@Description("Test Case - Verification of Hero Image for Production Page")
	@Test (priority=1)
    public void HeroImageVerfication()
	{
		B=ProdPage.HeroImageIsPresent();
		Assert.assertTrue(B);
	}

	@Description("Test Case - Verification of Text on Hero Image for Products Page")
	@Test (priority=2)
    public void TextOnImageVerfication()
	{
		text=ProdPage.getTextOnImage(); 
		Assert.assertEquals(text, Constants.PRODUCTS_PAGE_TEXT_ON_HERO_IMAGE);
	}
	
	@Description("Test Case - Verification of Page title for Products Page")
	@Test (priority=3)
      public void PageTitleVerfication()
	{
		ActTitle=ProdPage.getPageTitle();
		Assert.assertEquals(ActTitle, Constants.PRODUCTS_PAGE_TITLE);
	}

	
	@Description("Test Case- Verification of Breadcrumb on Products Page")
	@Test (priority=4)
	public void BreadCrumbVerification()
	{
		
		B=ProdPage.BreadCrumbIsPresent();
		Assert.assertTrue(B);
	}
	
	
	@Description("Test Case- Verification of Ampere Support link on Products Page")
	@Test (priority=5)
	public void AmpereSupportLinkVerification()
	{
		
		B=ProdPage.AmpereSupportLinkVerification();
		Assert.assertTrue(B);
	}
	
	
	@Description("Test Case- Verification of clicking the Ampere Support Link on Products Page")
	@Test (priority=6)
	public void AmpereTechSupprtLink()
	   {   String regtitle = ProdPage.AmpereSupportLinkClick();
		   Assert.assertEquals(regtitle, Constants.HELP_PAGE_TITLE);
	   }
	
	
	@Description("Test Case - Verification of Search functionality")
	@Test (priority=7)
	public void SearchFucntionalityCheck() throws InterruptedException
	{
		String searchstring=prop.getProperty("searchstring");
		B=ProdPage.SearchFunctionality(searchstring);
		
		Assert.assertTrue(B);
		
	}
	
	@Description("Test Case - Verification of whether Product Family is present on Product Page")
	@Test (priority=8)
	public void ProductFamily() throws InterruptedException
	{
		B=ProdPage.ProductFamilyIsPresent();		
		Assert.assertTrue(B);
		
	}
	
	@Description("Test Case - Verification of whether Product Categories are present on Product Page")
	@Test (priority=9)
	public void ProductCategory() throws InterruptedException
	{
		
		B=ProdPage.ProductCategoryIsPresent();		
		Assert.assertTrue(B);
		
	}
	
	@Description("Test Case - Verification of whether Products are present on Product Page")
	@Test (priority=10)
	public void Product() throws InterruptedException
	{
		ProdPage.ExpandProductCategory();
		Thread.sleep(5000);
		B=ProdPage.ProductsArePresent();		
		Assert.assertTrue(B);
		
	}
	
}
