package rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import objects.hooks.PropertiesFile;
import java.io.FileWriter;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class ParcelLocker {

    public void getParcelLocker() throws IOException {

        PropertiesFile propertiesFile = new PropertiesFile();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        Response response = given().
                config(RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))). /*usunięcie domyślnego headera z "charset=ISO-8859-1"*/
                contentType("application/json").
                when().
                get(propertiesFile.getProperties("quickShipmentsPage_host") + "/v1/api/points?query=Kraków&type=standard_parcel_collect&page=1&perPage=20");
                String responseBody = response.getBody().asString();
                response.then().statusCode(200).log().all().extract().response();

        FileWriter file = new FileWriter("src/test/response/respons.json");
        file.write(responseBody);
        file.flush();
        file.close();
    }
}
