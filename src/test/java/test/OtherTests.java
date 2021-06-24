//Formas de ejecutar pruebas por separado
//mvn -Dtest=OtherTests test
//mvn -Dtest=OtherTests#testTrue test
//mvn -Dtest=*Tests test
//mvn -Dtest=OtherTests#*True test

package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OtherTests {
	//Comprobamos assert que tiene que dar true.
	//Le damos un timeout de 2 segundos.
	@Test(timeOut = 2000)
	public void testTrue() {
		int a = 10;
		int b = 15;
		Assert.assertTrue(a+b == 25,"Expected a true statement");
	}
	
	//Comprobamos que tiene que dar false el assert
	@Test
	public void testFalse() {
		int a = 15;
		int b = 5;
		Assert.assertFalse(a%b==1);
	}
	
	//En este assert verificamos que dos cosas son iguales
	@Test
	public void testEquals() {
		int a = 5;
		int b = 10;
		Assert.assertEquals(a*2, b);
	}
	
	@Test
	public void testStringsEquals() {
		String a = "Hola";
		Assert.assertEquals(a, "Hola");
	}
	
	@Test
	public void testBoolEquals() {
		boolean a = false;
		Assert.assertEquals(a, false);
	}
	
	@Test
	public void testNumericEquals() {
		Assert.assertEquals(10*2+20, 80/2);
	}
	
	//En esta prueba verificamos que dos cosas no son iguales
	@Test
	public void notEquals() {
		Assert.assertNotEquals(20, 21);
	}
}
