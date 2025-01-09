package EX_02RESTASSURED.GET.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting007_GET_BDDStyle
{
    @Test
    public void test_GET_Req_POSITIVE_TC()
    {
        String pincode ="481776";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }

     @Test
     public void test_GET_Req_NEGATIVE_TC()
     {
         String pincode = "-1";
         RestAssured
                 .given()
                 .baseUri("https://api.zippopotam.us")
                 .basePath("/IN/" + pincode)
                 .when()
                 .log()
                 .all()
                 .get()
                 .then()
                 .log().all()
                 .statusCode(404);
     }





}
