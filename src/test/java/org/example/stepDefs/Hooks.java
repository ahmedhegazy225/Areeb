package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver = null;
    static Duration duration = Duration.ofSeconds(60);
    public static WebDriverWait wait = null;


    @Before
    public static void openBrowser() throws MalformedURLException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        driver= new ChromeDriver(ops);
        URL link = new URL("https://www.saucedemo.com/");
        driver.navigate().to(link);
        wait= new WebDriverWait(driver,duration);
    }
    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
