package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class IndividualSoftwareDesignFilesPage {

	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	boolean b;
	
	
	
	public IndividualSoftwareDesignFilesPage(WebDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);
	}
	
	
	By HeroImage=By.xpath("(//img)[4]");
	By TextOnImage=By.xpath("(//p[@class='chakra-text css-bxak8j'])[1]");
	By BreadCrumbIsPresent=By.xpath("//div[@class='css-70qvj9']");
	By SWPackageDetails=By.xpath("//div[@class='css-1oihjr8']");
	By NameOfFile=By.xpath("//span[@class='css-4g6ai3']");
	By SizeOfFile=By.xpath("//td[@class='css-1rakw7v']");
	By TypeOfFile=By.xpath("//td[@class='css-19i0o2u']");
    By DownloadStartedMsg=By.xpath("//div[@class='chakra-modal__body css-qlig70']");
    By DownloadCloseButton=By.xpath("//button[@class='chakra-button css-1vmtlsn']");
    

    public boolean HeroImageIsPresent()
   	{
   		return eleUtil.getElement(HeroImage).isDisplayed();
   		
   	}

    
    public boolean TextOnImageIsPresent()
    {
    	return eleUtil.getElement(TextOnImage).isDisplayed();
    }
    
    
    public String TextOnImageVerification()
    {
    	
    	
    	return eleUtil.getElement(TextOnImage).getText();
    	
    }
    
    
    public boolean BreadCrumbIsPresent()
    {
    	
    	return eleUtil.getElement(BreadCrumbIsPresent).isDisplayed();
    }

    public boolean SoftwarePackageDeatilsArePresent()
    {
    	
    	return eleUtil.getElement(SWPackageDetails).isDisplayed();
    }
	
    public boolean FileNameIsPresent()
    {
    	
    	return eleUtil.getElement(NameOfFile).isDisplayed();
    }
    
    public boolean FileTypeIsPresent()
    {
    	
    	return eleUtil.getElement(TypeOfFile).isDisplayed();
    }
  
    public boolean FileSizeIsPresent()
    {
    	
    	return eleUtil.getElement(SizeOfFile).isDisplayed();
    }
    
    public String FileClickForDownload() throws InterruptedException
    {    
    	eleUtil.windowMaximise();
		String ExpectedFileName=eleUtil.getElement(NameOfFile).getText();
		eleUtil.getElement(NameOfFile).click();
		 Thread.sleep(1000);
		 eleUtil.windowMaximise();
		 Thread.sleep(20000);
		 ClickingCloseButton();
		 
		 System.out.println("Name of the File to be Downloaded:" + ExpectedFileName);
		 return ExpectedFileName;
		 
    }
    
    
    public void ClickingCloseButton() throws InterruptedException
	{ 
	  
	  String downloadmessage=eleUtil.getElement(DownloadStartedMsg).getText();
	  
		if (downloadmessage.equalsIgnoreCase(Constants.DOWNLOAD_MESSAGE_FOR_FILE)) {
		     if (eleUtil.getElement(DownloadCloseButton).isDisplayed()) {
				eleUtil.getElement(DownloadCloseButton).click();
				Thread.sleep(3000);
			}	
		}
	}
}
