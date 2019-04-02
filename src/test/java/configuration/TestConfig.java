package configuration;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestConfig {

    private WebDriver driver;


    @Before
    public void setUp() {
        driver = WebDriverSingleton.getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MICROSECONDS);

        driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown() {

        WebDriverSingleton.quit();
    }
}
