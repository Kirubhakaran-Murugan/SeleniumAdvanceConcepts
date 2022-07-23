package SeleniumAdvance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFramesValidation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/frame.html");

		//changing the control from default HTML content to iframe

		driver.switchTo().frame(0);

		WebElement firstframe = driver.findElement(By.id("Click"));
		firstframe.click();

		String text = driver.findElement(By.id("Click")).getText();
		System.out.println(text);

		//moving the focus to native html 
		driver.switchTo().defaultContent();

		//moving the focus to first iframe 
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");

		WebElement nestedframe = driver.findElement(By.id("Click1"));
		nestedframe.click();

		driver.switchTo().defaultContent();
		//Find the total number of iframes
		Thread.sleep(2000);

		List<WebElement> totalframes = driver.findElements(By.tagName("iframe"));
		int framecount = totalframes.size();
		System.out.println(framecount);

		driver.quit();
	}

}
