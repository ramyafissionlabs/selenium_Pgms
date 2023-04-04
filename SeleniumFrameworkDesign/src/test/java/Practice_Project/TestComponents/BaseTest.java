package Practice_Project.TestComponents;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Practice_Project.SeleniumFrameworkDesign.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public WebDriver driver;
	public LoginPage lp;
	public WebDriver initializeDriver() throws IOException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Prctice_Project\\Resources\\GlobalData.properties");
		prop.load(fis);
		//String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.contains("chrome"))
		{
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			//driver = new ChromeDriver(options);
			driver = WebDriverManager.chromedriver().capabilities(options).create();
			//driver.manage().window().setSize(new Dimension(1440,900));
		
			
		}
	else if (browserName.equalsIgnoreCase("firefox")) 
		{
		//driver = new FirefoxDriver(options)
			//WebDriverManager.firefoxdriver().setup();
		driver = WebDriverManager.firefoxdriver().create();
		}
	else if (browserName.equalsIgnoreCase("edge"))
		{
			//WebDriverManager.edgedriver().setup();
			driver = WebDriverManager.edgedriver().create();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//return driver;
		return driver;
		
	}
	
	public List<HashMap<String,String>> getJsonDataToMap(String filepath) throws IOException
	{
		//read json to String
		String jsonContent= FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		//String to HashMAp Jackson DataBind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage launch_app() throws IOException
	{
		
		driver = initializeDriver();
		lp = new LoginPage(driver);
		lp.launch();
		return lp;
	}
	@AfterMethod(alwaysRun = true)
	public void tear_down()
	{
		//driver.close();
	}
	 
	
}
