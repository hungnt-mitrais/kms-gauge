package sample;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driver.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.List;

public class Login {

	@Step("Login with username <username> and password <password>")
	public void LoginAsCustomerDetails(String username, String password) {
		WebDriver driver = Driver.webDriver;
		
		WebElement login = driver.findElement(By.name("LoginForm"));
		assertTrue(login.isDisplayed());
		
		driver.findElement(By.name("userId")).click();
		driver.findElement(By.name("userId")).clear();
		driver.findElement(By.name("userId")).sendKeys(username);

		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("login")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.name("bottomFrame")));
		By logoutLink = By.linkText("Logout");
		WebElement logout = driver.findElement(logoutLink);
		assertTrue(logout.isDisplayed());
		
	}
}
