package objects.career;

import objects.hooks.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindOfferComponent extends Setup {

    public FindOfferComponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Brak data-ctx, brak konsekwencji w option

    @FindBy(xpath = "//select[@class='form--control -shorter departmentsSelect']/..")
    private WebElement positionDropdown;

    @FindBy(xpath = "//select[@class='form--control -shorter departmentsSelect']//option[@value='IT']")
    private WebElement positionChoose;

    @FindBy(xpath = "//select[@class='form--control -shorter regionsSelect']/..")
    private WebElement localityDropdown;

    @FindBy(xpath = "//select[@class='form--control -shorter regionsSelect']//option[contains(text(),'mazowieckie')]")
    private WebElement localityChoose;

    @FindBy(css = "button[class='btn--primary jobsSelectTrigger']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@class='link--component -smallmobile']")
    private WebElement applyButton;

    @FindBy(xpath = "//input[@class='form--control']")
    private WebElement searchField;

    @FindBy(xpath = "//img[@src='https://skk.erecruiter.pl/CSS/Custom/20132981/_res/aplikuj.jpg']")
    private WebElement applyButton2;

    public FindOfferComponent openPositionDropbox() {
        positionDropdown.click();
        return this;
    }

    public FindOfferComponent choosePosition() {
        positionChoose.click();
        return this;
    }

    public FindOfferComponent openLocalityDropbox() {
        localityDropdown.click();
        return this;
    }

    public FindOfferComponent chooseLocality() {
        localityChoose.click();
        return this;
    }

    public FindOfferComponent clickSearch() {
        searchButton.click();
        return this;
    }

    public FindOfferComponent clickApply() {
        applyButton.click();
        return this;
    }

    public FindOfferComponent clickApply2() {
        applyButton2.click();
        return this;
    }
    public FindOfferComponent enterJobTitle(String JobTitle) {
        searchField.sendKeys(JobTitle);
        return this;
    }
}
