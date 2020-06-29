package com.cucumber.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ImagesPage extends BasePage {

    private static final String SEARCH_BY_IMAGE_ICO = "//span[contains(@class,'icon_type_cbir')]";
    private static final String UPLOAD_FILE_FIELD = "input[type=file][name='upfile']";
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String CONTENT_PATH_TO_CRANE_IMAGE = "\\src\\main\\resources\\crane.jpg";
    public static final String ABSOLUTE_PATH_TO_CRANE_IMAGE = USER_DIR + CONTENT_PATH_TO_CRANE_IMAGE;


    public WebElement getSearchByImageIco() {
        return findElement(By.xpath(SEARCH_BY_IMAGE_ICO));
    }

    public void uploadImageToSearch() {
        WebElement uploadImageField = findElement(By.cssSelector(UPLOAD_FILE_FIELD));
        uploadImageField.sendKeys(ABSOLUTE_PATH_TO_CRANE_IMAGE);
    }
}

