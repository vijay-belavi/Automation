package Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Android_Physical {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		String appPackage = "com.chaayos";
		String appActivity = "com.chaayos.MainActivity";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);

		AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		
		 AndroidDriver driver1 = (AndroidDriver) driver; 
		 
		 
		 driver1.pressKey(new KeyEvent(AndroidKey.ENTER));
		 
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Internet']")).click();
		 
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Wi‑Fi']")).click();
		 WebElement find = null;
		 find = driver.findElement(By.xpath("//android.widget.TextView[@text='Connected']"));
		 System.out.println(find.isDisplayed());
		 driver.findElement(By.xpath("(//android.widget.Switch)[2]")).click();
		
	}
}
