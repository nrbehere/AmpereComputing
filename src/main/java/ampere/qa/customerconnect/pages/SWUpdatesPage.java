package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	
	private By heroImage= By.xpath("/img[@alt='Hero Image']");
	private By TextOnImage= By.xpath("//p[@class='chakra-text css-bxak8j']");
	private By WMNote=By.xpath("(//div[@class='css-11vop16'])[1]");
	private By PPNote=By.xpath("(//div[@class='css-11vop16'])[2]");
	private By MoreAboutPasswordNote=By.xpath("//button[@class='chakra-button css-q9s9te']");
	private By TableColumnTitle=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[1]");
	private By TableColumnRev=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[2]");
	private By TableColumnDate=By.xpath("(//table[@class='chakra-table css-p50ahq']//th)[3]");
	
	

}
