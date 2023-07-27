package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class checkBrokenLink {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://thebizsolutions.com/yorkpedia/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No. of links are : " + links.size());
		List<String> url = new ArrayList<String>();

		// Extract all URLs from the links and add them to the url list
		for (WebElement e : links) {
			String urlList = e.getAttribute("href");
			url.add(urlList);
		}

		// Check for broken links
//		for (String linkUrl : url) {
//			checkBroken(linkUrl);
//		}
		
		long StartTime = System.currentTimeMillis();
		url.parallelStream().forEach(e -> checkBroken(e));
		long EndTime = System.currentTimeMillis();
		
		System.out.println("Total Time Taken Is :- " +(EndTime - StartTime));
	}
	
	public static void checkBroken(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setConnectTimeout(5000);
			httpConn.connect();

			if (httpConn.getResponseCode() >= 400) {
				System.out.println(linkUrl + " ---> " + httpConn.getResponseMessage() + " is a broken link");
			} else {
				System.out.println(linkUrl + " ---> " + httpConn.getResponseMessage());
			}
			httpConn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
	}
	}
}
