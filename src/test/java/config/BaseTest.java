package config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    protected String emailAdmin  = "ahemdnaim123@gmail.com" ;
    protected String  passwordAdmin = "ahemdnaim123@gmail.com" ;
    protected String url = "http://localhost:5173/administrateur/dashboard";

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");


        driver = new ChromeDriver(options);



        driver.manage().window().maximize();

        String token = AuthUtils.getToken();

        driver.get("http://localhost:5173/login");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "window.localStorage.setItem('token', arguments[0]);",
                token
        );

    }


    protected WebElement  await(By  locator  ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        locator
                )
        );

        return  el ;
    }

    protected WebElement  await(By  locator , int timeout ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        locator
                )
        );

        return  el ;
    }


    protected  String getFilePathForTestFiles(String fileName) {
        String projectDir = System.getProperty("user.dir");

        String filePath = Paths.get(projectDir, "datatest", fileName ).toString();

        return  filePath ;
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
