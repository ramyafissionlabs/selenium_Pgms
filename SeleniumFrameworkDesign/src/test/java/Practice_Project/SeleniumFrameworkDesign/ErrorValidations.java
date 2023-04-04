package Practice_Project.SeleniumFrameworkDesign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;



import Practice_Project.TestComponents.BaseTest;
import Practice_Project.TestComponents.Retry;

public class ErrorValidations extends BaseTest
{
	
	
	@Test(groups = {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void Error_log() throws IOException, InterruptedException
	{
		//lp = launch_app();
		lp.loginapplication("kalyanr@gmail.com", "Kalyan@");
		String aer_text = lp.get_errormsg_text();
		String eer_text = "Incorrect email or password.";
		Assert.assertEquals(aer_text, eer_text);
	}
}
