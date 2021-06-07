package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {
	
	@Test
	public void testSearchWithResult() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/");
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		driver.findElement(By.name("submit_search")).click();
		String titleText = driver.findElement(By.className("lighter")).getText();
		Assert.assertTrue(titleText.contains("DRESS"),"Expected to contain DRESS but not found");
		driver.close();
	}
	
	@Test
	public void testSearchWithoutResult() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/");
		driver.findElement(By.id("search_query_top")).sendKeys("hola mundo");
		driver.findElement(By.name("submit_search")).click();
		String errorText = driver.findElement(By.xpath("//*[@id=\'center_column\']/p")).getText();
		Assert.assertTrue(errorText.contains("No results"),"Expected to contain no results text");
		driver.close();
	}
}
