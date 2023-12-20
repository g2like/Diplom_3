package steps;
import data.API;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestClient {

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(API.BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
