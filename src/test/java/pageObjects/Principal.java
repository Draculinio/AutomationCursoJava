package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Principal {
	private By searchBox;
	private By searchButton;
	private WebDriver driver;
	public Principal(WebDriver driver) {
		this.driver = driver;
		searchBox = By.id("search_query_top");
		searchButton = By.name("submit_search");
	}
	
	public void search(String searchParameter) {
		driver.findElement(searchBox).sendKeys(searchParameter);
		driver.findElement(searchButton).click();
	}
}
