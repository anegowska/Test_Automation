package exercise1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/aga/IdeaProjects/Test_Automation/src/test/java/exercise1/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MICROSECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void userRegistrationWithValidData() throws InterruptedException {
        driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("email_create")).sendKeys("test1.email@test.com");
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Abc");
        driver.findElement(By.id("customer_lastname")).sendKeys("Defgh");
        driver.findElement(By.id("passwd")).sendKeys("pass1234");
        driver.findElement(By.id("address1")).sendKeys("Testaddress 123");
        driver.findElement(By.id("city")).sendKeys("Testcity");
        driver.findElement(By.cssSelector("#id_state option[value=\"1\"]")).click();
        driver.findElement(By.id("postcode")).sendKeys("65267");
        driver.findElement(By.id("phone_mobile")).sendKeys("654321807");
        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(5000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
