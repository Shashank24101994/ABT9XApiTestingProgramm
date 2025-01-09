package EX_02RESTASSURED.GET;

import io.restassured.RestAssured;

public class APITesting006_GET_BDDStyle
{
    public static void main(String[] args) {
        String pincode ="481776";
        // Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == PRAMOD


        // Full URL - https://api.zippopotam.us/IN/560016
        // base URI - https://api.zippopotam.us
        // bath Path - /IN/481776
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .log().all()
                .get()
                .then().log().all()
                .statusCode(200);

         pincode ="-1";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .log().all()
                .get()
                .then().log().all()
                .statusCode(404);


    }
}
