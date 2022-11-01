package ampere.qa.customeconnect.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;

public class NavBarToHomePageTest extends BaseTest {
	
	@Test (priority=1)
	public void SolutionsPage()
	{
		String actualtitle= NavBarHomePage.visitSolutionsHomepage();
		Assert.assertEquals(actualtitle, Constants.SOLUTIONS_HOMEPAGE_TITLE);
	}

	@Test (priority=2)
	public void SupportHomeLinkVerifcation() throws InterruptedException
	{
		String actualtitle= NavBarHomePage.clickSupportHome();
		Assert.assertEquals(actualtitle, Constants.HOMEPAGE_TITLE);
	}

}

