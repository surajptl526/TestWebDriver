package uitest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);
		
		//Find out total number of rows in the table
		
		List<WebElement> Rows =driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr"));
		System.out.println("Total number of Rows are " +Rows.size());
		

		//Find out total number of Column.
		
		List<WebElement> Column =driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr/th"));
		System.out.println("Total number of Columns are " +Column.size());
		
		
		//Solution 1 To find Contact & Country name from Company Name
		String CompanyName = "Island Trading";
		for(int i=2;i<=Rows.size();i++) {
		
		WebElement Company = driver.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr[" + i + "]/td[1]"));
		
		if(Company.getText().equals(CompanyName)) {
			
		WebElement Contact =driver.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr[" + i + "]/td[2]"));
		WebElement Country =driver.findElement(By.xpath("//table[@class='ws-table-all']/tbody/tr[" + i + "]/td[3]"));
		
		System.out.println(Contact.getText());
		System.out.println(Country.getText());	
		}	
	}
		//Solution 2 
		WebElement Contact1 =driver.findElement(By.xpath("//td[text()='" + CompanyName + "']/following-sibling::td[1]"));
		WebElement Country1 =driver.findElement(By.xpath("//td[text()='" + CompanyName + "']/following-sibling::td[2]"));

		System.out.println(Contact1.getText());
		System.out.println(Country1.getText());
	}
	}
