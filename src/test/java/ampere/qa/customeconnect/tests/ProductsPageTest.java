package ampere.qa.customeconnect.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;

public class ProductsPageTest extends BaseTest {

	@BeforeClass
	public void ProductPageSetup() throws InterruptedException
	{
		LoggedInHomePage.Login();
		LoggedInHomePage.ProductPageSetup();
		
	}
	
	
	
	
}
