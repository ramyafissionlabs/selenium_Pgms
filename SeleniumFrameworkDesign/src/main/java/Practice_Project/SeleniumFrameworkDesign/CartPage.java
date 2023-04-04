package Practice_Project.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Practice_Project.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent
{
	WebDriver driver;
	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List <WebElement> cart_items;
	
	
	public Boolean cart_item_list(String prod_text)
	{
		click_cart();
		Boolean status = cart_items.stream().anyMatch(cart_item->cart_item.getText().equalsIgnoreCase(prod_text));
	    return status;
	}
	public CheckOutPage go_checkout()
	{
		checkout_click();
		CheckOutPage chp = new CheckOutPage(driver);
		return chp; 
		
	}

}
