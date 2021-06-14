package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Articles {
	private By articleBanner;
	private By errorBanner;
	private By orderSelect;
	private WebDriver driver;
	public Articles(WebDriver driver) {
		this.driver = driver;
		articleBanner = By.className("lighter");
		errorBanner = By.xpath("//*[@id=\'center_column\']/p");
		orderSelect = By.id("selectProductSort");
	}
	
	/**
	 * Gets the article name from the banner
	 * @return the text of the article name
	 */
	public String articleName() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(articleBanner), "dfsklfjaldfj"));
		return driver.findElement(articleBanner).getText();
	}
	
	public String errorMessage() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorBanner));
		return driver.findElement(errorBanner).getText();
	}
	
	public void selectArticleByText(String value) {
		Select order = new Select(driver.findElement(orderSelect));
		order.selectByVisibleText(value);
	}
	
	public void selectArticleByIndex(int i) {
		Select order = new Select(driver.findElement(orderSelect));
		order.selectByIndex(i);
	}
	
	public void selectArticleByValue(String value) {
		Select order = new Select(driver.findElement(orderSelect));
		order.selectByValue(value);
	}
	
}
