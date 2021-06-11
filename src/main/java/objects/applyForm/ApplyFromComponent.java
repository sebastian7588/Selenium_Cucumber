package objects.applyForm;

import objects.hooks.Setup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyFromComponent extends Setup {

    private Setup setup;
    public ApplyFromComponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor jsx = (JavascriptExecutor)driver;

    @FindBy(xpath = "//input[@id='ctl00_DefaultContent_ctl17_tbName']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='ctl00_DefaultContent_ctl17_tbSurname']")
    private WebElement surnameField;

    @FindBy(xpath = "//input[@id='ctl00_DefaultContent_ctl17_tbMail']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='ctl00_DefaultContent_ctl17_tbCellPhone']")
    private WebElement phoneField;

    @FindBy(xpath = "//select[@id='ctl00_DefaultContent_ctl31_lstCountries']//option[contains(text(),'Polska')]")
    private WebElement countryChoose;

    @FindBy(xpath = "//select[@id='ctl00_DefaultContent_ctl31_lstCountries']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//select[@id='ctl00_DefaultContent_ctl31_lstRegions']//option[contains(text(),'mazowieckie')]")
    private WebElement regionChoose;

    @FindBy(xpath = "//select[@id='ctl00_DefaultContent_ctl31_lstRegions']")
    private WebElement regionDropdown;

    @FindBy(xpath = "//input[@id='ctl00_DefaultContent_ctl31_tbCity']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@name='ctl00$DefaultContent$ctl45$fuCv']")
    private WebElement cvButton;

    @FindBy(xpath = "//table[@id='ctl00_DefaultContent_ctl58_lstOptions']//input[@id='ctl00_DefaultContent_ctl58_lstOptions_0']")
    private WebElement cooperateCheckbox;

    @FindBy(xpath = "//textarea[@id='ctl00_DefaultContent_ctl59_tbText']")
    private WebElement financialExpectationsField;

    @FindBy(xpath = "//select[@id='ctl00_DefaultContent_ctl60_dlstOptions']")
    private WebElement experienceDropdown;

    @FindBy(xpath = "//option[@value='poniżej 1 roku']")
    private WebElement experienceChoose;

    @FindBy(xpath = "//table[@id='ctl00_DefaultContent_ctl61_rlstOptions']//input[@id='ctl00_DefaultContent_ctl61_rlstOptions_0']")
    private WebElement languageKnowledgeRadioButton;

    @FindBy(xpath = "//textarea[@id='ctl00_DefaultContent_ctl62_tbText']")
    private WebElement gitHubLinkField;

    @FindBy(xpath = "//textarea[@id='ctl00_DefaultContent_ctl63_tbText']")
    private WebElement linkedInLinkField;

    @FindBy(xpath = "//table[@id='ctl00_DefaultContent_ctl64_rlstOptions']//input[@id='ctl00_DefaultContent_ctl64_rlstOptions_0']")
    private WebElement ApplyRadioButton;

    @FindBy(xpath = "//textarea[@id='ctl00_DefaultContent_ctl66_tbText']")
    private WebElement recommendationField;

    @FindBy(xpath = "//textarea[@id='ctl00_DefaultContent_ctl65_tbText']")
    private WebElement additionalInformationField;

    @FindBy(xpath = "//div[@class='other-consents']//input")
    private WebElement consentsCheckbox;

    @FindBy(xpath = "//input[@value='Wyślij']")
    private WebElement SendButton;

    public ApplyFromComponent enterName(String name) {
        nameField.sendKeys(name);
        return this;
    }

    public ApplyFromComponent enterSurname(String surname) {
        surnameField.sendKeys(surname);
        return this;
    }

    public ApplyFromComponent enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }


    public ApplyFromComponent enterPhone(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    public ApplyFromComponent enterCity(String city) {
        cityField.sendKeys(city);
        return this;
    }

    public ApplyFromComponent openCountryDropbox() {
        countryDropdown.click();
        return this;
    }

    public ApplyFromComponent chooseCountry() {
        countryChoose.click();
        return this;
    }

    public ApplyFromComponent openRegionDropbox() {
        regionDropdown.click();
        return this;
    }

    public ApplyFromComponent chooseRegion() {
        regionChoose.click();
        return this;
    }


    public ApplyFromComponent putCv() {
        jsx.executeScript("arguments[0].scrollIntoView();", cvButton);
        cvButton.sendKeys(file.getAbsolutePath());
        return this;
    }

    public ApplyFromComponent cooperateClick() {
        jsx.executeScript("arguments[0].scrollIntoView();", cooperateCheckbox);
        cooperateCheckbox.click();
        return this;
    }

    public ApplyFromComponent enterFinancial(String financial) {
        jsx.executeScript("arguments[0].scrollIntoView();", financialExpectationsField);
        financialExpectationsField.sendKeys(financial);
        return this;
    }

    public ApplyFromComponent openExperienceDropbox() {
        jsx.executeScript("arguments[0].scrollIntoView();", experienceDropdown);
        experienceDropdown.click();
        return this;
    }

    public ApplyFromComponent chooseExperience() {
        jsx.executeScript("arguments[0].scrollIntoView();", experienceChoose);
        experienceChoose.click();
        return this;
    }

    public ApplyFromComponent chooseLanguageKnowledge() {
        jsx.executeScript("arguments[0].scrollIntoView();", languageKnowledgeRadioButton);
        languageKnowledgeRadioButton.click();
        return this;
    }

    public ApplyFromComponent enterGitHubLink(String gitHubLink) {
        jsx.executeScript("arguments[0].scrollIntoView();", gitHubLinkField);
        gitHubLinkField.sendKeys(gitHubLink);
        return this;
    }

    public ApplyFromComponent enterLinkedInLink(String linkedInLink) {
        jsx.executeScript("arguments[0].scrollIntoView();", linkedInLinkField);
        linkedInLinkField.sendKeys(linkedInLink);
        return this;
    }

    public ApplyFromComponent ApplyClick() {
        jsx.executeScript("arguments[0].scrollIntoView();", ApplyRadioButton);
        ApplyRadioButton.click();
        return this;
    }

    public ApplyFromComponent enterRecommendation(String linkedInLink) {
        jsx.executeScript("arguments[0].scrollIntoView();", recommendationField);
        recommendationField.sendKeys(linkedInLink);
        return this;
    }

    public ApplyFromComponent enterAdditionalInformation(String additionalInformation) {
        jsx.executeScript("arguments[0].scrollIntoView();", additionalInformationField);
        additionalInformationField.sendKeys(additionalInformation);
        return this;
    }

    public ApplyFromComponent consentsClick() {
        jsx.executeScript("arguments[0].scrollIntoView();", consentsCheckbox);
        consentsCheckbox.click();
        return this;
    }
}
