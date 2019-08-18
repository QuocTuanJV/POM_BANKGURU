package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {

	private WebDriver driver;
	protected JavascriptExecutor javaExecutor;
	protected final Log log;
	//Get project path: D:\workspace\POM_BANKGURU
	private final String workingDir = System.getProperty("user.dir");

	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver openMultiBrowser(String nameBrowser) {
		if (nameBrowser.equals("firefox")) {
//			set path to geckodriver with firefox >= 48
//			System.setProperty("webdriver.chrome.driver", ".\\lib\\geckodriver.exe");
//			WebDriverManager.firefoxdriver().arch64().setup();
			WebDriverManager.firefoxdriver().arch64().setup();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, workingDir + "\\FirefoxLog.txt");
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
			javaExecutor = (JavascriptExecutor) driver;
			
		} else if(nameBrowser.equals("firefoxheadless")) {
			WebDriverManager.firefoxdriver().arch64().setup();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, workingDir + "\\FirefoxLog.txt");
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
			javaExecutor = (JavascriptExecutor) driver;
		}
		else if (nameBrowser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");

//			WebDriverManager.chromedriver().setup();
//			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");
			options.addArguments("--incognito");
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//			driver = new ChromeDriver(capabilities);
			driver = new ChromeDriver(options);
			javaExecutor = (JavascriptExecutor) driver;
		} else if (nameBrowser.equals("chromeheadless")) {
//			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
			javaExecutor = (JavascriptExecutor) driver;
			
		} else if (nameBrowser.equals("internetexplorer")) {
			WebDriverManager.iedriver().arch32().setup();
			
			
			InternetExplorerOptions options = new InternetExplorerOptions();
		
			
			driver = new InternetExplorerDriver();
			javaExecutor = (JavascriptExecutor) driver;
		}
		driver.get(Constants.DEV_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		System.out.println("Driver Abstract Test: " + driver.toString());
		return driver;

	}

	public int randomNumber() {
		Random rd = new Random();
		return rd.nextInt(10000);
	}

	// AssertTrue => VerifyTrue (Modify Function Assert)
	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASS===");
			else {
				log.info("===FAILED===");
			}

			Assert.assertTrue(condition);

		} catch (Throwable e) {
			pass = false;
			// add issue in report
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			
		}
		return pass;
	}

	// AssertTrue => VerifyTrue Modify Function Assert and hide Function checkPassed
	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false)
				log.info("===PASS=====");
			else {
				log.info("===FAILED===");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			// add issue in report
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private void checkEquals(Object actual, Object expected) {
		//boolean pass = true;
		try {
			if (actual.equals(expected) ) {
				log.info("===PASS===123");
			   
			}
			else {
				log.info("456===FAILED===");
			}
			 Assert.assertEquals(actual, expected);
			
		} catch (Throwable e) {
			//pass = false;
			// add issue in report
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		//return pass;
	}

	protected void verifyEquals(Object actual, Object expected) {//actual
		System.out.println(actual + "==" + expected);
		checkEquals(actual, expected);
	}
	
	protected void closeBrowser (WebDriver driver) {
		try {
			//Detect Os (Windows/ Linux/ MAC)
			String osName = System.getProperty("os.name").toLowerCase();
			String cmd = "";
			driver.manage().deleteAllCookies();
			driver.quit();
			//DELETE PROCESS IN TASK MANAGE Chrome
			if(driver.toString().toLowerCase().contains("chrome")) {
				//Kill process
				if(osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			//internetExplorer
			if(driver.toString().toLowerCase().contains("internetexplorer")) {
				
				//Kill process
				if(osName.toLowerCase().contains("mac")) {
					cmd = "pkill IEDriverServer*";
				} else {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			log.info("-----QUIT BROWSER SUCCESS-----");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
