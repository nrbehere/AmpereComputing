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

	public IndividualProductPage(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		eleUtil = new ElementUtil(driver);

	}

	By WMNote = By.xpath("//ul//li[1]");
	By PPnote = By.xpath("(//ul//li)[2]");
	By TblColTitle = By.xpath("(//tr[@class='css-9xnlic']//th)[1]");
	By TblColRev = By.xpath("(//tr[@class='css-9xnlic']//th)[2]");
	By TblColDate = By.xpath("(//tr[@class='css-9xnlic']//th)[3]");
	By TblColType = By.xpath("(//tr[@class='css-9xnlic']//th)[4]");
	By TblColSize = By.xpath("(//tr[@class='css-9xnlic']//th)[5]");
	By ProductList = By.xpath("");
	By LastElementOfBreadCrumb = By.xpath("(//li[@class='chakra-breadcrumb__list-item css-1av8uke'])[4]");
	By ContactOurSalesTeam = By.xpath("//a[@class='chakra-link css-1wlkiue']");
	By ContactOurProdSuppTeam = By.xpath("//a[@class='chakra-link css-1m215su']");
	By GotToAllProducts = By.xpath("//a[@class='chakra-button css-q9s9te']");
	By MoreAboutPassword = By.xpath("//a[@class='chakra-button css-q9s9te']");
	By UserProfileLink = By.xpath("//span[@class='css-5txzso']");
	By DownloadStartedMessage = By.xpath("//div[@class='chakra-modal__body css-qlig70']");
	By CloseButton = By.xpath("//button[@class='chakra-button css-1vmtlsn']");

	public String getPageTitle() {
		driver.manage().window().maximize();
		// code to fetch that page title is equivalent to last breadcrumb
		return null;
		// return eleUtil.doGetTitle(Constants., Constants.DEFAULT_TIMEOUT);
	}

	public Boolean waterMarkNoteIsPresent() {

		return eleUtil.getElement(WMNote).isDisplayed();

	}

	public Boolean PasswordProtectionNoteIsPresent() {

		return eleUtil.getElement(PPnote).isDisplayed();
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

	public void ContactOurSalesTeamClick() {
		// to do
	}

	public void ContactOurProductSuppTeamClick() {
		// to do
	}

	public String RandomFileSelectionForDownload() throws InterruptedException {
		eleUtil.windowMaximise();
		ele = eleUtil.getElements(ProductList);
		int i = ele.size();

		Random r = new Random();

		int randomFile = r.nextInt(i);
		System.out.println("Random File Number-" + randomFile);

		String ExpectedFileName = ele.get(randomFile).getText();
		System.out.println("Technical Bulletin clicked: " + ExpectedFileName);

		randomFile = randomFile + 1;
		By ProductSelected = By.xpath("[" + randomFile + "]");
		eleUtil.doMoveToElement(ProductSelected);
		Thread.sleep(1000);
		eleUtil.getElement(ProductSelected).click();
		Thread.sleep(1000);
		eleUtil.windowMaximise();
		Thread.sleep(10000);
		ClickingCloseButton();

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

}