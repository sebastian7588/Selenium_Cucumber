package steps;

import io.cucumber.java.en.Given;
import rest.ParcelLocker;
import java.io.IOException;

public class DostępnePaczkomaty {
    private ParcelLocker getParcelLocker;

    @Given("Wyszukaj Paczkomatów w Krakowie")
    public void wyszukajPaczkomatówWKrakowie() throws IOException {
        this.getParcelLocker = new ParcelLocker();
        getParcelLocker.getParcelLocker();
    }
}
