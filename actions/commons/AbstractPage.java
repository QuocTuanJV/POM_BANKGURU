package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	
	

}
