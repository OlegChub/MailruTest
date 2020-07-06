package com.cucumber.demo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class DriverManager {

    private static final int WAIT_TIMEOUT = 40;
    private static final String CHROME_DRIVER_PATH = "./src/main/resources/chromedriver.exe";
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setupDriver() {
        WebDriver driver = getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(WAIT_TIMEOUT, TimeUnit.SECONDS);
        threadLocalDriver.set(driver);
    }

    private static ChromeDriver getChromeDriver() {
        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static WebDriverWait getWebDriverWait(){
        WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait;
    }

    public static String pageSwitcher() {
        Set<String> openPagesSet = getDriver().getWindowHandles();
        if(!openPagesSet.isEmpty()) {
            Iterator<String> iterator = openPagesSet.iterator();
            String newPage = null;
            while (iterator.hasNext()) {
                newPage = iterator.next();
            }
            return newPage;
        }
        return null;
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(driver -> {
            driver.quit();
            threadLocalDriver.remove();
        });
    }
}
