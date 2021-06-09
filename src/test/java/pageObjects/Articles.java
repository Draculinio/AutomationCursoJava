package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Articles {
	private String articleBanner = "lighter";
	private String errorBanner = "//*[@id=\'center_column\']/p";
	private WebDriver driver;
	public Articles(WebDriver driver) {
		this.driver = driver;
	}
	
	public String articleName() {
		return driver.findElement(By.className(articleBanner)).getText();
	}
	
	public String errorMessage() {
		return driver.findElement(By.xpath(errorBanner)).getText();
	}
	
}
