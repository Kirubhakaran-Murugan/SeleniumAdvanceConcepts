package SeleniumAdvance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/drop.html");

		WebElement From = driver.findElement(By.id("draggable"));
		WebElement To = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		//First way of drag and drop
		actions.clickAndHold(From).moveToElement(To).release(To).build().perform();
		//Another way of doing drag and drop
		//actions.dragAndDrop(From, To).build().perform();
		Thread.sleep(3000);
		
		driver.quit();
	}

}
