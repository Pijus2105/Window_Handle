package conterian;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class price {

	public static void main(String[] args) throws Exception {


		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.conterian.com/");
		
		driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[5]")).click();
		
		WebElement order = driver.findElement(By.xpath("//*[@id='calculator']/div[2]/div/form/div/input"));
		order.sendKeys("pijus@elphilltechnology.com");
		
		
		driver.manage().deleteAllCookies();
		
		order.sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);
		
	//	driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.navigate().refresh();

	}

}
