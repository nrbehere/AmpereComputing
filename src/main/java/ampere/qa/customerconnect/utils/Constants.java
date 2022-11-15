package ampere.qa.customerconnect.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String HOMEPAGE_TITLE="Ampere Customer Connect";
	public static final String HOMEPAGE_URL_FRACTION = "/customer-connect";
	public static final String TD_LOGIN_MSG = "You are not logged in.";
	public static final String SWF_LOGIN_MSG = "You are not logged in.";
	public static final int DEFAULT_TIMEOUT = 3;
	public static final String REGISTRATION_PAGE_TITLE = "Registration";
	public static final String SOLUTIONS_HOMEPAGE_URL="https://cms-nextjs-qa.amperecomputing.com/";
	public static final String SOLUTIONS_HOMEPAGE_TITLE = "Solutions Portal";
	public static final String LOGIN_PAGE_TITLE="Ampere Computing - Sign In";

	
	
	public static List<String> LoggedOutUserNavBarLinks()
	{
		List<String> LONavList= new ArrayList<String>();
		LONavList.add("Support Home");
		LONavList.add("Products");
		LONavList.add("Help");
		return LONavList;
	}
	
}
