package day30;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;  
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;  


public class Linkedin_Automation {

	public static void main(String[] args) throws InterruptedException {
		        WebDriver driver = new ChromeDriver();  
		        driver.manage().window().maximize();
		        
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 

		        try {  
		            driver.get("https://www.linkedin.com/uas/login?session_redirect=https%3A%2F%2Fwww.linkedin.com%2Ffeed%2F");  
		            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("session_key"))).sendKeys("shetty2297@gmail.com");  
		            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("session_password"))).sendKeys("Mrshetty@0297");  
		            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"btn__primary--large from__button--floating\"]"))).click();  
		            Thread.sleep(7000);
		            driver.get("https://www.linkedin.com/jobs/");  
		            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[6]/header[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/input[1]")));  
		            searchBox.sendKeys("#testing and #hiring");  
		            Actions actions = new Actions(driver);  
		            actions.moveToElement(searchBox).sendKeys(Keys.ENTER).perform();
		            List<WebElement> posts = driver.findElements(By.cssSelector("div.feed-shared-update-v2"));  
		            System.out.println("Recent Hiring Posts for " + hashtags + ":");  
		            
		            for (WebElement post : posts) {  
		                String author = post.findElement(By.cssSelector("span.feed-shared-actor__name")).getText();  
		                String content = post.findElement(By.cssSelector("div.feed-shared-text")).getText();  

		                // Print the extracted data  
		                System.out.println("Author: " + author);  
		                System.out.println("Content: " + content);  
		                System.out.println("-------------------------------------------------");  
		            }  

		        } catch (Exception e) {  
		            e.printStackTrace();  
		        } finally {  
		            // Closing the browser  
		            driver.quit();  
		        }  

		        }  
		    }  
		
