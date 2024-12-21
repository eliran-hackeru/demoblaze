package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserAPI extends BaseAPI {

    public Response getUserById(String userId) {
        return given()
                .pathParam("id", userId)
                .when()
                .get("/users/{id}");
    }
}
