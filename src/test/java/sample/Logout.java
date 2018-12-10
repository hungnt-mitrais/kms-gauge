package sample;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;

import com.thoughtworks.gauge.Step;

import utils.driver.Driver;

public class Logout {
	@Step("Logout")
	public void Logout() {
		WebDriver driver = Driver.webDriver;  

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.name("bottomFrame")));
		WebElement logout = driver.findElement(By.cssSelector("a[href*='logout.do']"));
		assertTrue(logout.isDisplayed());
		logout.click();
	}
}
