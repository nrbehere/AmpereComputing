package ampere.qa.customerconnect.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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
	
	
	private By AcceptAllCookiesButton=By.xpath("//button[@class='chakra-button css-n9n0wy']");
	private By heroImage= By.xpath("(//img)[4]");
	private By TextOnImage= By.xpath("//p[@class='chakra-text css-bxak8j']");
	private By WMNote=By.xpath("//span[@class='css-11vop16'][1]");
	private By PPNote=By.xpath("(//span[@class='css-11vop16'])[2]");
	private By MoreAboutPasswordNote=By.xpath("//button[@class='chakra-button css-q9s9te']");
	private By TableColumnTitle=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[1]");
	private By TableColumnRev=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[2]");
	private By TableColumnDate=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[3]");
	private By FileListLinks=By.xpath("//tr[@class='css-6minc1']//td[@class='css-9pmepv']");
	private By FirstFile=By.xpath("//tr[@class='css-6minc1']//td[@class='css-9pmepv'][1]");
	private By FirstFileLink=By.xpath("//tr[@class='css-6minc1']//td[@class='css-9pmepv'][1]//a[1]");
	private By LastElementofBreadCrum=By.xpath("//li[@class='chakra-breadcrumb__list-item css-1av8uke'][4]");
	private List<WebElement> ele;
	
	 
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
    	b=false;
    	eleUtil.doActionMoveToElementClick(FirstFile);
    	String ExpectedText= eleUtil.getElement(FirstFile).getText();
    	System.out.println("Expected File Name: " + ExpectedText);
    	eleUtil.doClick(FirstFileLink);
     	Thread.sleep(2000);
     	eleUtil.windowMaximise();
	    String ActualText=eleUtil.getElement(LastElementofBreadCrum).getText();
		System.out.println("Actual File Name: " + ActualText);
		if (ExpectedText.equals(ActualText)) {
			b=true;
		}
		  eleUtil.PageBack();
		  Thread.sleep(2000);
		
		  return b;
       }

    
    public void CookiesAcceptAllClick()
    {
       b=eleUtil.getElement(AcceptAllCookiesButton).isDisplayed();	
       
       if (b) {
    	   eleUtil.getElement(AcceptAllCookiesButton).click();
    	
       }
       
    }
    
    
    public IndividualSoftwareDesignFilesPage  IndividualSoftwareDesignFilesPageSetup() throws InterruptedException
    {
    	eleUtil.windowMaximise();
    	ele=eleUtil.getElements(FileListLinks);
    	int i=ele.size();
		 
		 Random r=new Random();
		 
		 int randomFile=r.nextInt(i);
		 
		 System.out.println("Random File Number-" +randomFile);
		 
		 String ExpectedFileName= ele.get(randomFile).getText();
		 System.out.println("Random Software Design clicked: "+ ExpectedFileName);
		 
		 randomFile=randomFile+1;
		 By SWDesFileSelected= By.xpath("((//tr[@class='css-6minc1']//td[@class='css-9pmepv'])//a)["+randomFile+"]");
		 eleUtil.doMoveToElement(SWDesFileSelected);
		 Thread.sleep(2000);
		 eleUtil.getElement(SWDesFileSelected).click();
		 Thread.sleep(2000);
		 eleUtil.doGetTitle(Constants.SW_DES_FILES_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT );
    	 return new IndividualSoftwareDesignFilesPage(driver,prop); 
    }
        
    
}
