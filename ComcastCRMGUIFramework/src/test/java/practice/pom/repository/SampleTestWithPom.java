package practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPom {

@FindBy(name="user_name")
WebElement ele1;

@FindBy(name="user_password")
WebElement ele2;

//@FindBy(id="submitButton")
//WebElement ele3;

@FindAll({@FindBy(id="sub"),@FindBy(xpath="//input[@value='Log']")})//both wrong u ll get NoSuchElement
private WebElement ele3;

@Test
public void sampleTest()
{
WebDriver driver= new ChromeDriver();
driver.get("http://localhost:8888/");

SampleTestWithPom s=PageFactory.initElements(driver,SampleTestWithPom.class);

s.ele1.sendKeys("admin");//By taking the reference of page factory during the run time element will get the 
s.ele2.sendKeys("admin");//address that StaleElementReferenceException  will be avoided
                         //lazy initialization

//refresh code
driver.navigate().refresh();

s.ele1.sendKeys("admin");
s.ele2.sendKeys("admin");
s.ele3.click();

}

}
