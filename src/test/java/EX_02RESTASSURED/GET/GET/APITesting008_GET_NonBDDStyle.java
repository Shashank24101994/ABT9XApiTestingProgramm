package EX_02RESTASSURED.GET.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("verify the get request positive")
    @Test
    public void test_GET_NonBDDStyle() {
        String pincode = "481776";
        r = RestAssured
                .given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(200);
    }

    @Description("verify the get request negative:input -1")
    @Test
    public void test_GET_NonBDDStyle_negative() {
        String pincode = "-1";
        r = RestAssured
                .given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(200);


    }


    @Description("verify the get request negative:input long integer")
    @Test
    public void test_GET_NonBDDStyle_negative_long() {
        String pincode = "481776481776";
        r = RestAssured
                .given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(404);


    }

    @Description("verify the get request negative:input Alphanumeric ")
    @Test
    public void test_GET_NonBDDStyle_negative_Alphanumeric() {
        String pincode = "481776a";
        r = RestAssured
                .given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(404);


    }



}








