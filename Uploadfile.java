package SeleniumAdvance;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadValidation {

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/upload");
		
		
		WebElement choosebutton = driver.findElement(By.id("file-upload"));
		choosebutton.click();
		
	   //Java code for window handeling
		
		//storing the file loctaion
		String filelocation = ("C:\\Downloads\\upload_file.xlsx");
		
		//stringselection class is used for transfer the data in a plain format
		StringSelection selection = new StringSelection(filelocation);
		
		//Copy the file location and keep it in system clip board
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		//Do Control V on the text field using robot class
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		//Click Enter
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		driver.quit();	
		

	}

}
