package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import util.BrowserFactory;

public  class AddCategoryTest {

	WebDriver driver;
	AddCategoryPage addCategoryPage;
	String categoryName = "Teddy";

	@Test
	public void validUserBeAbleToAddCategory() throws Throwable {
		driver = BrowserFactory.init();
		AddCategoryPage AddCategoryPage = PageFactory.initElements(driver, AddCategoryPage.class);
		AddCategoryPage.addCategory(categoryName);
		AddCategoryPage.clicOnAddCategoryButton();
		
		AddCategoryPage.verifyAddedCategory();
		
	
	

		
		//BrowserFactory.tearDown();
	}
}

