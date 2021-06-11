package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.common.HomePage;
import objects.hooks.Setup;
import java.io.IOException;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class StanPaczki {
    private HomePage homepage;
    private Setup setup;

    @Given("^Użytkownik jest na stronie głównej$")
    public void użytkownikJestNaStronieGłównej() {
        this.homepage = new HomePage();
        this.setup = new Setup();
        homepage.openHomePage();
        setup.addCookie("OptanonAlertBoxClosed", "2022-06-05T13:00:00.998Z");
        assertEquals("Url nie jest zgodny",homepage.getUrl(), setup.getCurrentUrl());
        assertEquals("Tytuł strony nie jest zgodny",homepage.getTitle(), setup.getCurrentTitle());
    }

    @When("^Użytkownik podaje numer paczki \"([^\"]*)\" i klika znajdź$")
    public void użytkownikPodajeNumerPaczkiIKlikaZnajdź(String id) {
        assertTrue("Komponent do wyszukiwania paczki nie znajduje się na stronie", homepage.getTrackingComponent().isSearchFieldVisible());
        homepage.getTrackingComponent().enterParceleId(id);
        homepage.getTrackingComponent().clickSearch();
    }

    @Then("^Paczka została znaleźiona, a status paczki jest \"([^\"]*)\"$")
    public void paczkaZostałaZnaleźionaAStatus(String status) {
        assertEquals("Status nie jest zgodny", status, homepage.getTrackingComponent().getParcelStatus());
    }

    @After
    public void endTest() throws IOException {
        setup.saveScreenshots();
        setup.tearDown();
    }
}
