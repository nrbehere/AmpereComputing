package ampere.qa.customerconnect.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class ProductsPage {

	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	boolean b;
	private List<WebElement> ele;
	private int i;

	public ProductsPage(WebDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);
	}

	private By HeroImage = By.xpath("(//img)[3]");
	private By TextOnImage = By.xpath("(//p[@class='chakra-text css-bxak8j'])[1]");
	private By BreadcrumbOnPage = By.xpath("//div[@class='css-70qvj9']");
	private By TextBelowBreadCrumb = By.xpath("//div[@class='css-x6j8jq']//div[@class='css-0']");
	private By SearchBar = By.xpath("//input[@class='chakra-input css-ix76ss']");
	private By AmpereTechSupportLink = By.xpath("//div[@class='css-x6j8jq']//div[@class='css-0']//a");
	private By ProductFamily = By.xpath("//div[@class='css-1urlnhj']");
	private By ProductCategory = By.xpath("//div[@class='css-1yhb4b0']");
	private By Products = By.xpath("//div[@class='css-1lbcusb']//a");
	private By AcceptAllButton = By.xpath("//button[@class='chakra-button css-n9n0wy']");
	private By SearchButton=By.xpath("//div[@class='css-1qn3gz2']");
	private By SearchResultTitles=By.xpath("//div[@class='css-1flyc9m']");


	public boolean HeroImageIsPresent() {
		eleUtil.windowMaximise();
		return eleUtil.getElement(HeroImage).isDisplayed();

	}

	public String getPageTitle() {
		driver.manage().window().maximize();
		return eleUtil.doGetTitle(Constants.PRODUCTS_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	}

	public String getTextOnImage() {
		return eleUtil.getElement(TextOnImage).getText();
	}

	public boolean BreadCrumbIsPresent() {
		eleUtil.windowMaximise();
		return eleUtil.getElement(BreadcrumbOnPage).isDisplayed();

	}

	public boolean TextBelowBreadCrumbIsPresent() {
		eleUtil.windowMaximise();
		return eleUtil.getElement(TextBelowBreadCrumb).isDisplayed();

	}

	public boolean SearchBarIsPresent() {
		eleUtil.windowMaximise();
		return eleUtil.getElement(SearchBar).isDisplayed();

	}

	public boolean ProductFamilyIsPresent() {
		eleUtil.windowMaximise();
		ele = eleUtil.getElements(ProductFamily);
		i = ele.size();
		System.out.println("Number of Product Faimly in Product Card:  " + i);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ProductCategoryIsPresent() {
		eleUtil.windowMaximise();
		eleUtil.doMoveToElement(ProductCategory);
		ele = eleUtil.getElements(ProductCategory);
		i = ele.size();
		System.out.println("Number of Product Category in Product Card:  " + i);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void ExpandProductCategory() throws InterruptedException {
		eleUtil.windowMaximise();
		eleUtil.doMoveToElement(ProductCategory);
		ele = eleUtil.getElements(ProductCategory);
		for (int i = 0; i < ele.size(); i++) {
			ele.get(i).click();
			Thread.sleep(1000);

		}
	}

	public boolean ProductsArePresent() throws InterruptedException {
		eleUtil.windowMaximise();
		Thread.sleep(5000);
		ele = eleUtil.getElements(Products);
		i = ele.size();

		if (i > 0) {
			System.out.println("Number of Products- " + i );
			return true;
		} else {
			return false;
	

	   }
	}		

	public IndividualProductPage IndividualProductPageSetup() throws InterruptedException {
		 eleUtil.windowMaximise();
		 ExpandProductCategory();
		 ele=eleUtil.getElements(Products);
		 int i=ele.size();
		 Random r=new Random();
		 int randomFile=r.nextInt(i);
		 
		 System.out.println("Random File Number-" +randomFile);
		 String ExpectedFileName= ele.get(randomFile).getText();
		 System.out.println("Random Product clicked: "+ ExpectedFileName);
		 
		 randomFile=randomFile+1;
		 By ProductSelected= By.xpath("(//div[@class='css-1lbcusb']//a)["+randomFile+"]");
		 eleUtil.doMoveToElement(ProductSelected);
		 Thread.sleep(2000);
		 eleUtil.getElement(ProductSelected).click();
		 Thread.sleep(2000);
		 eleUtil.doGetTitle(ExpectedFileName, Constants.DEFAULT_TIMEOUT );
				
		return new IndividualProductPage(driver,prop,ExpectedFileName);
      
	}

	 
	public void CookiesAcceptAllClick()
	{
	   b=eleUtil.getElement(AcceptAllButton).isDisplayed();	
	   
	   if (b) {
		   eleUtil.getElement(AcceptAllButton).click();
		
	   }
	   
	}

	
	
	public Boolean SearchFunctionality(String searchstring) throws InterruptedException
	{  
		CookiesAcceptAllClick();
		b=false;
		eleUtil.getElement(SearchBar).sendKeys(searchstring);
		Thread.sleep(2000);
		eleUtil.getElement(SearchButton).click();
		Thread.sleep(5000);
		eleUtil.doGetTitle(Constants.SEARCH_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		
		List<WebElement> ele;
		ele=eleUtil.getElements(SearchResultTitles);
		
		
		for (int i = 0; i < ele.size(); i++)
		{
			String ResultTitle=ele.get(i).getText();
			ResultTitle=ResultTitle.toLowerCase();
			System.out.println("Search Result tite: " + ResultTitle);
		  	if (ResultTitle.contains(searchstring)) {
		  		
				b=true;
			}
		  	else
		  	{
		  		b=false;
		  		break;
		  	}
			
		}
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		
		return b;
	}

	public Boolean AmpereSupportLinkVerification() {
		
		return eleUtil.getElement(AmpereTechSupportLink).isDisplayed();
	}
	
		public String AmpereSupportLinkClick()
	{
		String title;
		eleUtil.doClick(AmpereTechSupportLink);
		title= eleUtil.doGetTitle(Constants.HELP_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		driver.navigate().back();
		eleUtil.waitForTitleContains(Constants.PRODUCTS_PAGE_TITLE,Constants.DEFAULT_TIMEOUT);
		return title;

	}

	
}
