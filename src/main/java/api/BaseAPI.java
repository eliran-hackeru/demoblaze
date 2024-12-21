package api;

import io.restassured.RestAssured;

public class BaseAPI {
    public BaseAPI() {
        RestAssured.baseURI = "https://api.example.com";
    }
}
