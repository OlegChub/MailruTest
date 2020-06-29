package com.cucumber.demo.steps;

import com.cucumber.demo.driver.DriverManager;
import com.cucumber.demo.pages.HomePage;
import com.cucumber.demo.pages.ImagesPage;
import com.cucumber.demo.pages.ImagesSearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static com.cucumber.demo.driver.DriverManager.pageSwitcher;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuSteps {

    private HomePage homePage = new HomePage();
    private ImagesPage imagesPage = new ImagesPage();
    private ImagesSearchResultsPage imagesSearchResultsPage = new ImagesSearchResultsPage();

    @Given("the user opens Yandex website")
    public void openYandexHomePage() {
        homePage.openYandexHomePage();
    }

    @When("the user clicks on the {string} menu item")
    public void clickOnMenuItem(String menuItem) {
        homePage.getMenuItem(menuItem).click();
        DriverManager.getDriver().switchTo().window(pageSwitcher());
    }

    @And("the user chooses search by image function")
    public void clickOnSearchByImage() {
        imagesPage.getSearchByImageIco().click();
    }

    @And("the user uploads image")
    public void uploadImage() {
        imagesPage.uploadImageToSearch();
    }

    @Then("at least, one tag from block contains {string}")
    public void relevantTagIsPresent(String imageContext) {
        imagesSearchResultsPage.waitUntilTagsArePresent();
        assertThat(imagesSearchResultsPage.textIsInElementsList(imageContext))
                .overridingErrorMessage("Relevant tag with '%s' is not displayed", imageContext)
                .isTrue();
    }
}
