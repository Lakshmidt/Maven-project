package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testdemo {
	WebDriver driver;
	@BeforeMethod
	public void set()
	{
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
	}
	@Test
	public void test()
	{
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		Reporter.log(driver.getTitle(),true);
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
