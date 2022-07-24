package SeleniumAdvance;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CalendarValidation {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Calendar.html");
		//Screenshot 1
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\kirubhakaran.murugan\\Pictures\\Screenshots\\calendar1.png");
		FileHandler.copy(source, dest);

		//directly passing dates using send keys
		WebElement calenderbox = driver.findElement(By.id("datepicker"));
		calenderbox.sendKeys("06/10/2022"+ Keys.ENTER);

		//select the dates from the calendar itself		
		WebElement nextbutton = driver.findElement(By.xpath("//a[@title='Next']"));
		nextbutton.click();
		
		/*
		 * //Xpath of back button WebElement backbutton =
		 * driver.findElement(By.xpath("//a[@title='Prev']")); backbutton.click();
		 */
		
		//Select 10th day of following month
	
		WebElement date = driver.findElement(By.xpath("//a[contains(text(),\"10\")]"));
		date.click();
		//Screenshot 2
		File source1 = screenshot.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\Users\\kirubhakaran.murugan\\Pictures\\Screenshots\\calendar2.png");
		FileHandler.copy(source1, dest1);




	}

}
