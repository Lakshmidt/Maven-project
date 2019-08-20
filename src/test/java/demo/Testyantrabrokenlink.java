package demo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Testyantrabrokenlink {
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
		driver.get("http://testyantra.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> lst = driver.findElements(By.tagName("a"));
		System.out.println(lst.size());
	/*	for(WebElement e:lst)
		{
			URL u=new URL(e.getAttribute("href"));
			HttpURLConnection con=(HttpURLConnection)u.openConnection();
			int i=con.getResponseCode();
			if(i==200)
			{
				Reporter.log("Link is not broken and response code is "+i,true);
				Reporter.log(con.getRequestMethod(),true);
			}
			else
			{
				Reporter.log("Link is broken and response code is "+i,true);
				Reporter.log(con.getRequestMethod(),true);
			}
		}*/
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
