package Bug.HSB_82;

import java.net.URL;
import java.util.Set;



import java.util.concurrent.TimeoutException;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import junit.framework.Assert;

public class Goto_Bug {
	private static final String S = null;

	WebDriver driver;
	@BeforeTest
	
	public void setup() throws Exception
	{
		
		  DesiredCapabilities dc = DesiredCapabilities.chrome();
	        URL url = new URL("http://172.12.20.118:5555/wd/hub");
	        driver = new RemoteWebDriver(url, dc);
	
	       
	}

	@Test(priority=1)

	public void Login() throws InterruptedException {

		driver.get("http://apollo2.humanbrain.in/");

		driver.manage().window().maximize();

		System.out.println("-------------------------------------------------");

		System.out.println("The server is Opened");

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement viewerSectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'ng-tns-c93-3')]")));

		viewerSectionLink.click();

		System.out.println("-------------------------------------------------");

		System.out.println("The Viewer Icon has been clicked");

		String parentWindow = driver.getWindowHandle();

		WebDriverWait wait1 = new WebDriverWait(driver, 20);

		WebElement login = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));

		login.click();

		Thread.sleep(4000);

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {

			if (!window.equals(parentWindow)) {

				driver.switchTo().window(window);

				break;

			}

		}

		Thread.sleep(4000);

		WebDriverWait wait2 = new WebDriverWait(driver,20);

		WebElement  emailInput = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));

		emailInput.sendKeys("teamsoftware457@gmail.com");

		System.out.println("-------------------------------------------------");

		System.out.println("Mail I'd has been sucessfully entered");

		WebDriverWait wait3 = new WebDriverWait(driver,20);

		WebElement  Next = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));

		Next.click();

		System.out.println("-------------------------------------------------");

		System.out.println("The Next Button is clicked");

		WebDriverWait wait4 = new WebDriverWait(driver,20);

		WebElement  PasswordInput = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));

		PasswordInput.sendKeys("Health#123");

		System.out.println("-------------------------------------------------");

		System.out.println("Password as entered");

		WebDriverWait wait5 = new WebDriverWait(driver,20);

		WebElement  Next2 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));

		Next2.click();		

		System.out.println("-------------------------------------------------");

		System.out.println("The Next Button is clicked");

		System.out.println("-------------------------------------------------");

		Thread.sleep(5000);

		driver.switchTo().window(parentWindow);

		Thread.sleep(5000);

	}

	@Test(priority=2)



	public void table() {



		try {



			WebDriverWait wait6 = new WebDriverWait(driver,30);



			WebElement table1 = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Human fetus ']")));

			table1.click();

			System.out.println("-------------------------------------------------");

			System.out.println("HumanFetus TaB is clicked");

		}

		catch (Exception e) {

			System.out.println("-------------------------------------------------");

			System.out.println("HumanFetus TaB is not clicked");

		}

		try {

			WebDriverWait wait7 = new WebDriverWait(driver,30);

			WebElement table2 = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Brain ']")));

			table2.click();

			System.out.println("-------------------------------------------------");

			System.out.println("Brain Tab  is clicked");

		}

		catch(Exception e) {

			System.out.println("-------------------------------------------------");

			System.out.println("Brain Tab is not clicked");

		}

		try {

			WebDriverWait wait8 = new WebDriverWait(driver,30);

			WebElement table3 = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()=' FB_3']")));

			table3.click();	

			System.out.println("-------------------------------------------------");

			System.out.println("FB 3 is clicked");

		}

		catch(Exception e) {

			System.out.println("-------------------------------------------------");



			System.out.println("FB 3 is not clicked");

		}}	@Test(priority = 3)



		public void Brain_Id() {

			WebDriverWait wait = new WebDriverWait(driver, 50);

			try {



				WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Go To Section']")));

				Thread.sleep(3000);

				System.out.println("-------------------------------------------------");

				System.out.println("The Go to Text Box is displayed");

				inputElement.sendKeys("1249\n"); 

				Thread.sleep(3000);

				System.out.println("-------------------------------------------------");

				System.out.println("The Number has been Entered Sucessfully");

				WebElement E1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='atlasEditor']")));

				String Z = E1.getText();

				String expectedT10 = "B_37_FB3-SL_417-ST_NISL-SE_1249_thumbnail.jpg";

				Assert.assertEquals(expectedT10,Z);           

				System.out.println("Assertion passed: " + Z + " matches the expected value.");

			} catch (AssertionError e) {

				System.out.println("Assertion failed: " + e.getMessage());

			} catch (Exception e) {

				System.out.println("An error occurred: " + e.getMessage());

			}

		}



		@AfterTest

		public void tearDown() {

			if (driver != null) {

				driver.quit();

			}

		}
}
