package EX_02RESTASSURED.PATCH;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_NonBDDStyle_Patch
{
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Description("verify the Patch request positive")
    @Test
    public void test_Patch_NonBDDStyle(){
        String token ="92a17b6cd300504";
        String bookingid ="2668";
        String playloadpatch="{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"JAIN\"\n" +
                "    \n" +
                "}";
     r= RestAssured.given();
     r.baseUri("https://restful-booker.herokuapp.com");
     r.basePath("/booking/"+bookingid);
     r.contentType(ContentType.JSON);
     r.cookies("token",token);
     r.body(playloadpatch).log().all();
     response=r.when().patch();
     vr=response.then().log().all().statusCode(200);



    }
}
