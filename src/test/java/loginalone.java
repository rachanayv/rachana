import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginalone {
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		driver=UtilityClass.openBrowser("chrome");
		driver.get("http://demoaut.com");
	}
	@DataProvider
	public Object[][] loginDp() throws IOException
	{
		return ReadExcel.readData();
	}
	@Test(dataProvider="loginDp")
	public void login(String username,String password) 
	{
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tripType")));
		
		Assert.assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());
		System.out.println("logged in Successfully !!");

	}
	@AfterTest
	public void afterTest()
	{
		//driver.close();
	}
}
