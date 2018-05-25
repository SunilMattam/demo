package com.mavenit.bdd.training.page_objects;

import com.mavenit.bdd.training.drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverFactory {

    public void selectFilter(String filterValue) {
        List<WebElement> allFilters = driver.findElements(By.cssSelector(".ac-facet__label"));
        for (WebElement filter : allFilters) {
            if (filter.getText().equalsIgnoreCase(filterValue)) {
                filter.click();
                break;
            }
        }
        sleep(5000);
    }

    public List<Double> getAllReviewRating() {
        List<Double> collectedRatings = new ArrayList<>();
        List<WebElement> ratings = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement rating : ratings) {
            String ratingInString = rating.getAttribute("data-star-rating");
            Double raingInDouble = Double.parseDouble(ratingInString);
            collectedRatings.add(raingInDouble);
        }
        return collectedRatings;
    }
}
