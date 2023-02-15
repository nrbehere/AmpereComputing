package ampere.qa.customeconnect.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;
import io.qameta.allure.Description;

public class NavBarToHomePageTest extends BaseTest {
	
	@Description("Test Case - Verification Customer Connect Homepage can be accessed via Navigation Bar")
	@Test (priority=1)
	public void SupportHomeLinkVerifcation() throws InterruptedException
	{
		String actualtitle= NavBarHomePage.clickSupportHome();
		Assert.assertEquals(actualtitle, Constants.HOMEPAGE_TITLE);
	}

}

