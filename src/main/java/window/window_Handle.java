package window;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class window_Handle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://elphilltechnology.env/");
		 
		 driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		 
		 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pijus@elphilltechnology.com");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pijus2105@");
		 
		 driver.findElement(By.xpath("//input[@id='submit-btn1']")).click();
		 
		 driver.findElement(By.xpath("//i[@class='fa fa-credit-card-alt fa-5x']")).click();
		 
          Set<String> hand = driver.getWindowHandles();
         Iterator<String> it = hand.iterator();
 	
  	String parentWindowId = it.next();
 	System.out.println("print" + parentWindowId);
  	System.out.println("parent title" + driver.getTitle());
 	
  	String childWindowId = it.next();
  	System.out.println("print" + childWindowId);
 	
	System.out.println("child title" + driver.getTitle());
 	
	driver.switchTo().window(childWindowId);
	Select se = new Select(driver.findElement(By.xpath("//select[@id='multipck_value1']")));
 
	 se.selectByValue("5");
  	 
 	driver.switchTo().window(parentWindowId); 
 	  	    	 			
   
	}

}
