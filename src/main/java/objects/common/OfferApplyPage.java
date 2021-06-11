package objects.common;

import objects.applyForm.ApplyFromComponent;
import objects.hooks.Setup;

public class OfferApplyPage extends Setup {

    private ApplyFromComponent applyFromComponent;

    public ApplyFromComponent getApplyFromComponent() {
        this.applyFromComponent = new ApplyFromComponent(driver);
        return applyFromComponent;
    }
}
