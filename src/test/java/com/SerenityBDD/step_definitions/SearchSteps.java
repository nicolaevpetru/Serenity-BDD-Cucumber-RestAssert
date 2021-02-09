package com.SerenityBDD.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;


public class SearchSteps extends PageObject {

    @Managed
    WebDriver driver;

    @When("I open the browser and navigate to the google.com")
    public void i_open_the_browser_and_navigate_to_the_google_com() {
        open();
    }

    @When("I search for keyword {string}")
    public void i_search_for_keyword(String keyword) {
        $("//body/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]").sendKeys(keyword);
    }

    @Then("The result should contain the search keyword")
    public void the_result_should_contain_the_search_keyword() {
        driver.close();
    }

}
