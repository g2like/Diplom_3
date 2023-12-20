package steps;
import data.API;
import data.UserData;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class UserSteps {

    @Step("Login user")
    public ValidatableResponse login(UserData user) {
        return given()
                .spec(RestClient.requestSpecification())
                .and()
                .body(user)
                .when()
                .post(API.LOGIN_API)
                .then();
    }

    @Step("Delete user")
    public ValidatableResponse delete(String bearerToken) {
        return given()
                .spec(RestClient.requestSpecification())
                .headers("Authorization", bearerToken)
                .delete(API.DELETE_USER_API)
                .then()
                .statusCode(202)
                .and()
                .body("message", is("User successfully removed"));
    }
    @Step("Create user")
    public ValidatableResponse create(UserData user) {
        return given()
                .spec(RestClient.requestSpecification())
                .and()
                .body(user)
                .when()
                .post(API.CREATE_USER_API)
                .then();
    }
}
