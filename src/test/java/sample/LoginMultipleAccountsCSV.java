package sample;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;

import utils.driver.Driver;

public class LoginMultipleAccountsCSV {
	@Step("Login multiple accounts CSV <accountTable>")
	public void methodName(Table table) {
		// write your code here

		List<TableRow> rows = table.getTableRows();
		
		List<String> columnNames = table.getColumnNames();
		
		for (TableRow row : rows) {
			String username = row.getCell(columnNames.get(0)).trim();
			String password = row.getCell(columnNames.get(1)).trim();

			WebDriver driver = Driver.webDriver;
			driver.switchTo().defaultContent();
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
			WebElement logout = driver.findElement(By.cssSelector("a[href*='logout.do']"));
			assertTrue(logout.isDisplayed());
			logout.click();
            
        }
	}
}
