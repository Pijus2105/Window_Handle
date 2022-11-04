package IssueWire_Handle;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Class {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://www.issuewire.com/");
		  
		  
		  WebElement links = driver.findElement(By.xpath("//div[@class='panel-group']"));
		
		  //WebElement links = driver.findElement(By.cssSelector("[class='row masonry']"));
		  System.out.println(links.findElements(By.xpath("//div[@class='panel-group']")).size());
		  
		  List<WebElement> el =  driver.findElements(By.xpath("//div[@class='panel panel-default']"));
		  System.out.println(links.findElements(By.xpath("//div[@class='panel panel-default']")).size());
		  
		  
		  for(WebElement elem : el) {
			  if(el.size()!= 0) {
				  
	        	 elem.isSelected();
	        	 
	        	 Thread.sleep(3000);
	        	 elem.click();
	         }
			  System.out.println(elem.getText());
		
		  
		  }

		  
		
	}

}
