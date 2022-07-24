package SeleniumAdvance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableValidation {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/table.html");

		//Get the count of number of columns
		List<WebElement> columns = driver.findElements(By.tagName("th"));
		int columncount = columns.size();
		System.out.println("No of columns are :" + columncount);


		//Get the count of number of rows
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		int rowcount = rows.size();
		System.out.println("No of columns are :" + rowcount);

		Thread.sleep(3000);
		
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\kirubhakaran.murugan\\Pictures\\Screenshots\\sample.jpg");		
		org.openqa.selenium.io.FileHandler.copy(source, dest);
		
		
		
		List<WebElement> progressvalues = driver.findElements(By.
				xpath("//td[normalize-space()='Learn to interact with Elements' ]//following::td[1]"));
		int valuecount = progressvalues.size();
		System.out.println("progress value of Learn to interact with Elements :" + progressvalues);
		System.out.println("Total progress values of Learn to interact with Elements :" + valuecount);

		//Check the vital task for the least completed progress.

		List<WebElement> Totalprogress = driver.findElements(By.xpath("//td[2]"));
		
		//Creating integer list for storing the converted values
		List<Integer> Intvalues = new ArrayList<Integer>();

		
		for (WebElement onebyone : Totalprogress) {
			//removing % symbol from the string so that while converting it into integer it will be easy for compare
			String individualprogress = onebyone.getText().replace("%", "");
			//Integer.parseInt is a method which will convert string into an integer
			Intvalues.add(Integer.parseInt(individualprogress));

		}

		System.out.println(Intvalues);

		Thread.sleep(3000);
		
		//find the least progress
		int leastvalue = Collections.min(Intvalues);
		System.out.println("The least progress is : " + leastvalue);
		//Integer.toString is a method which will convert integer into a string
		String leastvaluestring =Integer.toString(leastvalue)+"%";
		
		//writing xpath for least vital		
		String leastxpath ="//td[normalize-space()=" + "\"" + leastvaluestring + "\"" + "]" + "//following::td[1]";
		System.out.println(leastxpath);
			
	
		//Check the vital task
		
		WebElement leastvital = driver.findElement(By.xpath(leastxpath));
		leastvital.click();

		Thread.sleep(3000);
		//find the highest progress
		int highestvalue = Collections.max(Intvalues);
		System.out.println("The highest progress is : " + highestvalue);

		String highestvaluestring =Integer.toString(highestvalue)+"%";
		
		//writing xpath for highest vital
		String highestxpath ="//td[normalize-space()=" + "\"" + highestvaluestring + "\"" + "]" + "//following::td[1]";
		System.out.println(highestxpath);
		
		//Check the vital task
		
		WebElement highestvital = driver.findElement(By.xpath(highestxpath));
		highestvital.click();
		
		driver.quit();
	}

}

