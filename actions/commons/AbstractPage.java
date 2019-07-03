package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	
	//webrowser
	public void openURL(WebDriver driver, String url) {
		driver.get(url);
	}
	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public int countElementNumber(WebDriver driver, String locator) {
		List <WebElement> elements = driver.findElements(By.xpath(locator));
				return elements.size();
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
	//Alert
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
	
	//Web Element
	public void clickToElement(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator)).click();
		
	}
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
	
	public void selectItemFromCustomDropDownList(WebDriver driver,String parentXpath, String childXpath, String expected) {
		JavascriptExecutor javaExecutor;
		javaExecutor = (JavascriptExecutor) driver;
		WebDriverWait waitExplicit;
		waitExplicit = new WebDriverWait(driver, 60);
		
		WebElement element = driver.findElement(By.xpath(parentXpath));
		javaExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		
		System.out.println("CLICK SUCCESSFULLY!!!");
		
		List <WebElement> childList = driver.findElements(By.xpath(childXpath));
		waitExplicit.until(ExpectedConditions.visibilityOfAllElements(childList));
		
		
		for(WebElement child: childList) {
			String itemSelect = child.getText();
			
//			System.out.println("ITEM IS: " + itemSelect);
			if(itemSelect.equals(expected))
			{
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
	
	public void checkTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator)).isDisplayed();
	}
	
	public boolean isControlSelected(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator)).isSelected();
	}
	
	public boolean isControlEnable(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator)).isEnabled();
	}
	//window + user Actions + Upload + JavascriptExcuter + Wait
	
	
	
	
	
	
	

}
