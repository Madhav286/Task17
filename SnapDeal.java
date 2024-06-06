package LoginVerification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {
	

	    public static void main(String[] args) {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "/Applications/Google\\ Chrome.app ");

	        // Initialize the Chrome driver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Step 1: Open the browser and navigate to the Snapdeal website
	            driver.get("http://www.snapdeal.com");

	            // Step 2: Move the cursor to the Sign In button and hold it
	            Actions actions = new Actions(driver);
	            WebElement signInButton = driver.findElement(By.className("accountUser"));
	            actions.moveToElement(signInButton).perform();

	            // Step 3: Click on the Sign In button
	            WebElement loginButton = driver.findElement(By.xpath("//span[text()='Login']"));
	            loginButton.click();

	            // Wait for the login frame to appear and switch to it
	            driver.switchTo().frame(driver.findElement(By.id("loginIframe")));

	            // Step 4: Enter a valid Email Id in the Email Id field
	            WebElement emailField = driver.findElement(By.id("userName"));
	            emailField.sendKeys("dummyemail@example.com");

	            // Step 5: Click on the Continue button
	            WebElement continueButton = driver.findElement(By.id("checkUser"));
	            continueButton.click();

	            // Step 6: Enter the valid password in the Password field
	            // You might need to wait for the password field to be visible
	            Thread.sleep(2000); // Add an explicit wait or use WebDriverWait for better practice
	            WebElement passwordField = driver.findElement(By.id("j_password_login_uc"));
	            passwordField.sendKeys("dummypassword");

	            // Step 7: Click on the Login button
	            WebElement loginSubmitButton = driver.findElement(By.id("submitLoginUC"));
	            loginSubmitButton.click();

	            // Step 8: Verify that the user is logged in successfully
	            Thread.sleep(3000); // Wait for the login to complete, use WebDriverWait in real scenarios
	            if (driver.findElement(By.className("accountUserName")) != null) {
	                System.out.println("Login successful!");
	            } else {
	                System.out.println("Login failed!");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Step 9: Close the browser
	            driver.quit();
	        }
	    }
	}


