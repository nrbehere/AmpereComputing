package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class ProfilePage {

	
	private WebDriver driver;
	private Properties prop;
	ElementUtil eleUtil;
	
	public ProfilePage(WebDriver driver, Properties prop) {
	
		this.driver=driver;
		this.prop=prop;
		eleUtil= new ElementUtil(driver);
		
	}


  private By HeroImage=By.xpath("//img[@alt='Hero Image']");
  private By TextOnImage=By.xpath("//p[@class='chakra-text css-bxak8j']");
  private By FormIsPresent=By.xpath("//div[@class='css-nvx1u7']");
  private By FormFieldUserId=By.xpath("//input[@name='id']");
  private By FormFieldEmail=By.xpath("//input[@name='email']");
  private By FormFieldFirstName=By.xpath("//input[@name='firstName']");
  private By FormFieldlastName=By.xpath("//input[@name='lastName']");
  private By FormFieldPhone=By.xpath("//input[@name='phone']");
  private By FormFieldCompany=By.xpath("//input[@name='company']");
  private By FormFieldDivision=By.xpath("//input[@name='division']");
  private By FormFieldTitle=By.xpath("//input[@name='title']");
  private By FormFieldComapnyAddress=By.xpath("//input[@name='companyAddress']");
  private By FormFieldCity=By.xpath("//input[@name='city']");
  private By FormFieldUsState=By.xpath("//select[@name='usState']");
  private By FormFieldZipCode=By.xpath("//input[@name='postal']");
  private By FormFieldNonUsProvince=By.xpath("//input[@name='nonUSProvince']");
  private By FormFieldCountry=By.xpath("//select[@name='country']");
  private By FormFieldLinkendinProfile=By.xpath("//input[@name='linkedinProfile']");
  private By FormFieldSubTechDoc=By.xpath("//div[@class='css-1blxii0'][1]");
  private By FormFieldSubSwPack=By.xpath("(//div[@class='css-1blxii0'])[2]");
  private By FormFieldSubTechBul=By.xpath("(//div[@class='css-1blxii0'])[3]");
  private By FormSubmitButton=By.xpath("//button[@type='submit']");
  private By AcceptAllCookiesButton=By.xpath("//button[@class='chakra-button css-n9n0wy']");
  private Boolean b;
  
  
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
		return eleUtil.doGetTitle(Constants.PROFILE_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	}

	
	public Boolean isFormPresent()
	{
		return eleUtil.getElement(FormIsPresent).isDisplayed();
		
	}

	public void CookiesAcceptAllClick()
	{
	  
	b=eleUtil.getElement(AcceptAllCookiesButton).isDisplayed();	
	   
	   if (b) {
		   eleUtil.getElement(AcceptAllCookiesButton).click();
		
	   }
	   
	}

	
	public Boolean AreProfileFieldsPresent() throws InterruptedException
	{
		eleUtil.windowMaximise();
		Thread.sleep(3000);
		CookiesAcceptAllClick();
		
		if ( eleUtil.getElement(FormFieldUserId).isDisplayed() && 
			eleUtil.getElement(FormFieldEmail).isDisplayed() && 
			eleUtil.getElement(FormFieldFirstName).isDisplayed() && 
			eleUtil.getElement(FormFieldlastName).isDisplayed() &&
			eleUtil.getElement(FormFieldPhone).isDisplayed() && 
			eleUtil.getElement(FormFieldCompany).isDisplayed() && 
			eleUtil.getElement(FormFieldDivision).isDisplayed() && 
			eleUtil.getElement(FormFieldTitle).isDisplayed() && 
			eleUtil.getElement(FormFieldComapnyAddress).isDisplayed() && 
			eleUtil.getElement(FormFieldCity).isDisplayed() && 
			eleUtil.getElement(FormFieldUsState).isDisplayed() && 
		    eleUtil.getElement(FormFieldZipCode).isDisplayed() &&
			eleUtil.getElement(FormFieldNonUsProvince).isDisplayed() &&
			eleUtil.getElement(FormFieldCountry).isDisplayed() &&
			eleUtil.getElement(FormFieldLinkendinProfile).isDisplayed() &&
			eleUtil.getElement(FormFieldSubTechDoc).isDisplayed() &&
			eleUtil.getElement(FormFieldSubSwPack).isDisplayed() && 
			eleUtil.getElement(FormFieldSubTechBul).isDisplayed() && 
			eleUtil.getElement(FormSubmitButton).isDisplayed() )
				
			return true;
	
		else
			return false;
	}
  

}
