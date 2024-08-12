package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstagramRegistration {

public static void main(String[] args) 
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demoapp.skillrary.com/login.php");
	driver.findElement(By.name("firstname")).sendKeys("chaithra");
	driver.findElement(By.xpath("//div[@class='row register-form']//input[@placeholder='Email']")).sendKeys("chaithrads2@gmail.com");
	driver.findElement(By.name("lastname")).sendKeys("ds");
	driver.findElement(By.xpath("//div[@class='row register-form']//input[@placeholder='Password']")).sendKeys("8970282123");
	driver.findElement(By.xpath("//div[@class='row register-form']//input[@placeholder='Confirm Password]")).sendKeys("8970282123");
	driver.findElement(By.name("signup")).click();
	
	
}

}
