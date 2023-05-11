package Practice;

import java.io.File;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AudioRecorder {
	private static final int SAMPLE_RATE = 16000;
	private static final int SAMPLE_SIZE_IN_BITS = 16;
	private static final int CHANNELS = 1;
	private static final boolean SIGNED = true;
	private static final boolean BIG_ENDIAN = false;

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    driver.manage().window().maximize();
		    driver.get("https://smartcare.sbilife.co.in/SmartCare/login/login.html");
		    driver.findElement(By.xpath("//img[@class='volume' and @alt='RVoice captcha']")).click();

		    AudioFormat format = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE_IN_BITS, CHANNELS, SIGNED, BIG_ENDIAN);
		    DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		    TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
		    line.open(format);
		    line.start();

		    Timer timer = new Timer();
		    timer.schedule(new TimerTask() {
		        @Override
		        public void run() {
		            line.stop();
		            line.close();
		        }
		    }, TimeUnit.SECONDS.toMillis(5)); // specify the recording duration in seconds

		    byte[] buffer = new byte[1024];
		    int bytesRead = 0;

		    try (AudioInputStream stream = new AudioInputStream(line)) {
		        AudioSystem.write(stream, AudioFileFormat.Type.WAVE, new File("D://Screenshot/audioRecord.wav"));
		    }

		    timer.cancel();
		driver.manage().deleteAllCookies();
		driver.quit();

	}
}
