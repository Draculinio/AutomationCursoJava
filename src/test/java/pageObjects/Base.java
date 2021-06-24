package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {
	protected WebDriver driver;
	protected Principal principal;
	protected Articles articles;
	
	//Ejecutamos esto antes de las pruebas
	@BeforeTest
	public void beforeTest() {
		System.out.println("Ejecuto algo antes de las pruebas");
	}
	
	//Se ejecuta luego de las pruebas
	@AfterTest
	public void afterTest() {
		System.out.println("Ejecuto algo despues de las pruebas");
	}
	
	//Se ejecuta antes de cada método de prueba
	@BeforeMethod
	public void beforeMethod() {
		//Decimos adonde queda el webdriver
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		//Creamos un objeto de tipo ChromeOptions para poder darle propiedades y opciones a nuestro chrome
		ChromeOptions options = new ChromeOptions();
		//Agrego argumentos a las opciones, en este caso hacerlo headless para que no se vea el browser
		//le saco el gpu y que ignore certificados
		options.addArguments("--headless","--disable-gpu","--ignore-certificate-errors");
		//Creo el objeto de tipo chromedriver que va a ser mediante el cual nos vamos a comunicar
		//con el browser y le paso como parámetro las opciones
		driver = new ChromeDriver(options);
		//navego al sitio
		driver.navigate().to("http://automationpractice.com/");
		//driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		driver.manage().window().setSize(new Dimension(500,500));
		//creo los page objects
		principal = new Principal(driver);
		articles = new Articles(driver);
		//Implicit wait: Da un tiempo de timeout a cualquier operacion
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Empieza un test");
	}
	//Se ejecuta al finalizar cada prueba cerrando el browser y terminando la sesión
	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}
}
