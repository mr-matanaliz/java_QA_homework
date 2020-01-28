import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Lesson2HomeworkTest {

    private final static Logger logger = LogManager.getLogger(Lesson2HomeworkTest.class);

    private WebDriver driver;

    @Parameterized.Parameters
    public static Collection<Object> Browser() {
        Object[] object = new Object[] {"chrome", "firefox"};
        return Arrays.asList(object);
    }

    private String fBrowserName;

    public Lesson2HomeworkTest(String BrowserName) {
        this.fBrowserName = BrowserName;
    }

    @Before
    public void setUp() {
        switch (fBrowserName) {
            case "chrome" : {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "firefox" : {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test(){
        driver.get("https://otus.ru/");
        logger.info("ИНФО");
        Assert.assertEquals(driver.getTitle(), "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям");
    }
}