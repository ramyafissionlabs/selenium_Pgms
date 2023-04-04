package Selenium;

import static org.testng.AssertJUnit.assertEquals;

import java.time.Duration;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	WebDriver driver;
//  @Test
//  public void LoginCredentials() throws InterruptedException 
//  {
//	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
//	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
//	  driver.findElement(By.xpath("//input[@id='login-button']")).click();
//  }
 @Test
  public void Addtocart() throws InterruptedException 
  {
      driver.findElement(By.xpath("//button[contains(@id,'labs-backpack')]")).click();
	  driver.findElement(By.xpath("//a[contains(@class,'shopping_cart_link')]")).click();
	  Thread.sleep(2000);
  }
   @Test
   public void checkout() throws InterruptedException
   {
	  driver.findElement(By.xpath("//button[@id='checkout']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("sid");
	  driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("n");
	  driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("33");
   }
   @Test
   public void continueshop() throws InterruptedException
   {
	  driver.findElement(By.xpath("//input[@id='continue']")).click();
	  driver.findElement(By.xpath("//button[@id='finish']")).click();
	  String expctd = driver.findElement(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")).getText();
	  Thread.sleep(2000);
	  String actl = "THANK YOU FOR YOUR ORDER";
	  Assert.assertEquals(expctd,actl);
	 // Thread.sleep(1000);
	  
  }
  @Test
  public void logout()
  {
	  driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
	  WebElement logout = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	  wait.until(ExpectedConditions.visibilityOf(logout));
	  logout.click();
	  
  }
  @BeforeClass
  public void beforeClass() {
	  
//	  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//driver//geckodriver.exe");
//	  driver = new FirefoxDriver();
	  
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver.exe");
	  driver = new ChromeDriver();
	  
//	  System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//driver//msedgedriver.exe");
//	  driver = new EdgeDriver();
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  String title = driver.getTitle();
	  System.out.println(title);
	  String url = driver.getCurrentUrl();
	  System.out.println(url);
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//input[@id='login-button']")).click();
 
	 
	 
	  
  }

  @AfterClass
  public void afterClass() {
	   
	  driver.quit();
  }

}
