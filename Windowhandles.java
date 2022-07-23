package SeleniumAdvance;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.leafground.com/pages/Window.html");
		
		//store the parent window using get window handle
		String parentwindow = driver.getWindowHandle();

		WebElement homebutton = driver.findElement(By.id("home"));
		homebutton.click();
		
		//store all opened windows using get window handles
		Set<String> allwindows1 = driver.getWindowHandles();
		
		//changing permission from parent window to child window		
		for (String Newwindow : allwindows1) {
			
			driver.switchTo().window(Newwindow);
		}
		
		//perform operation in child window
		WebElement editbutton = driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a/h5"));
		editbutton.click();
		
		WebElement emailbox = driver.findElement(By.id("email"));
		emailbox.sendKeys("kirubha@gmail.com");
		
		Thread.sleep(3000);
		driver.close();
		
		//changing permission from child window to parent window
		
		driver.switchTo().window(parentwindow);
		
		//Multiple windows->perform count operation and close the newly created windows		
		WebElement multiwindow = driver.findElement(By.
				xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		
		multiwindow.click();
		Thread.sleep(3000);
		Set<String> allwindows2 = driver.getWindowHandles();
		//Use size method to get the count of windows
		int count = allwindows2.size();
		System.out.println(count);
		
		
		//switching permission from parent to child windows
		for (String new2windows : allwindows2) 
			{
			driver.switchTo().window(new2windows);
			driver.close();
			}
			
			//switching permission from child to parent window
		driver.switchTo().window(parentwindow);
		
		//Open a multiwindow and  close the parent window
		
		WebElement multiwindow2 = driver.findElement(By.xpath("//*[@id=\'color\']"));
		multiwindow2.click();
		
		Set<String> allwindows3 = driver.getWindowHandles();
		for (String childwindows : allwindows3) {
			if(childwindows.equals(parentwindow)) {
				driver.close();
			}
		}
		//Open a multiwindows and  close the child windows alone
		
				WebElement multiwindow3 = driver.findElement(By.xpath("//*[@id=\'color\']"));
				multiwindow3.click();
				
				Set<String> allwindows4 = driver.getWindowHandles();
				for (String childwindows2 : allwindows4) {
					if(!childwindows2.equals(parentwindow)) {
						driver.close();
					}
				}
	
	}
	
	

}
