package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.common.CareerPage;
import objects.common.OfferApplyPage;
import objects.hooks.Setup;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;

public class StanowiskoPracy {
    private CareerPage careerPage;
    private OfferApplyPage offerApplyPage;
    private Setup setup;

    @Given("Użytkownik jest na stronie kariera")
    public void użytkownikJestNaStronieKariera() throws InterruptedException {
        this.careerPage = new CareerPage();
        this.offerApplyPage = new OfferApplyPage();
        this.setup = new Setup();
        careerPage.openCareerPage();
        setup.addCookie("OptanonAlertBoxClosed", "2022-06-05T13:00:00.998Z");
        assertEquals("Url nie jest zgodny",careerPage.getUrl(), setup.getCurrentUrl());
        assertEquals("Tytuł strony nie jest zgodny",careerPage.getTitle(), setup.getCurrentTitle());
    }

    @And("Użytkownik wybiera stanowisko pracy IT w lokalizacji mazowieckie i wyszukuje {string}")
    public void użytkownikWybieraStanowiskoPracyITWLokalizacjiMazowieckieIWyszukuje(String JobTitle) throws InterruptedException {
        careerPage.getFindOfferComponent().openPositionDropbox();
        careerPage.getFindOfferComponent().choosePosition();
        careerPage.getFindOfferComponent().openLocalityDropbox();
        careerPage.getFindOfferComponent().chooseLocality();
        Thread.sleep(1000);
        careerPage.getFindOfferComponent().enterJobTitle(JobTitle);
        careerPage.getFindOfferComponent().clickSearch();
        careerPage.getFindOfferComponent().clickApply();
        setup.switchTab();
        Thread.sleep(2000);
    }

    @When("Użytkownik Wybiera pierwszą ofertę pracy i aplikuje")
    public void użytkownikWybieraPierwsząOfertęPracyIAplikuje() throws InterruptedException {
        careerPage.getFindOfferComponent().clickApply2();
        setup.switchTab();
        Thread.sleep(2000);
    }

    @Then("Użytkownik wypełnia formularz i dodaje CV")
    public void użytkownikWypełniaFormularzIDodajeCV(DataTable table) throws InterruptedException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            offerApplyPage.getApplyFromComponent().enterName(columns.get("Imię"));
            offerApplyPage.getApplyFromComponent().enterSurname(columns.get("Nazwisko"));
            offerApplyPage.getApplyFromComponent().enterEmail(columns.get("E-mail"));
            offerApplyPage.getApplyFromComponent().enterPhone(columns.get("Telefon"));
            offerApplyPage.getApplyFromComponent().enterCity(columns.get("Miasto"));
            Thread.sleep(1000);
            offerApplyPage.getApplyFromComponent().openCountryDropbox();
            offerApplyPage.getApplyFromComponent().chooseCountry();
            Thread.sleep(2000);
            offerApplyPage.getApplyFromComponent().openRegionDropbox();
            offerApplyPage.getApplyFromComponent().chooseRegion();
            Thread.sleep(2000);
            offerApplyPage.getApplyFromComponent().cooperateClick();
            offerApplyPage.getApplyFromComponent().enterFinancial("100000");
            offerApplyPage.getApplyFromComponent().openExperienceDropbox();
            offerApplyPage.getApplyFromComponent().chooseExperience();
            offerApplyPage.getApplyFromComponent().chooseLanguageKnowledge();
            offerApplyPage.getApplyFromComponent().enterGitHubLink("http://github");
            offerApplyPage.getApplyFromComponent().enterLinkedInLink("http://linkedin");
            offerApplyPage.getApplyFromComponent().ApplyClick();
            offerApplyPage.getApplyFromComponent().consentsClick();
            offerApplyPage.getApplyFromComponent().enterRecommendation("Tester Testerski");
            offerApplyPage.getApplyFromComponent().enterAdditionalInformation("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
            offerApplyPage.getApplyFromComponent().putCv();
        }
    }

    @After
    public void endTest() throws IOException {
        setup.saveScreenshots();
        setup.tearDown();
    }
}
