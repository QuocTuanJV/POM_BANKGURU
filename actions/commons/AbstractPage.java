package commons;

import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.jetty.html.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageUIs.AbstractPageUI;

public class AbstractPage {

	// Web Browser
	public void openURL(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	// Alert
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void sendkeyToAlert(WebDriver driver, String key) {
		driver.switchTo().alert().sendKeys(key);
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	// Web Element
	// Element: button, link, check box, radio button, drop down => locator
	
	//click element on dynamic locator
	public void clickToElement(WebDriver driver, String locator, String... dynamicValue) {
		By byLocator = By.xpath(String.format(locator, (Object[]) dynamicValue));
		driver.findElement(byLocator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		driver.findElement(byLocator).click();
	}
	

	// Element: text box, text area => locator
	public void sendkeyToElement(WebDriver driver, String locator, String key) {
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(key);
	}

	public void selectItemInHtmlDropdown(WebDriver driver, String locator, String valueInDropdown) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(valueInDropdown);
	}

	public String getTextItemInHtmlDropdown(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemFromCustomDropDownList(WebDriver driver, String parentXpath, String childXpath,
			String expected) {
		JavascriptExecutor javaExecutor;
		javaExecutor = (JavascriptExecutor) driver;
		WebDriverWait waitExplicit;
		waitExplicit = new WebDriverWait(driver, 60);

		WebElement element = driver.findElement(By.xpath(parentXpath));
		javaExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

		System.out.println("CLICK SUCCESSFULLY!!!");

		List<WebElement> childList = driver.findElements(By.xpath(childXpath));
		waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));

		for (WebElement child : childList) {
			String itemSelect = child.getText();

//			System.out.println("ITEM IS: " + itemSelect);
			if (itemSelect.equals(expected)) {
				javaExecutor.executeScript("arguments[0].scrollIntoView(true);", child);
				child.click();
				break;
			}

		}

	}

	public String getAttributeValue(WebDriver driver, String locator, String nameAttribute) {
		return driver.findElement(By.xpath(locator)).getAttribute(nameAttribute);
	}

	public String getTextInElement(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator)).getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	// check display element
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator)).isSelected();
	}

	public boolean isControlEnable(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator)).isEnabled();
	}
	// window

	// user Actions + Upload + JavascriptExcuter + Wait

	// check display image upload
	public boolean isDisplayImageByJS(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return (boolean) js.executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					element);
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// wait visible dynamic locator
	public void waitToElementVisible(WebDriver driver, String locator, String... dynamicValue) {

		By byLocator = By.xpath(String.format(locator, (Object[]) dynamicValue));
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));

	}
	//wait visible locator 
	public void waitToElementVisible(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
	}
	
	//wait invisible dynamic
	public void waitToElementInvisible(WebDriver driver, String locator, String... dynamicValue) {

		By byLocator = By.xpath(String.format(locator, (Object[]) dynamicValue));
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));

	}
	
	//wait invisible locator
	public void waitToElementInvisible(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	//wait presence
	public void waitToElementPresence(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));

	}

	// 13 function open page => 01 function represent
	public AbstractPage openDynamicPage(WebDriver driver, String pageName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		//swith case for 1-> 99 page
		switch(pageName) {
		case "New Customer" :
			return PageFactoryManager.getNewCustomerPage(driver);
		case "Fund Transfer":
			return PageFactoryManager.getFundTransferPage(driver);
		case "Deposit":
			return PageFactoryManager.getDepositPage(driver);
		case "New Account":
			return PageFactoryManager.getNewAccountPage(driver);
		case "Manager":
			return PageFactoryManager.getHomePage(driver);
			default:
				return PageFactoryManager.getHomePage(driver);
		}
	}
	
	//100->1000 page: OPEN ANYPAGE FORM ANYPAGE BELONG TO ABSTRACTPAGE
	public void openDynamicPageMore(WebDriver driver, String pageName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
	}

	// Navigate to NewCustomer
	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageFactoryManager.getNewCustomerPage(driver);
	}

	// Navigate to Fund Transfer
	public FundTransferPageObject openFundTransferPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, AbstractPageUI.FUND_TRANSFER_LINK);
		return PageFactoryManager.getFundTransferPage(driver);
	}

	// Navigate to Home Page
	public HomePageObject openHomePage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageFactoryManager.getHomePage(driver);
	}

	// Navigate to Deposit Page
	public DepositPageObject openDepositPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.DEPOSIT_LINK);
		clickToElement(driver, AbstractPageUI.DEPOSIT_LINK);
		return PageFactoryManager.getDepositPage(driver);
	}

	// Navigate to New Account
	public NewAccountPageObject openNewAccountPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		return PageFactoryManager.getNewAccountPage(driver);
	}

	// Verify display Deposit
	public boolean isDepositPageDisPlay(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.DEPOSIT_DISPLAY);
		return isControlDisplayed(driver, AbstractPageUI.DEPOSIT_DISPLAY);
	}

	// Verify display Fund Transfer
	public boolean isFundTransferPageDisPlay(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.FUND_TRANSFER_DISPLAY_TEXT);
		return isControlDisplayed(driver, AbstractPageUI.FUND_TRANSFER_DISPLAY_TEXT);
	}

	// Verify display New Account
	public boolean isNewAccountPageDisPlay(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_ACCOUNT_DISPLAY_TEXT);
		return isControlDisplayed(driver, AbstractPageUI.NEW_ACCOUNT_DISPLAY_TEXT);
	}

	// Verify display New Customer
	public boolean isNewCustomerPageDisPlay(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_DISPLAY_TEXT);
		return isControlDisplayed(driver, AbstractPageUI.NEW_CUSTOMER_DISPLAY_TEXT);
	}
	
	//check Undisplayed element on locator
	public boolean isControlUnDisplayed(WebDriver driver, String locator) {
		java.util.Date date = new java.util.Date();
		System.out.println("Start time = " + date.toString());
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		
		System.out.println("SIZE = " + elements.size());
		if(elements.size() == 0) {
			java.util.Date date1 = new java.util.Date();
			System.out.println("End Time: " + date1.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return true;			
		} else if(elements.size() > 0 && elements.get(0).isDisplayed()) {
			java.util.Date date1 = new java.util.Date();
			System.out.println("End Time = " + date1.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return false;
		}
		else
		{
			java.util.Date date1 = new java.util.Date();
			System.out.println("End Time = " + date1.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return true;
		}
		
	}
	public boolean isControlUnDisplayed(WebDriver driver, String locator, String... dynamicValue) {
		Date date = new Date(0);
		System.out.println("Start time = " + date.toString());
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = driver.findElements(By.xpath(String.format(locator, (Object[]) dynamicValue)));
		if(elements.size() == 0) {
			date = new Date(0);
			System.out.println("End Time: " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return true;			
		} else if(elements.size() > 0 && elements.get(0).isDisplayed()) {
			date = new Date(0);
			System.out.println("End Time = " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return false;
		}
		else
		{
			date = new Date(0);
			System.out.println("End Time = " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return true;
		}
		
	}
	
	
	public void overrideGlobalTimeout (WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	//New Customer Undisplay
	
	
	int shortTimeout = 5;
	int longTimeout = 30;
	// viet vao de khong loi - khong dung ham nay o day
	public int randomNumber() {
		Random rd = new Random();
		return rd.nextInt(10000);
	}

}
