package SeleniumAdvance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTipText {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://leafground.com/pages/tooltip.html");
		
		//Tool Tip Validation
		
		WebElement Tooltip = driver.findElement(By.id("age"));
		//Mostly tool tip text will be present in title attribute
		String Tooltipname = Tooltip.getAttribute("title");
		System.out.println("Tool tip name is :" + Tooltipname);

		driver.quit();
	}

}
