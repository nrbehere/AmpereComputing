package ampere.qa.customerconnect.pages;

import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class IndividualTechDocPage {
	
	WebDriver driver;
	Properties prop;
	ElementUtil eleUtil;
    boolean b;
	
	public IndividualTechDocPage(WebDriver driver, Properties prop) {
	  
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);
	
	}
	
	
	By HeroImage=By.xpath("(//img)[4]");
	By TextOnImage=By.xpath("(//p[@class='chakra-text css-bxak8j'])[1]");
	By BreadCrumbIsPresent=By.xpath("//div[@class='css-8qnvhm']");
	By NameOfFile=By.xpath("(//div[@class='css-1k5c75w'])[1]");
	By RevOfFile=By.xpath("(//div[@class='css-1k5c75w'])[2]");
	By RelDateOfFile=By.xpath("(//div[@class='css-1k5c75w'])[3]");
	By SizeOfFile=By.xpath("(//div[@class='css-1k5c75w'])[4]");
	By TypeOfFile=By.xpath("(//div[@class='css-1k5c75w'])[5]");
    By DownloadButton=By.xpath("//span[@class='css-4g6ai3']");
    By DownloadStartedHeader=By.xpath("//header[@id='chakra-modal--header-:r8v:']");
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



    public boolean NameOfFileIsPresent()
    {
    	return eleUtil.getElement(NameOfFile).isDisplayed();
    }


    public boolean RevOfFileIsPresent()
    {
    	return eleUtil.getElement(RevOfFile).isDisplayed();
    }
    
    
    public boolean RelDateOfFileIsPresent()
    {
    	return eleUtil.getElement(RelDateOfFile).isDisplayed();
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
