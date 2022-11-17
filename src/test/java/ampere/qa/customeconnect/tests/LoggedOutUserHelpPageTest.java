package ampere.qa.customeconnect.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;

public class LoggedOutUserHelpPageTest extends BaseTest {
	

	@BeforeClass
	public void HelpPageSetup() throws InterruptedException
	{
		HP=LoNavigation.HelpLinkClick();
		
	}
	
	@Test (priority=1)
	public void HelpPageTitleVerification()
	{
		String actTitle=HP.HelpPageTitle();
		Assert.assertEquals(actTitle, Constants.HELP_PAGE_TITLE);
	}

}
