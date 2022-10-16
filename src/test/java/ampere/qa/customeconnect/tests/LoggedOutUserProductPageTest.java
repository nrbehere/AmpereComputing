package ampere.qa.customeconnect.tests;

import org.testng.annotations.BeforeClass;

public class LoggedOutUserProductPageTest extends BaseTest {
	

	@BeforeClass
	public void LoggedOutUserProductPageSetup()
	{
		LoProductPage=LoNavigation.ProductClick();
	} 

	
}

