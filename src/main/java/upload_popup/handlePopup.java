package upload_popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlePopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://html.com/input-type-file/");
		 
		 driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Elphill\\Pictures\\Screenshots");
	}

}
