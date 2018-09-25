package sample;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.gauge.Step;

import utils.driver.Driver;

public class Lookup {
	@Step("Lookup for method <method> and type <type>")
	public void Lookup(String method, String type) {
		WebDriver driver = Driver.webDriver; 
		driver.switchTo().defaultContent();
		
		//click on Menu
		driver.switchTo().frame(driver.findElement(By.id("menuFrame"))); 
		driver.findElement(By.id("tdmainMenum_1")).click();
		driver.switchTo().defaultContent();
		
		
		
		driver.switchTo().frame(driver.findElement(By.name("mainFrame"))); 
		//Wait for frame elements to be loaded !
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("LookupDetailForm"))));

		
		driver.findElement(By.name("tableType")).sendKeys(type);
		Select dropdown = new Select(driver.findElement(By.name("searchMet")));
		dropdown.selectByVisibleText(method);
		
		 
		driver.findElement(By.name("act")).click();
		
		WebElement resultTable = driver.findElement(By.className("resultstable"));
		assertTrue(resultTable.isDisplayed());
	 
		//check by counting result
		int rowCount = driver.findElements(By.xpath("//table[contains(@class, 'resultstable')]/tbody/tr")).size();
		assertTrue(rowCount > 2);
		
		//check by paging info
		WebElement pagingInfo = driver.findElement(By.className("paginginfo"));
		assertTrue(pagingInfo.isDisplayed());
		

	}
}
