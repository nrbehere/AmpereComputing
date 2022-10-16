package ampere.qa.customerconnect.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static String highlight;
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	
	public WebDriver init_driver(Properties prop) throws InterruptedException
	{
	  
		String BrowserName=prop.getProperty("browser");
		BrowserName=BrowserName.toLowerCase();
		
		highlight=prop.getProperty("hightlight");
		optionsManager= new OptionsManager(prop);
		
		switch (BrowserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(optionsManager.getChromeOptions());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver(optionsManager.getFireFoxOptions());
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver(optionsManager.getEdgeOptions());
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
						
		default:
			break;
		}
	
		
		//driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		//driver.wait(2000);
		driver.manage().window().fullscreen();
		
		
		return driver;
	}
	
	public Properties init_prop()
	{
		prop= new Properties();
		try {
			FileInputStream ip= new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
	
}
