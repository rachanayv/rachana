package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UtilityClass;




public class check
{
	WebDriver driver;
	@BeforeTest
	public void beforetest() {
		driver=UtilityClass.openBrowser("chrome");
		driver.get("http://www.demoaut.com");
	}
  @Test(priority=1)
  public void doLogin() {
	  driver.findElement(By.name("userName")).sendKeys("tutorial");
	  driver.findElement(By.name("password")).sendKeys("tutorial");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  WebDriverWait wait=new WebDriverWait(driver,1000);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tripType")));
	  Assert.assertEquals("Find a Flight: Mercury Tours:",driver.getTitle());
	 System.out.println("logged in!");
  }
@Test(priority=2)
public void doTicketing() {
    Select sel= new Select(driver.findElement(By.name("passCount")));
    sel.selectByIndex(2);
    sel=new Select(driver.findElement(By.name("fromPort")));
    sel.selectByValue("London");
    sel= new Select(driver.findElement(By.name("toPort")));
    sel.selectByVisibleText("Paris");
    driver.findElement(By.xpath("//input[@value='First' and @type='radio']")).click();
}
  @AfterTest
  public void AfterTest() {
	  driver.close();
  }
}
