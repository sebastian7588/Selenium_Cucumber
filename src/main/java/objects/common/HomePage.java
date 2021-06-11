package objects.common;

import objects.home.DeliveryTrackingComponent;
import objects.hooks.PropertiesFile;
import objects.hooks.Setup;

public class HomePage extends Setup {
    public static final String PAGE_TITLE = "InPost dla Ciebie - Paczkomaty, Kurier, Przesyłki Kurierskie i Paczki";
    private DeliveryTrackingComponent deliveryTrackingComponent;
    private PropertiesFile propertiesFile = new PropertiesFile();

    public void openHomePage() {
        setup();
        driver.get(propertiesFile.getProperties("homePage_host"));
    }

    public String getTitle() {
        return PAGE_TITLE;
    }

    public String getUrl() {
        return propertiesFile.getProperties("homePage_host");
    }

    public DeliveryTrackingComponent getTrackingComponent() {
        this.deliveryTrackingComponent = new DeliveryTrackingComponent(driver);
        return deliveryTrackingComponent;
    }
}
