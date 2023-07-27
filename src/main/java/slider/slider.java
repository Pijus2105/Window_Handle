package slider;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class slider {

	public static void main(String[] args) {



		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://musicpromotion.club/musicpromo/custompackage");
		 
		 
//		 driver.findElement(By.xpath("//input[@id='youtubechk']")).click();
//		 driver.findElement(By.xpath("//input[@id='soundcloudchk']")).click();
		// driver.findElement(By.xpath("//input[@id='otherchk']")).click();
//		 
		// WebElement element = driver.findElement(By.xpath("//div[@class='form-group hidden-xs hidden-sm']//button[@type='button']"));
	//	 element.click();
		 
		// driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		 
//		 Actions action = new Actions(driver);
//		 action.dragAndDropBy(element, 150, 100).perform();
		
//		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//		 WebDriver driver = new ChromeDriver();
//		 driver.manage().window().maximize();
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		 driver.get("https://musicpromotion.club/");
//		 
//		 
//		 driver.findElement(By.xpath("//a[@class='music_subbtn']")).click();
//		 
//
//	        Set<String> allWindowHandles = driver.getWindowHandles();
//	        Iterator<String> iterator = allWindowHandles.iterator();
//
//	        // Here we will check if child window has other child windows and will fetch the heading of the child window
//	        while (iterator.hasNext()) {
//	            String ChildWindow = iterator.next();
//	               // if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
//	                driver.switchTo().window(ChildWindow);
//	                //}
//	        }
//		 driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("123");

		 
		 

	}

}
