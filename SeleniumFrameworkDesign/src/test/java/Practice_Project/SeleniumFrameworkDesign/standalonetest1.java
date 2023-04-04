
	

	
package Practice_Project.SeleniumFrameworkDesign;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class standalonetest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("kalyanr@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Kalyan@1");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		String prod_text = "zara coat 3";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")));
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prod_text)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> cart_items = driver.findElements(By.xpath("//div[@class='cartSection']//h3"));
		Boolean status = cart_items.stream().anyMatch(cart_item->cart_item.getText().equalsIgnoreCase(prod_text));
		Assert.assertTrue(status);
		WebElement checkout = driver.findElement(By.xpath("//li[@class='totalRow']/button[@class='btn btn-primary']"));
		checkout.click();
		WebElement dropdown = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		dropdown.sendKeys("aus");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']"))));
		List<WebElement> ldropdown = driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button"));
		WebElement dp_i = ldropdown.stream().filter(dropdown_i->dropdown_i.getText().equalsIgnoreCase("Australia")).findFirst().orElse(null);
		dp_i.click();
		WebElement place_ord = driver.findElement(By.xpath("//div/a[@class='btnn action__submit ng-star-inserted']"));
		place_ord.click();
		WebElement ord_text = driver.findElement(By.xpath("//tbody/tr/td/h1[@class='hero-primary']"));
		String va_text = ord_text.getText();
		String ve_text = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(va_text, ve_text);
		//driver.quit();
//		for(WebElement prod:products)
//		
//		{
//			System.out.println(prod);
//			WebElement sp = prod.findElement(By.xpath("//div/h5/b"));
//			//System.out.println(sp);
//			String text = sp.getText();
//			System.out.println(text);
//			String atext = "zara coat 3";
//			if(text.equalsIgnoreCase(atext))
//			{
//				//System.out.println(text);
//				sp.findElement(By.xpath("//div[@class='card-body']//button[@class='btn w-10 rounded']")).click();
//			}
//		}

	}

}
