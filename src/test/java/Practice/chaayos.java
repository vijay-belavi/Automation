package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class chaayos {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://chaayos.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	
	WebElement frame = driver.findElement(By.id("cmessage_form_iframe"));
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(frame));
	
	driver.switchTo().frame("cmessage_form_iframe");
	Thread.sleep(3000);
	
	WebElement ele = driver.findElement(By.xpath("//div[@class='close_icon']"));
	ele.click();
	System.out.println("hi vijay");
	//String role = ele.getAttribute("xmlns");
	
	//System.out.println(role);
	
	//driver.quit();
}
}
