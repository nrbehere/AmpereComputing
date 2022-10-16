package ampere.qa.customerconnect.pages;

import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.ElementUtil;

public class LoggedOutUserProductPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	public LoggedOutUserProductPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil=new ElementUtil(driver); 
	}

}
