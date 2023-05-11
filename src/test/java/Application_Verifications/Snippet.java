package Application_Verifications;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Snippet {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.gonoise.com/products/noise-colorfit-ultra-3-smartwatch");
		
		driver.findElement(By.xpath("//DIV[contains(@class,'product-details-new false')]//BUTTON[@class='btn add-to-cart-button']")).click();
		
		WebElement element = driver.findElement(By.xpath("//div[@id='gokwik-modal-wrapper']//iframe"));
		System.out.println(element.isDisplayed());
		
		driver.switchTo().frame(element);
		
		WebElement ele = driver.findElement(By.xpath("//h3[text()='Enter Mobile Number']"));
		System.out.println(ele.isDisplayed());
		
		WebElement ele1 = driver.findElement(By.xpath("//input[@placeholder='Enter Number']"));
		ele1.sendKeys("8792593183");
		
		
		//driver.quit();
}
}