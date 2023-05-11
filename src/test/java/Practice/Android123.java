package Practice;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Android123 {
	public static void main(String[] args) throws InterruptedException, MalformedURLException, AWTException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");

		AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		
		 AndroidDriver driver1 = (AndroidDriver) driver; 
		 driver1.openNotifications();
		 
		 WebElement ele = driver.findElement(By.xpath("//android.widget.Switch[contains(@content-desc,'Wi-Fi,')]"));
		 Actions act = new Actions(driver);
		 act.clickAndHold(ele).build().perform();
		 
		 driver.findElement(By.xpath("//android.widget.Switch[@resource-id='com.coloros.wirelesssettings:id/switchWidget']")).click();
		
		 for (int i = 1; i <=1; i++) {
			driver.findElement(By.xpath("//android.widget.TextView[@text='WI-FI NETWORKS']/../../following-sibling::android.widget.LinearLayout["+i+"]")).click();
			
		}
	}
}
