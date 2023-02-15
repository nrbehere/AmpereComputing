package ampere.qa.customerconnect.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import ampere.qa.customerconnect.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Neha Behere
 *
 */
public class DriverFactory {

	public static String highlight;
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop, File folder) throws InterruptedException
	{
	  
		String BrowserName=prop.getProperty("browser");
		BrowserName=BrowserName.toLowerCase();
		
		highlight=prop.getProperty("hightlight");
		optionsManager= new OptionsManager(prop);
		
		switch (BrowserName) {
		case "chrome":
			WebDriverManager.chromedriver().driverVersion(Constants.CHROME_VERSION).setup();
			//Above code is browser specific
			
			//WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions(folder)));
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			//driver= new FirefoxDriver(optionsManager.getFireFoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFireFoxOptions()));
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			//driver= new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			//driver=new SafariDriver();
			tlDriver.set(new SafariDriver());
			break;
		default:
			break;
		}
	
				//driver.manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		//driver.wait(2000);
		getDriver().manage().window().fullscreen();
		
		
		return getDriver();
	}
	
	
	// getDriver(): It will return a thread local copy of the WebDriver
	public static synchronized WebDriver getDriver()
	{
		
		return tlDriver.get();
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
	
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
}
