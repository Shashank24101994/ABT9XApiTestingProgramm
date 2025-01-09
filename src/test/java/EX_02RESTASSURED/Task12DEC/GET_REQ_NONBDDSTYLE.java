package EX_02RESTASSURED.Task12DEC;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET_REQ_NONBDDSTYLE
{
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Description("verift get request movieid positivetestcase")
    @Test
    public void test_GET_Req_POSITIVE_TC()
    {
    String movieid ="1";
   r=RestAssured.given();
           r.baseUri("https://dummyapi.online");
           r.basePath("/api/movies/"+movieid);

           response=r.when().log().all().get();
           vr=response.then().log().all().statusCode(200);


    }

    @Description("verift get request movieid negativetestcase:input 0")
    @Test
    public void test_GET_Req_NEGATIVE_TC0()
    {
        String movieid ="0";
        r=RestAssured.given();
        r.baseUri("https://dummyapi.online");
        r.basePath("/api/movies/"+movieid);

        response=r.when().log().all().get();
        vr=response.then().log().all().statusCode(404);


    }
      @Description("verift get request movieid negativetestcase:input -1")
      @Test
       public void test_GET_Req_NEGATIVE_TC1()
     {
        String movieid ="-1";
        r=RestAssured.given();
        r.baseUri("https://dummyapi.online");
        r.basePath("/api/movies/"+movieid);

        response=r.when().log().all().get();
        vr=response.then().log().all().statusCode(404);


    }
    @Description("verift get request movieid negativetestcase:input Alphanumeric")
    @Test
    public void test_GET_Req_NEGATIVE_TC2()
    {
        String movieid ="abc123";
        r=RestAssured.given();
        r.baseUri("https://dummyapi.online");
        r.basePath("/api/movies/"+movieid);

        response=r.when().log().all().get();
        vr=response.then().log().all().statusCode(404);


    }
}
