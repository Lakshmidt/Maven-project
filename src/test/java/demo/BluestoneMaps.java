package demo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BluestoneMaps {
	WebDriver driver;
	@BeforeMethod
	public void start()
	{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","./softwares/chromedriver.exe");
	}
	@Test
	public void bluestonemap() throws IOException, InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://www.bluestone.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Visit Our Stores']")).click();
		Thread.sleep(5000);
		 List<WebElement> lst = driver.findElements(By.xpath("//div[@class='map-image']"));
		 int i=1;String name="map";
		for( WebElement e:lst)
		{	
			JavascriptExecutor s = (JavascriptExecutor)driver;
			s.executeScript("window.scrollBy(0,200)");
			Thread.sleep(10000);
			File src = e.getScreenshotAs(OutputType.FILE);
			File dest=new File("./photos/"+name+i+".png");
			FileUtils.copyFile(src, dest);
			i++;
		}
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}

}
