package com.mavenit.bdd.training.step_def;

import com.mavenit.bdd.training.page_objects.HeaderPage;
import com.mavenit.bdd.training.page_objects.ResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;

public class FilterStepsDef {

    HeaderPage headerPage = new HeaderPage();
    ResultsPage resultsPage=new ResultsPage();
    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {

    }

    @When("^I search for a product \"([^\"]*)\"$")
    public void i_search_for_a_product(String searchTerm) throws Throwable {
        headerPage.doSearch(searchTerm);
    }

    @When("^I select filter \"([^\"]*)\"$")
    public void i_select_filter(String filterValue) throws Throwable {
        resultsPage.selectFilter(filterValue);
    }

    @Then("^I should see results filtered by \"([^\"]*)\"$")
    public void i_should_see_results_filtered_by(Double expectedValue) throws Throwable {
        List<Double> actualList = resultsPage.getAllReviewRating();
        assertThat(actualList, everyItem(greaterThan(expectedValue)));
    }

}
