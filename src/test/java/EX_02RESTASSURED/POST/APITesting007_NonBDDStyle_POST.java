package EX_02RESTASSURED.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting007_NonBDDStyle_POST {

   RequestSpecification r;
   Response response;
   ValidatableResponse vr;
    @Description("verify the Post request positive")
    @Test
    public void test_POST_NonBDDStyle() {
        String playload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
    r=RestAssured.given();
    r.baseUri("https://restful-booker.herokuapp.com");
    r.basePath("/auth");
    r.contentType(ContentType.JSON);
    r.body(playload).log().all();
    response=r.when().log().all().post();
    vr=response.then().log().all().statusCode(200);


    }
}








