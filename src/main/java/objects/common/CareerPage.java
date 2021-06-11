package objects.common;

import objects.career.FindOfferComponent;
import objects.hooks.PropertiesFile;
import objects.hooks.Setup;

public class CareerPage extends Setup {
    public static final String PAGE_TITLE = "Praca w InPost - oferty pracy i staże | InPost - Paczkomaty, Kurier, Przesyłki Kurierskie";
    private FindOfferComponent findOfferComponent;
    private PropertiesFile propertiesFile = new PropertiesFile();

    public void openCareerPage() {
        setup();
        driver.get(propertiesFile.getProperties("careerPage_host"));
    }

    public String getTitle() {
        return PAGE_TITLE;
    }

    public String getUrl() {
        return propertiesFile.getProperties("careerPage_host");
    }

    public FindOfferComponent getFindOfferComponent() {
        this.findOfferComponent = new FindOfferComponent(driver);
        return findOfferComponent;
    }
}
