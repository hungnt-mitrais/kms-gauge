package sample;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.driver.Driver; 
import static org.junit.Assert.assertTrue; 

import java.util.List;
 

public class LoginMultipleAccounts {

	@Step("Login multiple accounts <accounts> <accountTable>")
    public void methodName(String tableName, Table table) {
        // write your code here
		
		List<TableRow> rows = table.getTableRows();
	    List<String> columnNames = table.getColumnNames();
	    for (TableRow row : rows) {
	    	for (int i = 0; i < row.size(); i++) {
				Gauge.writeMessage(row.getCell(columnNames.get(i)));
				
			}
	    	
	    	WebDriver driver = Driver.webDriver;
	    	String username = row.getCell(columnNames.get(0)).trim();
	    	String password = row.getCell(columnNames.get(1)).trim();
	    	
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
