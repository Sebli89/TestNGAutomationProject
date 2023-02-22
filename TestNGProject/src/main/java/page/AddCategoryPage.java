package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AddCategoryPage extends BasePage {

	WebDriver driver;

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;

	}

	// Element
	@FindBy(how = How.NAME, using = "categorydata")
	WebElement CATEGORY_ELEMENT;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement ADD_CATEGORY_ELEMENT;

	// Corresponding
	// public void addCategory(String category) {
	// CATEGORY_ELEMENT.sendKeys(category);

	String insertedCategory;
	public void addCategory(String categoryName) {
		insertedCategory = categoryName + generateRandomNum(99);
		CATEGORY_ELEMENT.sendKeys(insertedCategory);
	}

	public void clicOnAddCategoryButton() {
		ADD_CATEGORY_ELEMENT.click();

	}

//	public void verifyAddedCategory(String addedCategoryText) throws Throwable {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(ADDED_CATEGORY_ELEMENT));
//		Assert.assertEquals(ADDED_CATEGORY_ELEMENT.getText(), addedCategoryText, "Category Doesn't Exist!");

	String begining_css = "body > div.controls > a:nth-child(";
	String after_css = ") > span";

	public void verifyAddedCategory() {

		for (int i = 6; i <= 100; i++) {
			driver.findElement(By.cssSelector("body > div.controls > a:nth-child(" + i + ") > span"));
			String categoryOnList = driver.findElement(By.cssSelector(begining_css + i + after_css)).getText();
			System.out.println(categoryOnList);
			//Assert.assertNotNull(categoryOnList, "Name does not exist!!");
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(categoryOnList, "Name does not exist!!");
			if (categoryOnList.contains(insertedCategory)) {
				System.out.println("Entered category exist!!");
				break;
			}

		}
	}
}
