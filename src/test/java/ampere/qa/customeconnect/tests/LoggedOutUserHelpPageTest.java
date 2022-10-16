package ampere.qa.customeconnect.tests;

import org.testng.annotations.BeforeClass;

public class LoggedOutUserHelpPageTest extends BaseTest {
	

	@BeforeClass
	public void HelpPageSetup()
	{
		HP=LoNavigation.HelpLinkClick();
		
	}
	

}
