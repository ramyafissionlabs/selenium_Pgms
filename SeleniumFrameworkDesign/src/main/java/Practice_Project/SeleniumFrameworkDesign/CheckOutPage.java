package Practice_Project.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Practice_Project.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent
{
WebDriver driver;
public CheckOutPage(WebDriver driver)
{
	super(driver);
	this.driver = driver;
	PageFactory.initElements(driver, this);
}


@FindBy(xpath = "//input[@placeholder='Select Country']")
WebElement dropdown;
By re_l = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']/button")
List<WebElement> ldropdown;
@FindBy(xpath = "//div/a[@class='btnn action__submit ng-star-inserted']")
WebElement place_ord;
public void checkout_process(String country)
{
	dropdown.sendKeys(country);
}
public void country_match(String contry_match)
{
    WaitforElementtobeAppear(re_l);	
	WebElement dp_i = ldropdown.stream().filter(dropdown_i->dropdown_i.getText().equalsIgnoreCase(contry_match)).findFirst().orElse(null);;
	dp_i.click();
		
}
public ConfirmationPage ord_click() {
	place_ord.click();
	ConfirmationPage op = new ConfirmationPage(driver);
	return op;

	
}




}
