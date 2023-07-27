package Multiple_Window;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowClass {

    public static void main(String[] args) throws InterruptedException {
    	 WebDriver driver;
       WebDriverManager.firefoxdriver().setup();
       driver = new FirefoxDriver();
       driver.manage().window().maximize();
       
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.newswire.com/newsroom/arts-and-entertainment");
        
        //Select all class of CSS
        WebElement links = driver.findElement(By.cssSelector(".row.masonry"));
        
        //All links in the in the set one Array, then make a list
        List<String> linkHrefs = new ArrayList<>();
        //All link will be listing
        List<WebElement> contentLinks = links.findElements(By.xpath("//a[@class='content-link']"));
        //Iterate and add all links in the array
        for (WebElement contentLink : contentLinks) {
            linkHrefs.add(contentLink.getAttribute("href"));
        }
        //Window Handles
        String mainTab = driver.getWindowHandle();
        //Iterate arraylist
        for (String linkHref : linkHrefs) {
            // Open link in a new tab using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open();");

            // Switch to the newly opened tab
            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();

            //Back to child Tab
            while (iterator.hasNext()) {
                String childTab = iterator.next();
                if (!childTab.equals(mainTab)) {
                    driver.switchTo().window(childTab);

                    // Open the link from the main page in the new tab
                    driver.get(linkHref);

                    // Perform your actions on the new tab here
                    List<WebElement> el = driver.findElements(By.xpath("//a[@aria-controls='collapseOne']"));
                    for (WebElement elem : el) {
                        elem.click();
                    }

                    // Check for email IDs
                    if (driver.findElements(By.xpath("//ul[@class='pr-contact-list']//a[@class='pr-contact-list__line pr-contact-list__line--email']")).size() != 0) {
                        Thread.sleep(1000);

                        WebElement grab2 = driver.findElement(By.xpath("//ul[@class='pr-contact-list']//a[@class='pr-contact-list__line pr-contact-list__line--email']"));
                        System.out.println("Email-id: " + grab2.getText());
                    } else {
                        System.out.println("Sorry, no email id exists.");
                    }

                    // Close the new tab after performing actions
                    driver.close();
                    break;
                }
            }

            // Switch back to the main tab and refresh the page
            driver.switchTo().window(mainTab);
            driver.navigate().refresh();
        }

        driver.quit(); // Quit the browser after all tabs are processed
    }
}

