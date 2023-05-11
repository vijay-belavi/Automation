package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class magicBricks {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();

		driver.get(
				"https://www.magicbricks.com/property-for-sale/residential-real-estate?bedroom=1&proptype=Multistorey-Apartment,Builder-Floor-Apartment,Penthouse,Studio-Apartment&cityName=Bangalore");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[.='Budget' and contains(@class,'title')]")).click();
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//input[@class='filter-budget__range budget-min']"));
		int x = ele.getLocation().getX();
		int y = ele.getLocation().getY();
		System.out.println(x+" "+y);
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(ele, 1000, 208);
		

	}
}
