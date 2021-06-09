package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Articles;
import pageObjects.Principal;

public class SearchTest {
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
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Empieza un test");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Finaliza el test");
	}
	
	@Test
	public void testSearchWithResult() {
		principal.search("dress");
		this.waitForPage(4000);
		Assert.assertTrue(articles.articleName().contains("DRESS"),"Expected to contain DRESS but not found");
	}
	
	@Test
	public void testSearchWithoutResult() {
		principal.search("hola mundo");
		this.waitForPage(4000);
		Assert.assertTrue(articles.errorMessage().contains("No results"), "Expected to contain no results text");
	}
	
	public void waitForPage(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			System.out.println("Hubo una interrupcion");
		}
	}
}
