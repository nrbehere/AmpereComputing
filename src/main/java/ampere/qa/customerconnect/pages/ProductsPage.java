package ampere.qa.customerconnect.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ampere.qa.customerconnect.utils.ElementUtil;

public class ProductsPage {
	
	
	private WebDriver driver;
	private Properties prop;
	private ElementUtil eleUtil;
	boolean b;

	
	public ProductsPage(WebDriver driver, Properties prop) {
      this.driver=driver;
      this.prop=prop;
      
      eleUtil=new ElementUtil(driver);
	
	}

	
	private By HeroImage= By.xpath("//img[@alt='Hero Image']");
	private By TextOnImage=By.xpath("(//p[@class='chakra-text css-bxak8j'])[1]");	
	private By BreadcrumbOnPage=By.xpath("//nav//ol");
	private By SearchBar=By.xpath("");
	private By AmpereTechSupportLink=By.xpath("//div[@class='css-x6j8jq']//div[@class='css-0']//a");
	private By ProductFamily=By.xpath("//div[@class='css-1urlnhj']");
	private By ProductCategory=By.xpath("//div[@class='chakra-accordion__item css-ka586j']");
	private By Products=By.xpath("//div[@class='css-1lbcusb']//a");
	
	
	
}
