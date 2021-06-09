package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Principal {
	private String searchBox = "search_query_top";
	private String searchButton = "submit_search";
	private WebDriver driver;
	public Principal(WebDriver driver) {
		this.driver = driver;
	}
	
	public void search(String searchParameter) {
		driver.findElement(By.id(searchBox)).sendKeys(searchParameter);
		driver.findElement(By.name(searchButton)).click();
	}
}
