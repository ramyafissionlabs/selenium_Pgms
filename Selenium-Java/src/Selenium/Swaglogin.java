package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Swaglogin
{
	WebDriver driver;
	//WebDriverWait wait;

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
   }
	  
	 @Test
	 public void logout() throws InterruptedException
	 {
		 driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		  WebElement logout = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		  wait.until(ExpectedConditions.visibilityOf(logout));
		  logout.click();
		   }
	  
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  String title = driver.getTitle();
	  System.out.println(title);
	  String url = driver.getCurrentUrl();
	  System.out.println(url);
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//input[@id='login-button']")).click();
	  
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
