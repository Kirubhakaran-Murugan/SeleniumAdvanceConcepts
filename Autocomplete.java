package SeleniumAdvance;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompletion {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/autoComplete.html");
		
		//validate the textbox		
		WebElement textbox = driver.findElement(By.id("tags"));
		textbox.sendKeys("s");
		
		Thread.sleep(4000);
		//Use FindElements to retrive list of webelements
		List<WebElement> autocompletevalues = driver.findElements(By.xpath("//*[@id=\'ui-id-1\']/li"));
		int totalvalues = autocompletevalues.size();
		System.out.println(totalvalues);
		
		for (WebElement onebyone : autocompletevalues) {
			if(onebyone.getText().equals("Web Services")) {
				onebyone.click();
				System.out.println(onebyone);	
				break;
			}	
		}
		
		//Take screenshot using robot class
		
		/*Robot robot =new Robot();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(screen);
		BufferedImage source = robot.createScreenCapture(rectangle);
		File destination = new File ("C:\\Users\\kirubhakaran.murugan\\Pictures\\Screenshots\\autocomplete1.png");
		ImageIO.write(source, "png", destination);*/
		
		
		driver.quit();		
		
	}

}
