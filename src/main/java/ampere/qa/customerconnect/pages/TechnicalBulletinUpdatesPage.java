package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class TechnicalBulletinUpdatesPage {

	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;

	public TechnicalBulletinUpdatesPage(WebDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;
		eleUtil = new ElementUtil(driver);
	}

	
	private By HeroImage=By.xpath("//img[@alt='Hero Image']");
	private By TextOnImage=By.xpath("//p[@class='chakra-text css-bxak8j']");
	private By WMnote=By.xpath("//div[@class='css-a8d674']");
	private By TableColumnTitle=By.xpath("//tr[@class='css-9xnlic']//th[@class='css-16921gd']");
	private By TableColumnType=By.xpath("//tr[@class='css-9xnlic']//th[@class='css-19olkif'][1]");
	private By TableColumnDate=By.xpath("//tr[@class='css-9xnlic']//th[@class='css-19olkif'][2]");
	private By TableColumnFile=By.xpath("//tr[@class='css-9xnlic']//th[@class='css-19olkif'][3]");
	private By TableColumnSize=By.xpath("//tr[@class='css-9xnlic']//th[@class='css-19olkif'][4]");
	private By FirstFile=By.xpath("//td[@class='css-9pmepv'][1]");
	private By FirstFileLink=By.xpath("//td[@class='css-9pmepv'][1]//a[1]");
	private By LastElementofBreadCrum=By.xpath("//li[3]//a");
	
	public boolean HeroImageIsPresent()
	{
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
		return eleUtil.doGetTitle(Constants.TECH_BULLETIN_UPDATE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	}

	public boolean waterMarkNoteIsPresent()
	{
		return eleUtil.getElement(WMnote).isDisplayed();
	}
	
	public boolean TableColumnTitleIspresent()
	{
	   return eleUtil.getElement(TableColumnTitle).isDisplayed();
		
	}
	
	public boolean TableColumnTypeIspresent()
	{
	   return eleUtil.getElement(TableColumnType).isDisplayed();
		
	}
	
	public boolean TableColumnDateIspresent()
	{
	   return eleUtil.getElement(TableColumnDate).isDisplayed();
		
	}
	
	public boolean TableColumnFileIspresent()
	{
	   return eleUtil.getElement(TableColumnFile).isDisplayed();
		
	}
	
	public boolean TableColumnSizeIspresent()
	{
	   return eleUtil.getElement(TableColumnSize).isDisplayed();
		
	}

    
	public boolean FirstFileClick() throws InterruptedException
    {   
    	boolean b = false;
    	eleUtil.doActionMoveToElementClick(FirstFile);
    	String ExpectedText= eleUtil.getElement(FirstFile).getText();
    	if (ExpectedText.contains("( W )"))
    	  ExpectedText=ExpectedText.replace("( W )", "  ");
    	  
    	ExpectedText=ExpectedText.trim();  
    	    
    	System.out.println("Expected File Name: "+ExpectedText );
    	eleUtil.doClick(FirstFileLink); 
     	Thread.sleep(2000);
     	eleUtil.windowMaximise();
	    String ActualText=eleUtil.getElement(LastElementofBreadCrum).getText();
		ActualText.trim();
	    System.out.println("Actual File Name: " + ActualText);
	    if (ExpectedText.equals(ActualText)) {
			b=true;
		} 
		  eleUtil.PageBack();
		  Thread.sleep(2000);
		
		  return b;
       }

	
}
