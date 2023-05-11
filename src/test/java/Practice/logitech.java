package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class logitech {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.mevo.com/products/quick-release-ball-mount");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("(//span[.='Add to Cart'])[2]")).click();
}
}
