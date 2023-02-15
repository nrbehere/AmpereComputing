package ampere.qa.customerconnect.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Constants {

	public static final String HOMEPAGE_TITLE="Ampere Customer Connect";
	public static final String HOMEPAGE_URL_FRACTION = "/customer-connect";
	public static final String TD_LOGIN_MSG = "You are not logged in.";
	public static final String SWF_LOGIN_MSG = "You are not logged in.";
	public static final int DEFAULT_TIMEOUT = 5;
	public static final String REGISTRATION_PAGE_TITLE = "Registration";
	public static final String AMPERE_HOMEPAGE_URL="https://cms-nextjs-qa.amperecomputing.com/";
	public static final String AMPERE_HOMEPAGE_TITLE = "Ampere Computing";
	public static final String LOGIN_PAGE_TITLE="Ampere Computing - Sign In";
	public static final String WELCOME_TEXT_HOMEPAGE="Welcome to Customer Connect";
	public static final String HOMEPAGE_ACCESSMSG = "Access to this site is for our Customers";
	public static final String HELP_PAGE_TITLE = "Help";
	public static final String TECH_DOC_UPDATE_PAGE_TITLE = "Technical Documents Recently Updated";
	public static final String INDI_TECH_DOC_PAGE_TEXT_ON_HERO_IMAGE="Technical Documents Updates";
	public static final String SW_DES_FILES_UPDATE_PAGE_TITLE = "Software Recently Updated";
	public static final String TECH_BULLETIN_UPDATE_PAGE_TITLE = "Technical Bulletins Recently Updated";
	public static final String PROFILE_PAGE_TITLE = "Profile";
	public static final String SW_UPDATE_PAGE_TEXT_ON_HEROIMAGE = "Software and Design Files Updates";
	public static final String TECH_DOC_UPDATES_PAGE_TEXTONIMAGE = "Technical Documents Updates";
	public static final String TECH_BULLETIN_UPDATE_PAGE_TEXT_ON_HEROIMAGE = "Technical Bulletin Updates";
	public static final String HELP_PAGE_TEXT_ON_HERO_IMAGE = "Help";
	public static final String HELP_SUCCESSFUL_FORM_SUBMISSION="Request submitted successfully!";
	public static final String TECH_BULLETIN_TITLE = "Technical Bulletins";
	public static final String TECH_BULLETIN_PAGE_TEXT_ON_HERO_IMAGE ="Technical Bulletins" ;
	public static final String PROFILE_PAGE_TEXT_ON_HERO_IMAGE = "Profile";
	public static final String DOWNLOAD_MESSAGE_FOR_FILE = "Downloading Started";
	public static final String INDI_SW_PCK_PAGE_TEXT_ON_HERO_IMAGE = "Software and Design Files Updates";
	public static final String PROFILE_UPDATED_MESSAGE = "Your profile has been updated successfully";
	public static final String CHROME_VERSION = "110.0.5481.100";
	public static final String INDI_TECH_BULLETIN_TEXT_ON_HERO_IMAGE = "Technical Bulletin Updates";
	
	
		
	public static List<String> LoggedOutUserNavBarLinks()
	{
		List<String> LONavList= new ArrayList<String>();
		LONavList.add("Customer Connect Home");
		LONavList.add("Products");
		LONavList.add("Help");
		return LONavList;
	}
	

  
	

}
