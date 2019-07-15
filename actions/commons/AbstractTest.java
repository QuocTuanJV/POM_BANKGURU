package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	
	private WebDriver driver;
	public  WebDriver openMultiBrowser(String nameBrowser) {
		if(nameBrowser.equals("firefox")) {
//			set path to geckodriver with firefox >= 48
//			System.setProperty("webdriver.chrome.driver", ".\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(nameBrowser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
//			System.setProperty("webdriver.ie.driver", ".\\lib\\iedriver.exe");
//			System.setProperty("webdriver.opera.driver", ".\\lib\\operadriver.exe");
//			System.setProperty("webdriver.edge.driver", ".\\lib\\edgedriver.exe");	
			driver = new ChromeDriver();
		} else if(nameBrowser.equals("chromeheadless")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
		}
		driver.get(Constants.DEV_URL);		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("Driver Abstract Test: "+ driver.toString());
		return driver;

	}
	
	public int randomNumber() {
		Random rd = new Random();
		return rd.nextInt(10000);
	}
}
