package SeleniumAdvance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/sortable.html");

		//Printing no of elements present in the sortable
		List<WebElement> allsortable = driver.findElements(By.xpath("//*[@id=\'sortable\']/li"));
		int noofelements = allsortable.size();
		System.out.println("no of elements :" + noofelements);
		
		Actions actions = new Actions(driver);
		//Drag and drop the last element to the first position
		actions.clickAndHold(allsortable.get(6)).moveToElement(allsortable.get(0)).
		release(allsortable.get(0)).build().perform();
		
		Thread.sleep(2000);
		
		//Drag and drop the 3rd element to the 5th position
		actions.clickAndHold(allsortable.get(2)).moveToElement(allsortable.get(5)).
		release(allsortable.get(5)).build().perform();
		
		Thread.sleep(2000);
		
		//Drag and drop the 4rd element to the 2nd position
		actions.clickAndHold(allsortable.get(3)).moveToElement(allsortable.get(1)).
		release(allsortable.get(1)).build().perform();
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
