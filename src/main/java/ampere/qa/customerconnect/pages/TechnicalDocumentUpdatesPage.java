package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

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

	
	
	
	
}
