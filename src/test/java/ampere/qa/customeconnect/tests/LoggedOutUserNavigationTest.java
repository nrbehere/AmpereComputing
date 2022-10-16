package ampere.qa.customeconnect.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoggedOutUserNavigationTest extends BaseTest {

	@Test (priority=1)
	public void SupportPresentInNavBar()
	{
	   
	   Assert.assertTrue(LoNavigation.SupportIsPresent());
	 
	}
	
	@Test (priority=2)
	public void LinksUnderSupport()
	{
	   
	 List<String> actlist;
	 actlist=LoNavigation.SupportNavBarLinksArePresent();  
	 
	}
	
}
