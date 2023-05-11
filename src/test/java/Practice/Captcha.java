package Practice;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Captcha {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://unifiedportal-mem.epfindia.gov.in/memberinterface/");

		WebElement ele = driver.findElement(By.xpath("//img[contains(@src,'captcha/createCaptcha')]"));
		ele.isDisplayed();

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		String dateTimeString = now.format(formatter);
		Thread.sleep(2000);
		File screensshot = ele.getScreenshotAs(OutputType.FILE);

		// create file path with local date and time
		String filePath = "D://Screenshot/" + dateTimeString + ".png";
		File outputScreenshot = new File(filePath);

		// save screenshot to file

		try {
			BufferedImage img = ImageIO.read(screensshot);
			ImageIO.write(img, "png", outputScreenshot);
			System.out.println("Screenshot saved to: " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		
		Tesseract tesseract = new Tesseract();
		try {
			String text = tesseract.doOCR(outputScreenshot);
			System.out.println(text);
		} catch (TesseractException E) {
			E.printStackTrace();
		}
		
		driver.quit();
}
}