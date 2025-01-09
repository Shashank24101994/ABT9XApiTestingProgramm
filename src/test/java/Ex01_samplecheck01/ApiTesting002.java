package Ex01_samplecheck01;

import io.restassured.RestAssured;

public class ApiTesting002
{
    public static void main(String[] args) {
        // Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == PRAMOD


        // Full URL - https://api.zippopotam.us/IN/560016
        // base URI - https://api.zippopotam.us
        // bath Path - /IN/560016

        RestAssured.
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/481776")
                .when()
                      .get()
                .then().log().all().statusCode(200);





    }
}