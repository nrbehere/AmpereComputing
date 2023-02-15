package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class IndividualTechnicalBulletinPage {

	WebDriver driver;
	Properties prop;
	ElementUtil eleUtil;
    boolean b;
    
    
    By HeroImage=By.xpath("(//img)[4]");
	By TextOnImage=By.xpath("//p[@class='chakra-text css-bxak8j'][1]");
	By BreadCrumbIsPresent=By.xpath("//div[@class='css-70qvj9']");
	By NameOfFile=By.xpath("//div[@class='css-1h144jh']");
	By RelDateOfFile=By.xpath("//div[@class='css-1y6ic72'][1]");
	By SizeOfFile=By.xpath("(//div[@class='css-1y6ic72'])[2]");
	By TypeOfFile=By.xpath("(//div[@class='css-1y6ic72'])[3]");
    By DownloadButton=By.xpath("//button[@class='chakra-button css-19d2qy']");
    By DownloadStartedMsg=By.xpath("//div[@class='chakra-modal__body css-qlig70']");
    By DownloadCloseButton=By.xpath("//button[@class='chakra-button css-1vmtlsn']");
    
    public IndividualTechnicalBulletinPage(WebDriver driver, Properties prop) {
	
    	this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);
	}


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

    
    public boolean NameOfFileIsPresent()
    {
    	return eleUtil.getElement(NameOfFile).isDisplayed();
    }
    
      public boolean SizeOfFileIsPresent()
    {
    	return eleUtil.getElement(SizeOfFile).isDisplayed();
    }
    
    public boolean TypeOfFileIsPresent()
    {
    	return eleUtil.getElement(TypeOfFile).isDisplayed();
    }

    public boolean DownloadButtonIsPresent()
    {
    	return eleUtil.getElement(DownloadButton).isDisplayed();
    }


	public Boolean RelDateOfFileIsPresent() {
		
		return eleUtil.getElement(RelDateOfFile).isDisplayed();
	}

	 
    public String DownloadButtonClick() throws InterruptedException
	{
		 eleUtil.windowMaximise();
		 String ExpectedFileName=eleUtil.getElement(NameOfFile).getText();
		 eleUtil.getElement(DownloadButton).click();
		 Thread.sleep(1000);
		 eleUtil.windowMaximise();
		 Thread.sleep(10000);
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
