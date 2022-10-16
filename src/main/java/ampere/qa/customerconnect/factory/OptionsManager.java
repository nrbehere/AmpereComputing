package ampere.qa.customerconnect.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	private SafariOptions so;

	public OptionsManager(Properties prop)
	{
		this.prop=prop;
		
		
	}
	
	public ChromeOptions getChromeOptions()
	{
		co= new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
		{
		co.addArguments("--headless");
		}
	
		if (Boolean.parseBoolean(prop.getProperty("incongnito")))
		{
		co.addArguments("--incongnito");
		}
	  return co;
	}
	
	
	
	public FirefoxOptions getFireFoxOptions()
	{
		fo= new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
		{
		fo.addArguments("--headless");
		}
	
		if (Boolean.parseBoolean(prop.getProperty("incongnito")))
		{
		fo.addArguments("--incongnito");
		}
	  return fo;
	}
	
	public EdgeOptions getEdgeOptions()
	{
		eo= new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
		{
		eo.addArguments("--headless");
		}
	
		if (Boolean.parseBoolean(prop.getProperty("incongnito")))
		{
		eo.addArguments("--incongnito");
		}
	  return eo;
	}
	
	/*
	 * public SafariOptions getSafariOptions() { so = new SafariOptions(); if
	 * (Boolean.parseBoolean(prop.getProperty("headless"))) {
	 * ((ChromiumOptions<ChromeOptions>) so).addArguments("--headless"); }
	 * 
	 * if (Boolean.parseBoolean(prop.getProperty("incongnito"))) {
	 * so.addArguments("--incongnito"); } return so; }
	 */


}


