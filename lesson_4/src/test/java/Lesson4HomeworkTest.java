import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Lesson4HomeworkTest {

    public WebDriver driver;

    @Before
    public void setUp() {
        if (System.getProperty("options") == null) {
            String browser = System.getProperty("browser").toUpperCase();
            driver = new WebDriverFactory().createWebDriver(WebDriverName.valueOf(browser));
        }
        else {
            String browser = System.getProperty("browser").toUpperCase();
            String options = System.getProperty("options");
            driver = new WebDriverFactory().createWebDriver(WebDriverName.valueOf(browser), options);
        }

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        driver.get("https://otus.ru/");
        Assert.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям", driver.getTitle());
    }

}
