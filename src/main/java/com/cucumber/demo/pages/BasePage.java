package com.cucumber.demo.pages;

import com.cucumber.demo.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class BasePage {

    public WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public List<String> getTextsFromWebElements(By by) {
        return findElements(by).stream().map(WebElement::getText).collect(toList());
    }
    public void waitUntilElementIsPresent(By by){
        DriverManager.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
