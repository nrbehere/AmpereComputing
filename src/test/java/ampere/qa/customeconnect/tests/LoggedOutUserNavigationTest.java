package ampere.qa.customeconnect.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import ampere.qa.customerconnect.utils.Constants;

public class LoggedOutUserNavigationTest extends BaseTest {

	@Test (priority=1)
	public void SupportPresentInNavBar()
	{
	   
	   Assert.assertTrue(LoNavigation.SupportIsPresent());
	 
	}
	
	@Test (priority=2)
	public void LinksUnderSupport() throws InterruptedException
	{
	   
	 List<String> actlist;
	 actlist=LoNavigation.SupportNavBarLinksArePresent(); 
	 Assert.assertEquals(actlist, Constants.LoggedOutUserNavBarLinks());
	 
	}
	
}
