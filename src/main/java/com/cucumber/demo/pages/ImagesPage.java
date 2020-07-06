package com.cucumber.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class ImagesPage extends BasePage {

    private static final String SEARCH_BY_IMAGE_ICO = "//span[contains(@class,'icon_type_cbir')]";
    private static final String UPLOAD_FILE_FIELD = "//input[@type='file'][@name='upfile']";
    private static final String PATTERN_PATH_TO_IMAGE = System.getProperty("user.dir")+"\\src\\test\\resources\\%s";


    public WebElement getSearchByImageIco() {
        return findElement(By.xpath(SEARCH_BY_IMAGE_ICO));
    }

    public void uploadImageToSearch(String imageName) {
        WebElement uploadImageField = findElement(By.xpath(UPLOAD_FILE_FIELD));
        uploadImageField.sendKeys(format(PATTERN_PATH_TO_IMAGE,imageName));
    }
}