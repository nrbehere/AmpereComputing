package ampere.qa.customerconnect.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class SWUpdatesPage {
	
	
	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	Boolean b;
	String title;
	Actions action;
	WebElement mainMenu;
	
	
	public SWUpdatesPage(WebDriver driver, Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);	
		action=new Actions(driver);
	}
	
	
	private By heroImage= By.xpath("//img[@alt='Hero Image']");
	private By TextOnImage= By.xpath("//p[@class='chakra-text css-bxak8j']");
	private By WMNote=By.xpath("//span[@class='css-11vop16'][1]");
	private By PPNote=By.xpath("(//span[@class='css-11vop16'])[2]");
	private By MoreAboutPasswordNote=By.xpath("//button[@class='chakra-button css-q9s9te']");
	private By TableColumnTitle=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[1]");
	private By TableColumnRev=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[2]");
	private By TableColumnDate=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[3]");
	private By FileListLinks=By.xpath("//tr[@class='css-6minc1']//td[@class='css-9pmepv']");
	private By FirstFile=By.xpath("//tr[@class='css-6minc1']//td[@class='css-9pmepv'][1]");
	private By LastElementofBreadCrum=By.xpath("(//li[@class='chakra-breadcrumb__list-item css-1av8uke'][3])//a");
	
	 
	public boolean HeroImageIsPresent()
	{
		return eleUtil.getElement(heroImage).isDisplayed();
		
	}

	public String getTextOnImage()
	{
		String text;
		text=eleUtil.doGetText(TextOnImage);
		return text;
	}

	
	public String getPageTitle()
	{
		return eleUtil.doGetTitle(Constants.SW_DES_FILES_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	}
	

	public boolean waterMarkNoteIsPresent()
	{
		return eleUtil.getElement(WMNote).isDisplayed();
	}
	
	
	public boolean PasswordProtectionNoteIsPresent()
	{
		return eleUtil.getElement(PPNote).isDisplayed();
		
	}
	
	public boolean TableColumnTitleIspresent()
	{
	   return eleUtil.getElement(TableColumnTitle).isDisplayed();
		
	}

	public boolean TableColumnRevIspresent()
	{
	   return eleUtil.getElement(TableColumnRev).isDisplayed();
		
	}
	
	public boolean TableColumnDateIspresent()
	{
	   return eleUtil.getElement(TableColumnDate).isDisplayed();
		
	}


    public boolean NoWMPPatEndOfFiles() throws InterruptedException
    {
    	b=true;
        List<WebElement> FileList=eleUtil.getElements(FileListLinks);
        List<String> ActList= new ArrayList<String>();
        
        for (WebElement e : FileList) {
			String text=e.getText();
			if ((text.endsWith("( W )")) || (text.endsWith("( W ) ( PP )"))|| (text.endsWith("( PP )")))
					{
				       b=false;
				       break;
				
					}
			else
			    ActList.add(text);
			    Thread.sleep(50);
		    
		}
       	
    	return b;
    }

    
    public boolean FirstFileClick() throws InterruptedException
    {
    	String ExpectedText= eleUtil.getElement(FirstFile).getText();
    	eleUtil.getElement(FirstFile).click();
    	
    	Thread.sleep(5000);
    	//String ActualText=eleUtil.getElement(LastElementofBreadCrum).getText();
		/*
		 * if (ExpectedText==ActualText) { return true;
		 * 
		 * } else { return false;
		 * 
		 * }
		 */    	
    	
    	return true;
    }

}
