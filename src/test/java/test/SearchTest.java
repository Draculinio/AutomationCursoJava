package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Base;

/*Como todas nuestras pruebas tienen una base en com�n, esa base la pondremos en una clase padre
llamada Base y todas nuestras pruebas hereadar�n de ah�*/
public class SearchTest extends Base{
	
	//Toda prueba debe estar con el annotation @Test, lo cual le indica a testng que el m�todo es una prueba
	@Test(description = "This is a search with results WIP")
	public void testSearchWithResult() {
		//llamo al m�todo search del objeto principal de la clase Principal que es el page object de la p�gina principal 
		principal.search("dress");
		//Los asserts son los que verifican que la prueba hace lo correcto o no. Los Asserts SIEMPRE
		//deben ir en el caso de prueba y NUNCA en el page object.
		//En este caso nos aseguramos que el nombre del art�culo tenga la palabra DRESS, caso contrario, en el segundo
		//par�metro le especificamos el error a mostrar
		//assertTrue nos dice que lo que est� adentro como primer par�metro tiene que ser true
		Assert.assertTrue(articles.articleName().contains("DRESS"),"Expected to contain DRESS but not found");
	}
	
	//En el annotation test, description es una descripci�n de la prueba
	//enabled = false dice que no se ejecutar�.
	@Test(description = "This is a search that has no results", enabled=false)
	public void testSearchWithoutResult() {
		principal.search("hola mundo");
		Assert.assertTrue(articles.errorMessage().contains("No results"), "Expected to contain no results text");
	}
	
	
}
