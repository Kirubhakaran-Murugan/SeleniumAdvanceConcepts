package SeleniumAdvance;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadAndVerify {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\kirubhakaran.murugan\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/download");
		
		//DOWNLOAD PNG file
		
		WebElement pnglink = driver.findElement(By.partialLinkText("BRAZIL"));
		pnglink.click();
		
		Thread.sleep(4000);
		//Java piece of code to handle the windows application
		File pngfilelocation = new File("C:\\Downloads");
		File[] totalpngfiles= pngfilelocation.listFiles();
		
		for (File file : totalpngfiles) {
			if(file.getName().equals("BRAZIL.png")) {
				System.out.println("Png File is dowloaded successfully");
				
			}
			
		}
		
		//DOWNLOAD PDF
		WebElement pdflink = driver.findElement(By.partialLinkText("Atelier 28-04-2022"));
		pdflink.click();
		
		Thread.sleep(4000);
		//Java piece of code to handle the windows application
		File pdffilelocation = new File("C:\\Downloads");
		File[] totalpdffiles= pdffilelocation.listFiles();
		
		for (File file : totalpdffiles) {
			if(file.getName().equals("Atelier 28-04-2022.pdf")) {
				System.out.println("PDF File is dowloaded successfully");
				
			}
			
		}
		
		//DOWNLOAD TEXT
		WebElement textlink = driver.findElement(By.partialLinkText("Info"));
		textlink.click();
		
		Thread.sleep(4000);
		//Java piece of code to handle the windows application
		File textfilelocation = new File("C:\\Downloads");
		File[] totaltextfiles= textfilelocation.listFiles();
		
		for (File file : totaltextfiles) {
			if(file.getName().equals("Info.txt")) {
				System.out.println("Text File is dowloaded successfully");
				
			}
			
		}

		//DOWNLOAD Excel
		
		WebElement excellink = driver.findElement(By.partialLinkText("upload_file"));
		excellink.click();
		
		Thread.sleep(4000);
		//Java piece of code to handle the windows application
		File excelfilelocation = new File("C:\\Downloads");
		File[] totalexcelfiles= excelfilelocation.listFiles();
		
		for (File file : totalexcelfiles) {
			if(file.getName().equals("upload_file.xlsx")) {
				System.out.println("Excel File is dowloaded successfully");
				
			}
			
		}

		
		
		//DOWNLOAD CSV
		WebElement csvlink = driver.findElement(By.partialLinkText("chustb1"));
		csvlink.click();
		
		Thread.sleep(4000);
		//Java piece of code to handle the windows application
		File csvfilelocation = new File("C:\\Downloads");
		File[] totalcsvfiles= csvfilelocation.listFiles();
		
		for (File file : totalcsvfiles) {
			if(file.getName().equals("chustb1.csv")) {
				System.out.println("CSV File is dowloaded successfully");
				
			}
			
		}

		
		//Download jpg file 
		
		WebElement jpglink = driver.findElement(By.partialLinkText("avatar-blank"));
		jpglink.click();
		
		Thread.sleep(4000);
		//Java piece of code to handle the windows application
		File jpgfilelocation = new File("C:\\Downloads");
		File[] totaljpgfiles= jpgfilelocation.listFiles();
		
		for (File file : totaljpgfiles) {
			if(file.getName().equals("avatar-blank.jpg")) {
				System.out.println("JPG File is dowloaded successfully");
		
	}
			}
		//Download Torrent file 
		
		WebElement Torrentlink = driver.findElement(By.partialLinkText("Assassins.Creed"));
		Torrentlink.click();
		
		Thread.sleep(4000);
		//Java piece of code to handle the windows application
		File torrentfile = new File("C:\\Downloads");
		File[] totaltorrentfiles = torrentfile.listFiles();
		
		for (File file : totaltorrentfiles) {
			if(file.getName().equals("Assassins.Creed.Origins-CPY.torrent")) {
				System.out.println("Torrent File is dowloaded successfully");				
			}
			
		}
		
		
		
		
	}

}
