package com.cucumber.demo.pages;

import org.openqa.selenium.By;

import java.util.List;

public class ImagesSearchResultsPage extends BasePage {

    private static final String TAGS_CLOUD = "//*[contains(@class,'Tags_type_simple')]";
    private static final String TAG_ELEMENT = "//a[contains(@class,'Button2')]/span[@class='Button2-Text']";

    public void waitUntilTagsArePresent() {
        waitUntilElementIsPresent(By.xpath(TAGS_CLOUD));
    }

    public boolean textIsInElementsList(String text) {
        List<String> listOfTagsText = getTextsFromWebElements(By.xpath(TAG_ELEMENT));
        boolean hasText = false;
        for (int i = 0; i < listOfTagsText.size(); i++) {
            if (listOfTagsText.get(i).contains(text)) {
                hasText = true;
                break;
            }
        }
        return hasText;
    }

}
