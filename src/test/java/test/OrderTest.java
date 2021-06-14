package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extras.Waiter;
import pageObjects.Articles;
import pageObjects.Principal;

public class OrderTest {
	private WebDriver driver;
	private Principal principal;
	private Articles articles;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/");
		principal = new Principal(driver);
		articles = new Articles(driver);
		//Implicit wait: Da un tiempo de timeout a cualquier operacion
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void searchByHigherPriceTest() {
		principal.search("dress");
		articles.selectArticleByText("Price: Highest first");
	}
}
