package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Marlo {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
	driver.get("https://app.marlo.co/login");
	
	
	// Find the element that contains the shadow DOM
	WebElement sh = driver.findElement(By.xpath("//img[@style='max-height: 50px; position: relative; z-index: 9;']"));
	System.out.println(sh.isDisplayed());
	sh.click();
	
	WebElement shadowhost = driver.findElement(By.xpath("//flt-glass-pane[contains(@style,'position')]"));
	System.out.println(shadowhost.isDisplayed());
	
	SearchContext shadowroot = shadowhost.getShadowRoot();
	System.out.println(shadowroot);
	
	
	Actions act = new Actions(driver);
	act.moveByOffset(285, 309).click().build().perform();
	
	
	
	
	
	
	

}

}
