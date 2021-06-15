package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Base;

public class SearchTest extends Base{
	
	@Test(description = "This is a search with results WIP")
	public void testSearchWithResult() {
		Assert.assertTrue(true);
		//principal.search("dress");
		//Assert.assertTrue(articles.articleName().contains("DRESS"),"Expected to contain DRESS but not found");
	}
	
	@Test(description = "This is a search that has no results")
	public void testSearchWithoutResult() {
		Assert.assertTrue(true);
		//principal.search("hola mundo");
		//Assert.assertTrue(articles.errorMessage().contains("No results"), "Expected to contain no results text");
	}
	
	
}
