package ampere.qa.customerconnect.pages;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class TechnicalBulletinPage {

	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	boolean b;
		
	public TechnicalBulletinPage(WebDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);
	}

	private By HeroImage= By.xpath("(//img)[4]");
	private By TextOnImage=By.xpath("//p[@class='chakra-text css-bxak8j']");
	private By WMNote=By.xpath("//div[@class='css-sn9nxz']");
	private By TechBulletinList=By.xpath("//span[@class='css-4g6ai3']");
	private By DownloadStartedHeader=By.xpath("//header[@id='chakra-modal--header-:r36:']");
	private By DownloadStartedMessage=By.xpath("//div[@class='chakra-modal__body css-qlig70']");
	private By CloseButton=By.xpath("//button[@class='chakra-button css-1vmtlsn']");
	private By WMInsideTheFileList=By.xpath("//span[@class='css-4fmzj6']");

	List<WebElement> ele; 
	public boolean HeroImageIsPresent()
	{
		eleUtil.windowMaximise();
		return eleUtil.getElement(HeroImage).isDisplayed();
		
	}

	public String getTextOnImage()
	{
		String text;
		text=eleUtil.doGetText(TextOnImage);
		return text;
	}

	
	public String getPageTitle()
	{
		return eleUtil.doGetTitle(Constants.TECH_BULLETIN_TITLE, Constants.DEFAULT_TIMEOUT);
	}

	
	public boolean isWaterMarkNotePresent()
	{
		return  eleUtil.getElement(WMNote).isDisplayed();
	}
	
	
	
	
	public boolean IsWaterMarkPresentInFile()
	{
		String WMtext;
		ele=eleUtil.getElements(WMInsideTheFileList);
		eleUtil.doMoveToElement(WMInsideTheFileList);
		
		
		for (int i = 0; i < ele.size(); i++) {
			WMtext=ele.get(i).getText();
			WMtext=WMtext.toUpperCase();
			if (WMtext.contains("( W )")) {
				b=true;
				
			} else {
                b=false;
                break;
             }
		}
		
		return b;
	}
	
	
	
	

	
	
	public String RandomFileSelectionForDownload() throws InterruptedException
	{
		 eleUtil.windowMaximise();
		 ele=eleUtil.getElements(TechBulletinList);
		 int i=ele.size();
		 
		 Random r= new Random();
		 
		 int randomFile=r.nextInt(i);
         System.out.println("Random File Number-" +randomFile);
		 
		 String ExpectedFileName= ele.get(randomFile).getText();
		 System.out.println("Technical Bulletin clicked: "+ ExpectedFileName);
		 
		 randomFile=randomFile+1;
		 By TechBulletinSelected= By.xpath("(//span[@class='css-4g6ai3'])["+randomFile+"]");
		 eleUtil.doMoveToElement(TechBulletinSelected);
		 Thread.sleep(1000);
		 eleUtil.getElement(TechBulletinSelected).click();
		 Thread.sleep(1000);
		 eleUtil.windowMaximise();
		 Thread.sleep(10000);
		 ClickingCloseButton();
		 
		 return ExpectedFileName;
		  	 
				 
	}
	
	public void ClickingCloseButton() throws InterruptedException
	{ 
	  //driver.switchTo().frame(eleUtil.getElement(DownloadStartedMessage));
	  String downloadmessage=eleUtil.getElement(DownloadStartedMessage).getText();
	  
		if (downloadmessage.equalsIgnoreCase(Constants.DOWNLOAD_MESSAGE_FOR_FILE)) {
		     if (eleUtil.getElement(CloseButton).isDisplayed()) {
				eleUtil.getElement(CloseButton).click();
				Thread.sleep(3000);
			}	
		}
		
	}

	
		
}
