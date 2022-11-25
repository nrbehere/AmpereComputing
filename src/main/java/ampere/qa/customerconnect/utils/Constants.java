package ampere.qa.customerconnect.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String HOMEPAGE_TITLE="Ampere Customer Connect";
	public static final String HOMEPAGE_URL_FRACTION = "/customer-connect";
	public static final String TD_LOGIN_MSG = "You are not logged in.";
	public static final String SWF_LOGIN_MSG = "You are not logged in.";
	public static final int DEFAULT_TIMEOUT = 5;
	public static final String REGISTRATION_PAGE_TITLE = "Registration";
	public static final String SOLUTIONS_HOMEPAGE_URL="https://cms-nextjs-qa.amperecomputing.com/";
	public static final String SOLUTIONS_HOMEPAGE_TITLE = "Solutions Portal";
	public static final String LOGIN_PAGE_TITLE="Ampere Computing - Sign In";
	public static final String WELCOME_TEXT_HOMEPAGE="Welcome to Customer Connect";
	public static final String HOMEPAGE_ACCESSMSG = "Access to this site is for our Customers";
	public static final String HELP_PAGE_TITLE = "Help";
	public static final String TECH_DOC_UPDATE_PAGE_TITLE = "Technical Documents Recently Updated";
	public static final String SW_DES_FILES_UPDATE_PAGE_TITLE = "Software Recently Updated";
	public static final String TECH_BULLETIN_UPDATE_PAGE_TITLE = "Technical Bulletins Recently Updated";
	public static final String PROFILE_PAGE_TITLE = "Profile";
	public static final String SW_UPDATE_PAGE_TEXT_ON_HEROIMAGE = "Software and Design Files Updates";
	public static final String TECH_DOC_UPDATES_PAGE_TEXTONIMAGE = "Technical Documents Updates";
		
	public static List<String> LoggedOutUserNavBarLinks()
	{
		List<String> LONavList= new ArrayList<String>();
		LONavList.add("Support Home");
		LONavList.add("Products");
		LONavList.add("Help");
		return LONavList;
	}
	
}
