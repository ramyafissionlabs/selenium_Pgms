package Practice_Project.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Practice_Project.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent 
{
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> products_names_ord_page;
	public Boolean verify_order_display(String prod_text)
	{
		click_orders();
		Boolean status = products_names_ord_page.stream().anyMatch(cart_item->cart_item.getText().equalsIgnoreCase(prod_text));
	    return status;
	}

}
