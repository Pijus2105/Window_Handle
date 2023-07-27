package canoNicalURL;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class url_Checker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://yorkpedia.com/category/consumer-goods/");

		
		WebElement link = driver.findElement(By.cssSelector("link[rel='canonical']"));
		String canonicalUrl = link.getAttribute("href");

		System.out.println("Canonical URL: " + canonicalUrl);

		//driver.quit();


	}

}
