package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {
	protected WebDriver driver;
	protected Principal principal;
	protected Articles articles;
	@BeforeTest
	public void beforeTest() {
		System.out.println("Ejecuto algo antes de las pruebas");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Ejecuto algo despues de las pruebas");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://automationpractice.com/");
		//driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		driver.manage().window().setSize(new Dimension(500,500));
		principal = new Principal(driver);
		articles = new Articles(driver);
		//Implicit wait: Da un tiempo de timeout a cualquier operacion
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Empieza un test");
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}
}
