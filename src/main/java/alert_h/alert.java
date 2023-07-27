package alert_h;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.issuewire.com/signup/pricing/");
		 
		 
		 
		 WebElement ele = driver.findElement(By.xpath("//div[@class='text-center']//button[@id='instamojo']"));
		 
		 Actions act = new Actions(driver);
			act.moveToElement(ele).click(ele);
//		 
//		
//		 
//		 Alert alert = driver.switchTo().alert();
//		 
//		 System.out.println(alert.getText());
//		 String text = alert.getText();
//		 if(text.equals("Please enter a valid user name")) {
//			 System.out.println("Correct alert");
//		 }
//			 else {
//				 System.out.println("Incorrect alert");
//			 }
//		 
//		 
//		 alert.accept(); //ok button
//		 
		// alert.dismiss(); //cancel button
		
		
		 
//driver.findElement(By.xpath("//*[@id=\"musicstart\"]/div[3]/p/span/text()[2]")).click();
//    
//    
//    String title = driver.getTitle();
//    System.out.println("Price : - " + title);
		 
		 
		
		
	}

}
