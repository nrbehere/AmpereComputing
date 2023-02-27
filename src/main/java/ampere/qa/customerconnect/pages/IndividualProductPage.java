package ampere.qa.customerconnect.pages;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class IndividualProductPage {

	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	private Boolean b;
	private List<WebElement> ele;
	String ProductName;

	public IndividualProductPage(WebDriver driver, Properties prop, String expectedFileName) {
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);
		ProductName=expectedFileName;

	}


	By WMNote = By.xpath("//ul//li[1]");
	By PPnote = By.xpath("(//ul//li)[2]");
	By BreadCrumb=By.xpath("//div[@class='css-8qnvhm']");
	By TblColTitle = By.xpath("(//tr[@class='css-9xnlic']//th)[1]");
	By TblColRev = By.xpath("(//tr[@class='css-9xnlic']//th)[2]");
	By TblColDate = By.xpath("(//tr[@class='css-9xnlic']//th)[3]");
	By TblColType = By.xpath("(//tr[@class='css-9xnlic']//th)[4]");
	By TblColSize = By.xpath("(//tr[@class='css-9xnlic']//th)[5]");
	By ProductList = By.xpath("((//tbody)[1]//tr[@class='css-6minc1'])//td[@class='css-1xokikm']");
	By ProductNameDisplayedOnPage=By.xpath("//h2[@class='chakra-text css-1cglmtu']");
	By LastElementOfBreadCrumb = By.xpath("(//li[@class='chakra-breadcrumb__list-item css-1av8uke'])[4]");
	By ContactOurSalesTeam = By.xpath("//a[@class='chakra-link css-1wlkiue']");
	By ContactOurProdSuppTeam = By.xpath("//a[@class='chakra-link css-1m215su']");
	By GotToAllProducts = By.xpath("//a[@class='chakra-button css-q9s9te']");
	By MoreAboutPassword = By.xpath("//button[@class='chakra-button css-q9s9te']");
	By UserProfileLink = By.xpath("//span[@class='css-5txzso']");
	By DownloadStartedMessage = By.xpath("//div[@class='chakra-modal__body css-qlig70']");
	By CloseButton = By.xpath("//button[@class='chakra-button css-1vmtlsn']");
	private By AcceptAllButton = By.xpath("//button[@class='chakra-button css-n9n0wy']");

	
	public Boolean waterMarkNoteIsPresent() {

		return eleUtil.getElement(WMNote).isDisplayed();

	}

	public Boolean PasswordProtectionNoteIsPresent() {

		return eleUtil.getElement(PPnote).isDisplayed();
	}

	
	
	public Boolean TitleColumnIsPresent() {

		return eleUtil.getElement(TblColTitle).isDisplayed();

	}

	
	
	
	public void ExpandCollapseOfMoreAboutPassword() {
		// todo
	}

	public void UserProfileLinkClick() {
		// to do
	}

	public void GoToAllProductsClick() {
		// to do
	}

	public Boolean ProductNameDisplayedOnPageVerification()
	{
		return eleUtil.getElement(ProductNameDisplayedOnPage).isDisplayed();
	}
	
	
	
	public String ContactOurSalesTeamClick() {
		
		String title;
		eleUtil.doClick(ContactOurSalesTeam);
		
		eleUtil.waitForTitleContains(Constants.CONTACT_SALES, Constants.DEFAULT_TIMEOUT);
		title=driver.getTitle();
		driver.navigate().back();
		eleUtil.waitForTitleContains(ProductName,Constants.DEFAULT_TIMEOUT);
		return title;	
		
	}

	public String ContactOurProductSuppTeamClick() {
		String title;
		eleUtil.doClick(ContactOurProdSuppTeam);
		title= eleUtil.doGetTitle(Constants.HELP_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		driver.navigate().back();
		eleUtil.waitForTitleContains(ProductName,Constants.DEFAULT_TIMEOUT);
		return title;	
			
	}

	public String RandomFileSelectionForDownload() throws InterruptedException {
		eleUtil.windowMaximise();
		String ExpectedFileName="No Files to Download under this Products";
		ele = eleUtil.getElements(ProductList);
		int i = ele.size();
        if (i>0)
        {  	
		Random r = new Random();

		int randomFile = r.nextInt(i);
		System.out.println("Random File Number-" + randomFile);

		ExpectedFileName = ele.get(randomFile).getText();
		System.out.println("Technical Bulletin clicked: " + ExpectedFileName);

		randomFile = randomFile + 1;
		By ProductSelected = By.xpath("(((//tbody)[1]//tr[@class='css-6minc1'])//td[@class='css-1xokikm'])[" + randomFile + "]");
		eleUtil.doMoveToElement(ProductSelected);
		Thread.sleep(1000);
		eleUtil.getElement(ProductSelected).click();
		Thread.sleep(1000);
		eleUtil.windowMaximise();
		Thread.sleep(10000);
		ClickingCloseButton();
        }
        else
        	System.out.println("Product has no Files to download");
	
        return ExpectedFileName;

	}

	public void ClickingCloseButton() throws InterruptedException {
		// driver.switchTo().frame(eleUtil.getElement(DownloadStartedMessage));
		String downloadmessage = eleUtil.getElement(DownloadStartedMessage).getText();

		if (downloadmessage.equalsIgnoreCase(Constants.DOWNLOAD_MESSAGE_FOR_FILE)) {
			if (eleUtil.getElement(CloseButton).isDisplayed()) {
				eleUtil.getElement(CloseButton).click();
				Thread.sleep(3000);
			}
		}
	}

	public Boolean PageTitle() {
		String title=eleUtil.doGetTitle(ProductName, Constants.DEFAULT_TIMEOUT);
		if (title.equalsIgnoreCase(ProductName)) {
			return true;
		} else {
            return false;  
		}
		}

	public Boolean BreadCrumbIsPresent() {
		
		return  eleUtil.getElement(BreadCrumb).isDisplayed();
	}

	public Boolean RevisionColumnIsPresent() {

		return eleUtil.getElement(TblColRev).isDisplayed();
	}

	public Boolean DateColumnIsPresent() {
		return eleUtil.getElement(TblColDate).isDisplayed();
	}

	public Boolean TypeColumnIsPresent() {
		
		return eleUtil.getElement(TblColType).isDisplayed();
	}

	public Boolean SizeColumnIsPresent() {
		
		return eleUtil.getElement(TblColSize).isDisplayed();
	}

	public Boolean MoreAboutThePasswordOnPageVerification() throws InterruptedException {
		
		eleUtil.getElement(MoreAboutPassword).click();
		Thread.sleep(2000);
		eleUtil.getElement(MoreAboutPassword).click();
		return eleUtil.getElement(MoreAboutPassword).isDisplayed();
	}

	public String GoToAllProductsVerification() {
		String title;
		eleUtil.doClick(GotToAllProducts);
		title= eleUtil.doGetTitle(Constants.PRODUCTS_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
		driver.navigate().back();
		eleUtil.waitForTitleContains(ProductName,Constants.DEFAULT_TIMEOUT);
		return title;	
			}

	
	
	
}