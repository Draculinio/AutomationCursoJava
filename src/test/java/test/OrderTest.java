package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import extras.Waiter;
import pageObjects.Articles;
import pageObjects.Base;
import pageObjects.Principal;

public class OrderTest extends Base{
	@Test(description="Tests order by higher price", priority = 10)
	public void searchByHigherPriceTest() {
		principal.search("dress");
		articles.selectArticleByText("Price: Highest first");
	}
}
