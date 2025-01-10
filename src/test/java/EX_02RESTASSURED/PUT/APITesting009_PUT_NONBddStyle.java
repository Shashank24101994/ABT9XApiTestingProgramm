package EX_02RESTASSURED.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting009_PUT_NONBddStyle
{
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Description("verify the Put request positive")
    @Test
    public void test_Put_NonBDDStyle(){
        String token ="bbbb355c56a64c3";
        String bookingid ="3525";
        String playloadput="{\n" +
                "    \"firstname\" : \"SHASHANK\",\n" +
                "    \"lastname\" : \"SINGH\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookies("token",token);
        r.body(playloadput).log().all();
        response=r.when().put();
        vr=response.then().log().all().statusCode(200);



    }

}
