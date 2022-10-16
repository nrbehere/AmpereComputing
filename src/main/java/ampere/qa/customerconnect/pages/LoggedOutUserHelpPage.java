package ampere.qa.customerconnect.pages;

import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.ElementUtil;

public class LoggedOutUserHelpPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public LoggedOutUserHelpPage(WebDriver driver)
	{
	   this.driver=driver;
	   eleUtil=new ElementUtil(driver);
		
	}
}
