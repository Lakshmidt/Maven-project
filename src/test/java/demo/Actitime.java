package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Actitime {
	WebDriver driver;
	@BeforeMethod
	public void start()
	{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","./softwares/chromedriver.exe");
	}
	@Test
	public void login() throws IOException
	{
		driver=new ChromeDriver();
		driver.get("http://lenovo/login.do");
		File src=driver.findElement(By.name("username")).getScreenshotAs(OutputType.FILE);
		File dst= new File("./photos/username.png");
		FileUtils.copyFile(src,dst);
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
