package SeleniumAdvance;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageValidation {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Image.html");
		
		//Click on this image to go home page		
		WebElement homepageimage = driver.findElement(
				By.xpath("//*[@id=\'contentblock\']/section/div[1]/div/div/img"));
		
		Robot robot = new Robot();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(screen);
		BufferedImage source = robot.createScreenCapture(rectangle);
		
		File dest =  new File("C:\\Users\\kirubhakaran.murugan\\Pictures\\Screenshots\\imagesnap.png");
		ImageIO.write(source, "png", dest);
		
		
		homepageimage.click();
		
		
		
		Thread.sleep(2000);
		//Going back to image page
		driver.navigate().back();
		Thread.sleep(2000);
		
		
		//Am I Broken Image? --use "naturalWidth" attribute
		WebElement brokenimage = driver.findElement(
				By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/img"));
		if(brokenimage.getAttribute("naturalWidth").equals("0")) {
			System.out.println("The image is broken");
		}else {
			System.out.println("The image is not broken");
		}
				driver.quit();
	}

}
