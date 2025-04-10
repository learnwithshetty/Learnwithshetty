package day30;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;  

public class Naukri_Automation {

	public static void main(String[] args) {

		        WebDriver driver = new ChromeDriver();  

		        try {  
		            driver.manage().window().maximize();  
		            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		            driver.get("https://www.naukri.com/");  
		            WebElement loginButton = driver.findElement(By.id("login_Layer"));  
		            loginButton.click();   
		            WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"));  
		            WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Enter your password']")); 
		            String email = System.getenv("EMAIL_ID");  
		            String password = System.getenv("PASSWORD");  
		            if (email == null || email.isEmpty()) {  
		                throw new IllegalArgumentException("Email ID cannot be null or empty");  
		            }  
		            if (password == null || password.isEmpty()) {  
		                throw new IllegalArgumentException("Password cannot be null or empty");  
		            }  
		            emailField.sendKeys(email);  
		            passwordField.sendKeys(password);    
		            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));  
		            submitButton.click();  
		            Thread.sleep(5000);  
		            driver.get("https://www.naukri.com/mnjuser/profile");  
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
		            WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Update resume']")));
		            WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));
		            String filePath = "C:\\Users\\Rohith R\\eclipse-workspace\\August14_Selenium\\Files\\Rohith_CV_profession.pdf";
		            uploadElement.sendKeys(filePath);
		           
		            Thread.sleep(5000);  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        } finally {  
		      
		            driver.quit();  
		        }  
		    }  
		

	}


