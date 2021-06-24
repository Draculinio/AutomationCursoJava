package test;

import org.testng.annotations.Test;

import pageObjects.Base;

public class OrderTest extends Base{
	//En este caso le damos tambi�n una prioridad a la prueba para darle un orden de ejecuci�n
	@Test(description="Tests order by higher price", priority = 10)
	public void searchByHigherPriceTest() {
		principal.search("dress");
		articles.selectArticleByText("Price: Highest first");
	}
}
