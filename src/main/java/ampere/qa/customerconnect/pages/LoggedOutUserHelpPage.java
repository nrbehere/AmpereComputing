package ampere.qa.customerconnect.pages;

import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.Constants;
import ampere.qa.customerconnect.utils.ElementUtil;

public class LoggedOutUserHelpPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	String title;
	
	public LoggedOutUserHelpPage(WebDriver driver)
	{
	   this.driver=driver;
	   eleUtil=new ElementUtil(driver);
		
	}
	
	
	public String HelpPageTitle()
	{
		eleUtil.doGetTitle(Constants.HELP_PAGE_TITLE,3000);
		return title;
	}
	
	
}
