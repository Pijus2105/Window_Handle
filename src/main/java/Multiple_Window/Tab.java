package Multiple_Window;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tab {

	public static void main(String[] args) throws InterruptedException {


		        // TODO Auto-generated method stub

		        WebDriver driver;
		        WebDriverManager.firefoxdriver().setup();
		        driver = new FirefoxDriver();
		        driver.manage().window().maximize();
		        
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		        driver.get("https://www.newswire.com/newsroom/arts-and-entertainment-books");

		        WebElement links = driver.findElement(By.cssSelector(".row.masonry"));

		        System.out.println(links.findElements(By.xpath("//a[@class='content-link']")).size());

		        for (int i = 1; i < links.findElements(By.xpath("//a[@class='content-link']")).size(); i++) {
		            String tablink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		            
		            links.findElements(By.xpath("//a[@class='content-link']")).get(i).sendKeys(tablink);
		            
		            
		        }
		        
		        Set<String> s = driver.getWindowHandles();
		        Iterator<String> I1 = s.iterator();
		        

		        while (I1.hasNext()) {

		            String child_window = I1.next();
		            driver.switchTo().window(child_window);
		            List<WebElement> el = driver.findElements(By.xpath("//a[@aria-controls='collapseOne']"));
		            

		            for (WebElement elem : el) {
		                elem.click();
		                
		            }

		            if (driver.findElements(By.xpath("//ul[@class='pr-contact-list']//a[@class='pr-contact-list__line pr-contact-list__line--email']")).size() != 0) {
		                Thread.sleep(1000);
		                
		                // System.out.println("Email is Present");
		                WebElement grab2 = driver.findElement(By.xpath("//ul[@class='pr-contact-list']//a[@class='pr-contact-list__line pr-contact-list__line--email']"));
		                System.out.println("Email-id" + grab2.getText());
		            } else {
		                System.out.println("Sorry, your email id doesn't exist");
		            }

		        }
		    }
		

	}


