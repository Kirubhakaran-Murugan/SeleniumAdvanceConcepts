package SeleniumAdvance;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class LinkAdvance {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Link.html");

		//Identify and click Homepage link by using link text
		WebElement Home1 = driver.findElement(By.linkText("Go to Home Page"));
		Home1.click();

		driver.navigate().back();		

		//Identify and click Homepage link by using partial link text
		WebElement Home2 = driver.findElement(By.partialLinkText("Home"));
		Home2.click();

		driver.navigate().back();

		//Identify where the link supposed to go without click that link-->use get attribute("href")

		WebElement where = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"));
		String url = where.getAttribute("href");
		System.out.println("The link is supposed to go :" + url);

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\kirubhakaran.murugan\\Pictures\\Screenshots\\linkss.png");
		FileHandler.copy(source, dest);



		//Identify whether the link is broken or not

		WebElement brokenlink = driver.findElement(By.partialLinkText("broken"));
		brokenlink.click();

		String title = driver.getTitle();
		if(title.contains("404")) {
			System.out.println("The link is broken");
		}

		File source1 = screenshot.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\Users\\kirubhakaran.murugan\\Pictures\\Screenshots\\link2ss.png");
		FileHandler.copy(source1, dest1);

		driver.navigate().back();

		//Go to Home Page (Interact with same link name)
		//we shouldnt use the already identified homepage link because 
		//after every refresh the property of a weblement might change, so it will throw stale element reference exception
		WebElement Home3 = driver.findElement(By.partialLinkText("Home"));
		Home3.click();

		driver.navigate().back();

		//Identify the no of links present in the page
		List<WebElement> numberlink = driver.findElements(By.tagName("a"));
		int totallink = numberlink.size();
		System.out.println("Total no of links :"+ totallink);

		File source2 = screenshot.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("C:\\Users\\kirubhakaran.murugan\\Pictures\\Screenshots\\link3ss.png");
		FileHandler.copy(source2, dest2);

		driver.quit();
	}

}
