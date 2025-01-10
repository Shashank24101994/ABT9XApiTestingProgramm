package EX_02RESTASSURED.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_NonBDDStyle_Delete
{
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Description("verify the DELETE request positive")
    @Test
    public void test_Delete_NonBDDStyle(){
        String token ="875280b8c37deb1";
        String bookingid ="1476";

     r= RestAssured.given();
     r.baseUri("https://restful-booker.herokuapp.com");
     r.basePath("/booking/"+bookingid);
     r.contentType(ContentType.JSON);
     r.cookies("token",token);
     r.log().all();
     response=r.when().delete();
     vr=response.then().log().all().statusCode(201);



    }
}
