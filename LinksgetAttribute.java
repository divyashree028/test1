package amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksgetAttribute {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
	    String url = driver.getCurrentUrl();
	    System.out.println(url);
        List<WebElement> links = driver.findElements(By.xpath("//a"));
         int count = links.size();
         System.out.println(count);
        for( WebElement we : links) 
         {
        	String att = we.getAttribute("href");
        	System.out.println(att);
        	
        	 String text = we.getText();
        	 System.out.println(text);
         }
           
          // driver.quit();
	}

}
