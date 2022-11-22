package ampere.qa.customerconnect.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class TechnicalDocumentUpdatesPage {
	
	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	Boolean b;
	
	
	public TechnicalDocumentUpdatesPage(WebDriver driver, Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);	
		
	}

	
	By HeroImage=By.xpath("//img[@alt='Hero Image']");
	By TextOnImage=By.xpath("//p[@class='chakra-text css-bxak8j']");
	By WMNote=By.xpath("//div[@class='css-12mhks'][1]");
    By PPnote=By.xpath("(//div[@class='css-12mhks'])[2]");
    By TblColTitle=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[1]");
    By TblColType=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[2]");
    By TblColRev=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[3]");
    By TblColDate=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[4]");
    By TblColFile=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[5]");
    By TblColSize=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[6]");
	By FileLinkList=By.xpath("//tr[@class='css-6minc1']//td[@class='css-qlm1eq']");
    
    
    public boolean HeroImageIsPresent()
	{
		return eleUtil.getElement(HeroImage).isDisplayed();
		
	}
    
    
    public String getPageTitle() 
    {
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
    
	
	
}
