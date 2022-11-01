package alert_h;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		 
		 driver.findElement(By.xpath("//input[@name='proceed']")).click();
		 
		
		 
		 Alert alert = driver.switchTo().alert();
		 
		 System.out.println(alert.getText());
		 String text = alert.getText();
		 if(text.equals("Please enter a valid user name")) {
			 System.out.println("Correct alert");
		 }
			 else {
				 System.out.println("Incorrect alert");
			 }
		 
		 
		 alert.accept(); //ok button
		 
		// alert.dismiss(); //cancel button
		
		
		
		
	}

}
