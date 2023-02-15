package ampere.qa.customerconnect.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class TechnicalDocumentUpdatesPage {
	
	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
    private	Boolean b;
    private List<WebElement> ele;
    
    
	
	public TechnicalDocumentUpdatesPage(WebDriver driver, Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);	
		
	}

	
	By HeroImage=By.xpath("(//img)[4]");
	By TextOnImage=By.xpath("//p[@class='chakra-text css-bxak8j']");
	By WMNote=By.xpath("//span[@class='css-12mhks'][1]");
    By PPnote=By.xpath("(//span[@class='css-12mhks'])[2]");
    By TblColTitle=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[1]");
    By TblColType=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[2]");
    By TblColRev=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[3]");
    By TblColDate=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[4]");
    By TblColFile=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[5]");
    By TblColSize=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[6]");
	By TechDocList=By.xpath("//tr[@class='css-6minc1']//a");
	By LastElementOfBreadCrumb=By.xpath("(//li[@class='chakra-breadcrumb__list-item css-1av8uke'])[4]//a");
    
   
    public boolean HeroImageIsPresent()
	{
		return eleUtil.getElement(HeroImage).isDisplayed();
		
	}
    
    
    public String getPageTitle() 
    { 
    	driver.manage().window().maximize();
    	return eleUtil.doGetTitle(Constants.TECH_DOC_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
    }
    
    
    public String getTextOnImage()
    {
    	return eleUtil.getElement(TextOnImage).getText();
    }


	public Boolean waterMarkNoteIsPresent() {
		
		return eleUtil.getElement(WMNote).isDisplayed();
		
	}


	public Boolean PasswordProtectionNoteIsPresent() {
		
		return eleUtil.getElement(PPnote).isDisplayed();
	}


	public Boolean TableColumnTitleIspresent() {
		
		return eleUtil.getElement(TblColTitle).isDisplayed();
	}


	public Boolean TableColumnTypeIspresent() {
		
		return eleUtil.getElement(TblColType).isDisplayed();
	}


	public Boolean TableColumnRevIspresent() {
		
		return eleUtil.getElement(TblColRev).isDisplayed();
	}


	public Boolean TableColumnDateIspresent() {
		
		return eleUtil.getElement(TblColDate).isDisplayed();
	}


	public Boolean TableColumnFileIspresent() {
		
		return eleUtil.getElement(TblColFile).isDisplayed();
	}


	public Boolean TableColumnSizeIspresent() {
		
		return eleUtil.getElement(TblColSize).isDisplayed();
	}
    
	
	
	public boolean TechDocClick() throws InterruptedException
	{
		 eleUtil.windowMaximise();
		 
		 ele=eleUtil.getElements(TechDocList);
		 int i=ele.size();
		 
		 Random r=new Random();
		 
		 int randomFile=r.nextInt(i);
		 
		 System.out.println("Random File Number-" +randomFile);
		 
		 String ExpectedFileName= ele.get(randomFile).getText();
		 System.out.println("Technical Document clicked: "+ ExpectedFileName);
		 
		 randomFile=randomFile+1;
		 By TechDocSelected= By.xpath("(//tr[@class='css-6minc1']//a)["+randomFile+"]");
		 eleUtil.doMoveToElement(TechDocSelected);
		 Thread.sleep(2000);
		 eleUtil.getElement(TechDocSelected).click();
		 Thread.sleep(2000);
		 eleUtil.windowMaximise();
		 String ActualFileName=eleUtil.getElement(LastElementOfBreadCrumb).getText();
		 System.out.println("Technical Document opened: "+ ActualFileName);
		 Thread.sleep(3000);
		 if (ExpectedFileName.equalsIgnoreCase(ActualFileName)) {
			driver.navigate().back(); 
			Thread.sleep(3000);
			return true;
		} else {
			driver.navigate().back();
			Thread.sleep(3000);
	        return false;
		}
		 
	 }
	
	
	public IndividualTechDocPage IndividualTechDocPageSetup() throws InterruptedException
	{
		 eleUtil.windowMaximise();
		 
		 ele=eleUtil.getElements(TechDocList);
		 int i=ele.size();
		 
		 Random r=new Random();
		 
		 int randomFile=r.nextInt(i);
		 
		 System.out.println("Random File Number-" +randomFile);
		 
		 String ExpectedFileName= ele.get(randomFile).getText();
		 System.out.println("Random Technical Document clicked: "+ ExpectedFileName);
		 
		 randomFile=randomFile+1;
		 By TechDocSelected= By.xpath("(//tr[@class='css-6minc1']//a)["+randomFile+"]");
		 eleUtil.doMoveToElement(TechDocSelected);
		 Thread.sleep(2000);
		 eleUtil.getElement(TechDocSelected).click();
		 Thread.sleep(2000);
		 eleUtil.doGetTitle(Constants.TECH_DOC_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT );
		 return new IndividualTechDocPage(driver,prop);	
		
	}
	
}
