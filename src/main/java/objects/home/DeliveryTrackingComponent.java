package objects.home;

import objects.hooks.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryTrackingComponent extends Setup {

    public DeliveryTrackingComponent (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[class='form--control inputForMat']")
    private WebElement searchField;

    @FindBy(css = "button[class='btn--primary -mobilefull']")
    private WebElement searchButton;

    @FindBy(xpath = "//h1[contains(text(),'Śledź paczkę')]")
    private WebElement parcelStatus;

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public String getParcelStatus() {
        return parcelStatus.getText();
    }

    public DeliveryTrackingComponent enterParceleId(String ParceleId) {
        searchField.sendKeys(ParceleId);
        return this;
    }

    public DeliveryTrackingComponent clickSearch() {
        searchButton.click();
        return this;
    }
}
