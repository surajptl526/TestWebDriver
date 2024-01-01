package uitest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FbLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);
		
		WebElement EmailId =driver.findElement(By.id("email"));
		EmailId.sendKeys("abc@xyz.com");
		
		WebElement Password =driver.findElement(By.name("pass"));
		Password.sendKeys("Abc@1234");
		
		WebElement LoginBtn =driver.findElement(By.name("login"));
		LoginBtn.click();

	}

}
