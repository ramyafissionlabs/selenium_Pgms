package Practice_Project.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Practice_Project.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	WebDriver driver;
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//List<WebElement> products = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
	@FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
	List<WebElement> products;
	
	By products_by = By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']");
	By cart = By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");
	//WebElement element = driver.findElement(By.cssSelector(".ng-animating"));
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	public List<WebElement> product_List()
	{
		WaitforElementtobeAppear(products_by);
		return  products;
	}
	
	public WebElement getProductByText( String prod_text)
	{
		WebElement prod = product_List().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prod_text)).findFirst().orElse(null);
		return prod;
	}
	public CartPage AddtoCart(String prod_name)
	{
		WebElement prod = getProductByText(prod_name);
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		prod.findElement(cart).click();
		WaitforElementtobeAppear(toastmessage);
		WaitforElementtobeDisappear(spinner);
		CartPage cp = new CartPage(driver);
		return cp;
	}

}
