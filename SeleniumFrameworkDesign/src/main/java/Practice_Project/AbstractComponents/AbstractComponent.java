package Practice_Project.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Practice_Project.SeleniumFrameworkDesign.OrdersPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	@FindBy(xpath = "//li[@class='totalRow']/button[@class='btn btn-primary']")
	WebElement checkout;
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orders;
	

	public void WaitforElementtobeAppear(By findBy) {
		// "//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3
		// ng-star-inserted']"
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void WaitforElementtobeAppear(WebElement ele) {
		// "//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3
		// ng-star-inserted']"
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void WaitforElementtobeDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		// driver.findElement(By.cssSelector(".ng-animating"))));
	}

	
	public void click_cart() {
		cart.click();
	}

	public void checkout_click() {
		checkout.click();
	}
	public OrdersPage click_orders()
	{
		orders.click();
		OrdersPage op = new OrdersPage(driver);
		return op;
	}

	
}
