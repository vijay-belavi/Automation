package Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Android_Wifi_Samsung {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");

		AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Swipe down from the top of the screen to reveal the notifications shade
		AndroidDriver driver1 = (AndroidDriver) driver;
		driver1.openNotifications();
		System.out.println("hello");
		
		/* 
		 * WebElement wifiIcon = driver .findElement(By.xpath(
		 * "//android.widget.ImageView[@resource-id='android:id/icon']")); Actions
		 * action = new Actions(driver);
		 * action.clickAndHold(wifiIcon).build().perform();
		 * 
		 * driver.findElement(By.xpath("//android.widget.Switch")).click();
		 * 
		 * for (int i = 1; i < 5; i++) { WebElement ele = driver.findElement(By.xpath(
		 * "(//android.widget.TextView[@text='Available networks']/following-sibling::androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout)["
		 * + i + "]")); ele.click(); Thread.sleep(2000);
		 * 
		 * try { if (driver.findElement(By.
		 * xpath("//android.widget.ImageButton[@content-desc='Navigate up']"))
		 * .isDisplayed()) { driver.findElement(By.
		 * xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
		 * } } catch(Exception w) { driver.findElement(By.xpath(
		 * "//android.widget.TextView[contains(@text,'Connected')]")).isDisplayed();
		 * WebElement ele1 = driver.findElement(By.xpath(
		 * "//android.widget.TextView[contains(@text,'Connected')]/preceding-sibling::android.widget.TextView"
		 * )); System.out.println(ele1.getText()); break; } }
		 * 
		 * driver.findElement(By.xpath(
		 * "//android.widget.TextView[contains(@text,'Connected')]/../following-sibling::android.widget.RelativeLayout"
		 * )) .click();
		 * 
		 * driver.findElement(By.xpath(
		 * "//android.widget.TextView[contains(@text,'Forget')]")).click();
		 * 
		 * driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'On')]"
		 * )).click();
		 */
	}
}

