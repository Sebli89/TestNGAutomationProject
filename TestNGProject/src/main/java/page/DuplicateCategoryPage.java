package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuplicateCategoryPage {

	WebDriver driver;

	public DuplicateCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "categorydata") 
	WebElement Categorydata_Element;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement Add_Category_Button;
	@FindBy(how = How.CSS, using = "body")
	WebElement Duplicate_Display_Element;
	
//	String insertedCategory;
//	public void addCategory(String categoryName) {
//		insertedCategory = categoryName + generateRandomNum(99);
//		CATEGORY_ELEMENT.sendKeys(insertedCategory);
//	

	public void addCategory(String categoryName) throws InterruptedException {
		Categorydata_Element.sendKeys(categoryName);
		Thread.sleep(2000);
		Add_Category_Button.click();
	}

	public void waitForPage() {
		waitForElement(Duplicate_Display_Element, driver);
	}

	public void waitForElement(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean isDuplicateMessageDisplayed() {
		try {
			waitForPage();
			return true;
		} catch (Exception e) {

		}
		return false;
	}
	
}
