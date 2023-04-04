package Practice_Project.SeleniumFrameworkDesign;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Practice_Project.TestComponents.BaseTest;

import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class StandaloneTest extends BaseTest {
	String prod_text = "zara coat 3";

	@Test(dataProvider = "getdata", groups = { "purchase" })
	// public void submit_order(String email,String pwd,String prod_text)
	public void submit_order(HashMap<String, String> input) throws IOException {
		// lp = launch_app();
		ProductCatalog pc = lp.loginapplication(input.get("email"), input.get("pwd"));
		List<WebElement> products = pc.product_List();
		WebElement prod = pc.getProductByText(input.get("prod_text"));
		CartPage cp = pc.AddtoCart(input.get("prod_text"));
		Boolean match = cp.cart_item_list(input.get("prod_text"));
		Assert.assertTrue(match);
		CheckOutPage chp = cp.go_checkout();
		String country = "aus";
		chp.checkout_process(country);
		String contry_match = "Australia";
		chp.country_match(contry_match);
		ConfirmationPage op = chp.ord_click();
		String va_text = op.verify_confirm_msg();
		String ve_text = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(va_text, ve_text);
		//// div[@id='toast-container]'/div[@class='ng-tns-c4-13 toast-message
		//// ng-star-inserted']

	}

	@Test(dependsOnMethods = { "submit_order" })
	public void orderdisplay() {
		ProductCatalog pc = lp.loginapplication("kalyanr@gmail.com", "Kalyan@1");
		OrdersPage op = pc.click_orders();
		Assert.assertTrue(op.verify_order_display(prod_text));

	}
	
	
	/*
	 * @DataProvider public Object[][] getdata() { return new Object[][]
	 * {{"kalyanr@gmail.com","Kalyan@1","zara coat 3"},{"sidd@gmail.com",
	 * "Sidnnn@1","ADIDAS ORIGINAL"}} ; }
	 */
	@DataProvider
//public Object[][] getdata()
//{
//	HashMap<String, String> map = new HashMap<String,String>();
//	map.put("email", "kalyanr@gmail.com");
//	map.put("pwd", "Kalyan@1");
//	map.put("prod_text", "zara coat 3");
//	HashMap<String, String> map1 = new HashMap<String,String>();
//	map1.put("email", "sidd@gmail.com");
//	map1.put("pwd", "Sidnnn@1");
//	map1.put("prod_text", "ADIDAS ORIGINAL");
//	return new Object[][] {{map},{map1}};
//	
//	
//	
//
//}
	public Object[][] getdata() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//Practice_Project//Data//purchasedata.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
}