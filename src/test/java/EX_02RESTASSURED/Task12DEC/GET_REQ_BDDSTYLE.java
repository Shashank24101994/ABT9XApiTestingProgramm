package EX_02RESTASSURED.Task12DEC;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GET_REQ_BDDSTYLE
{
 @Description("verift get request movieid positivetestcase")
@Test
 public void test_GET_Req_POSITIVE_TC()
 {
  String movieid ="1";
  RestAssured.given()
          .baseUri("https://dummyapi.online")
          .basePath("api/movies/"+movieid)
          .when()
          .log().all()
          .get()
          .then().log().all()
          .statusCode(200);
 }
 @Description("verift get request movieid negativetestcase:input -1")
 @Test
 public void test_GET_Req_NEGATIVE_TC()
 {
  String movieid ="-1";
  RestAssured.given()
          .baseUri("https://dummyapi.online")
          .basePath("api/movies/"+movieid)
          .when()
          .log().all()
          .get()
          .then().log().all()
          .statusCode(404);
 }

@Description("verift get request movieid negativetestcase:input 0")
 @Test
 public void test_GET_Req_NEGATIVE_TC2()
 {
  String movieid ="0";
  RestAssured.given()
          .baseUri("https://dummyapi.online")
          .basePath("api/movies/"+movieid)
          .when()
          .log().all()
          .get()
          .then().log().all()
          .statusCode(404);
 }

}
