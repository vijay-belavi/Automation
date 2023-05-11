package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewClass {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://shop.polymer-project.org/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	WebElement shadowHost = driver.findElement(By.xpath("//shop-app[@page='home']"));
	SearchContext shadowRoot = shadowHost.getShadowRoot();
	WebElement element = shadowRoot.findElement(By.cssSelector("app-header > div > shop-tabs > shop-tab > a"));
	String elementText = element.getText();
	System.out.println(elementText);
	element.click();
	driver.quit();
	
}
}