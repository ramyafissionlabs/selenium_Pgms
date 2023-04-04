package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Example {
	WebDriver driver;
  @Test
  public void LoginCredentials() {
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//input[@id='login-button']")).click();
  }
  @Test
  public void Addtocart()  
  {
      driver.findElement(By.xpath("//button[contains(@id,'labs-backpack')]")).click();
	  driver.findElement(By.xpath("//a[contains(@class,'shopping_cart_link')]")).click();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//driver//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
