package com.cucumber.demo.pages;

import com.cucumber.demo.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String YANDEX_HOME_URL = "https://yandex.ru/";
    private static final String MENU_LINK_PATTERN = "//a[text()='%s']";

    public void openYandexHomePage() {
        DriverManager.getDriver().get(YANDEX_HOME_URL);
    }

    public WebElement getMenuItem(String linkText) {
        return findElement(By.xpath(format(MENU_LINK_PATTERN, linkText)));
    }
}
