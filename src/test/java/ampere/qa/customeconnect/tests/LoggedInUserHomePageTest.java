package ampere.qa.customeconnect.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoggedInUserHomePageTest extends BaseTest {
	
	@BeforeClass
	public void Login() throws InterruptedException
	{
		LoggedInHomePage.Login();
	}
	
	@Test (priority=1)
	public void WelcomeTextVerification()
	{
		
	}

	@Test (priority=2)
	public void AccessMessageVerification()
	{
		
	}
	@Test (priority=3)
	public void TechnicalDocumentCardVerification()
	{
		
	}
	@Test (priority=4)
	public void SoftwarePackageCardVerification()
	{
		
	}
	
	@Test (priority=5)
	public void TechnicalBulletinCardVerification()
	{
		
	}

	@Test (priority=6)
	public void HelpCardVerification()
	{
		
	}

	
	
	@AfterClass
	public void Logout()
	{
		
	}
}
