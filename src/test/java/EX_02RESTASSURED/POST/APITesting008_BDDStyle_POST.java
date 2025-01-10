package EX_02RESTASSURED.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting008_BDDStyle_POST
{
    @Description("verify the Post request positive")
    @Test
    public void test_POST_Req_POSITIVE_TC(){
        // TC > 100 -> Non BDD
        // TC < 100 ->  BDD

        // url,body, header,
        // htttestng.xmlps://restful-booker.herokuapp.com/auth
        // Content-Type: application/json// {
        //    "username" : "admin",
        //    "password" : "password123"
        //}

        // Auth?

       String playload ="{\n" +
               "    \"username\" : \"admin\",\n" +
               "    \"password\" : \"password123\"\n" +
               "}";
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .body(playload).log().all()
                .when().log().all().post()
                .then().log().all().statusCode(200);





    }





}
