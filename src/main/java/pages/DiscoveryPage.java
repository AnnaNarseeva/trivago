package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class DiscoveryPage {

    public SelenideElement locationButton = $(byXpath("//*[@data-qa=\"button-inspiration-destination\"]"));
    public SelenideElement radiusButton = $(byXpath("//*[@data-qa=\"button-inspiration-distance\"]"));
    public SelenideElement stayDatesButton = $(byXpath("//*[@data-qa=\"button-inspiration-stay\"]"));
    public SelenideElement guestsButton = $(byXpath("//*[@data-qa=\"button-inspiration-guests\"]"));
    public SelenideElement titleDeals = $(byXpath("//*[@class=\"Header_title__2OWux\"]"));
    public SelenideElement locationField = $(byXpath("//*[@type=\"search\"]"));
    public SelenideElement viewDealButton = $(byXpath("//*[@class=\"Footer_button__6d5Ut\"]"));
    public SelenideElement cookiesOkButton = $(byXpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
    public SelenideElement distanceList = $(byXpath("//*[@class=\"DistanceSelect_list__cS7BJ\"]"));
    public SelenideElement destinationList = $(byXpath("//*[@class=\"DestinationSelect_list__1i3Sd\"]"));


    @And("user accept cookies")
    public void acceptCookies() {
        if (cookiesOkButton.exists()) {
            cookiesOkButton.click();
        }
    }

    public void openLocationField() {
        locationButton.click();
    }

    public void clearLocationField() {
        locationField.clear();
        locationField.shouldBe(Condition.empty);
    }

    public void setValueLocationField(String city) {
        locationField.sendKeys(city);
        titleDeals.shouldHave(Condition.exactValue(city));
    }

    public void clickOnRadiusField() {
        radiusButton.click();
    }

    public void selectRadius(String distance) {
        distanceList.getWrappedElement().findElement(byText(distance)).click();
    }

    public void selectViewDealButton() {
        viewDealButton.click();
    }


}

