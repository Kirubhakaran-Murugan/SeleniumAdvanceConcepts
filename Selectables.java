package SeleniumAdvance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectables {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/selectable.html");

		//Select first 5 elements

		List <WebElement> allelements = driver.findElements(By.xpath("//*[@id=\'selectable\']/li"));

		Actions action = new Actions(driver);

		//Select the elements using keydown method
		action.keyDown(Keys.CONTROL).click(allelements.get(0))
		.click(allelements.get(1)).click(allelements.get(2)).click(allelements.get(3))
		.click(allelements.get(4)).build().perform();
		Thread.sleep(3000);

		//Select the elements using click and hold method
		action.clickAndHold(allelements.get(6)).clickAndHold(allelements.get(5)).build().perform();
		Thread.sleep(3000);
		
		//select all 7 elements again using click and hold and validate that all 7 elements
		action.clickAndHold(allelements.get(6))
		.clickAndHold(allelements.get(5))
		.clickAndHold(allelements.get(4))
		.clickAndHold(allelements.get(3))
		.clickAndHold(allelements.get(2))
		.clickAndHold(allelements.get(1))
		.clickAndHold(allelements.get(0))
		.build().perform();
		Thread.sleep(3000);
		
		//select all 7 elements again using keydown and click and validate that all 7 elements
		action.keyDown(Keys.CONTROL).click(allelements.get(0))
		.click(allelements.get(1)).click(allelements.get(2)).click(allelements.get(3))
		.click(allelements.get(4)).click(allelements.get(5)).click(allelements.get(6))
		.build().perform();
		Thread.sleep(3000);
		
		driver.quit();
	}

}
