package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
		return driver.findElement(articleBanner).getText();
	}
	
	public String errorMessage() {
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
		order.deselectByValue(value);
	}
	
}
