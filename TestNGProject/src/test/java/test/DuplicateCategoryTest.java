package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import page.DuplicateCategoryPage;
import util.BrowserFactory;

public class DuplicateCategoryTest {

	WebDriver driver;
	DuplicateCategoryPage duplicateCategoryPage;
	String duplicateCategoryName = "Teddy23";

	
	
	@Test
	public void userShouldNotBeAbleToAddDuplicateCategory() throws InterruptedException {
		driver = BrowserFactory.init();
		DuplicateCategoryPage duplicateCategoryPage = PageFactory.initElements(driver, DuplicateCategoryPage.class);
		duplicateCategoryPage.addCategory(duplicateCategoryName);
		duplicateCategoryPage.waitForPage();

	}
}
