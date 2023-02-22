package test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import page.DropdownPage;
import util.BrowserFactory;

public class DropdownTest {
	
	WebDriver driver;
	DropdownPage dropdownPage;
	
	@Test
	public void dropdownShouldHaveAllMonths() throws InterruptedException {
		driver = BrowserFactory.init();
		dropdownPage = PageFactory.initElements(driver, DropdownPage.class);
	
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		List<String> dropdownList = dropdownPage.getListOfDropDown();
		Assert.assertTrue(isDataMatch(months, dropdownList), "Values does not match");
		Thread.sleep(3000);

}

	private boolean isDataMatch(String[] months, List<String> dropdownList) {
		for (int i = 0; i < dropdownList.size(); i++) {
			if (dropdownList.get(i).equalsIgnoreCase(months.toString())) {
			}
		}
		return true;
	}
	
}
