package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Base;

/*Como todas nuestras pruebas tienen una base en común, esa base la pondremos en una clase padre
llamada Base y todas nuestras pruebas hereadarán de ahí*/
public class SearchTest extends Base{
	
	//Toda prueba debe estar con el annotation @Test, lo cual le indica a testng que el método es una prueba
	@Test(description = "This is a search with results WIP")
	public void testSearchWithResult() {
		//llamo al método search del objeto principal de la clase Principal que es el page object de la página principal 
		principal.search("dress");
		//Los asserts son los que verifican que la prueba hace lo correcto o no. Los Asserts SIEMPRE
		//deben ir en el caso de prueba y NUNCA en el page object.
		//En este caso nos aseguramos que el nombre del artículo tenga la palabra DRESS, caso contrario, en el segundo
		//parámetro le especificamos el error a mostrar
		//assertTrue nos dice que lo que esté adentro como primer parámetro tiene que ser true
		Assert.assertTrue(articles.articleName().contains("DRESS"),"Expected to contain DRESS but not found");
	}
	
	//En el annotation test, description es una descripción de la prueba
	//enabled = false dice que no se ejecutará.
	@Test(description = "This is a search that has no results", enabled=false)
	public void testSearchWithoutResult() {
		principal.search("hola mundo");
		Assert.assertTrue(articles.errorMessage().contains("No results"), "Expected to contain no results text");
	}
	
	
}
