package Practice_Project.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Practice_Project.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("kalyanr@gmail.com");
	//driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Kalyan@1");
	//driver.findElement(By.xpath("//input[@id='login']")).click();

	@FindBy(xpath = "//input[@id='userEmail']")
	 WebElement useremail;
	@FindBy(xpath = "//input[@id='userPassword']")
	 WebElement userpassword;
	@FindBy(xpath = "//input[@id='login']")
	 WebElement userlogin;
	/*@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;*/
	
	@FindBy(xpath="//div[@id='toast-container']//div[@role='alertdialog']")
	WebElement errormsg;
	/*@FindBy(xpath ="//div[@id='toast-container']/div[@class='ng-tns-c4-16 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error ng-animating']/div[@class='ng-tns-c4-13 toast-message ng-star-inserted']")
	 WebElement errormsg;*/
	public ProductCatalog loginapplication(String email,String password)
	{
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		userlogin.click();
		ProductCatalog pc = new ProductCatalog(driver);
		return pc; 
		
	}
	public void launch()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String get_errormsg_text() throws InterruptedException
	{
		WaitforElementtobeAppear(errormsg);
		String err_text = errormsg.getText();
		

		return err_text;
	}
	
	
	
	
	
	
	
	
}
