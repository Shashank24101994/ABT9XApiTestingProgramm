package EX04_Assertions;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.LinkedHashMap;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import org.hamcrest.Matchers;


public class RestAssured_TestNg_assertJ_ASSERTION
{
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    Integer bookingId;
@Test
    public void test_post (){

     String playload_post ="{\n" +
             "    \"firstname\" : \"shashank\",\n" +
             "    \"lastname\" : \"Brown\",\n" +
             "    \"totalprice\" : 111,\n" +
             "    \"Location\":\"nainpur\",\n" +
             "    \"depositpaid\" : true,\n" +
             "    \"bookingdates\" : {\n" +
             "        \"checkin\" : \"2018-01-01\",\n" +
             "        \"checkout\" : \"2019-01-01\"\n" +
             "    },\n" +
             "    \"additionalneeds\" : \"Breakfast\"\n" +
             "}";
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body( playload_post).log().all();
        response=r.when().log().all().post();

        // Get Validatable response to perform validation
        vr= response.then().log().all();
        vr.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers;
        // Matchers.equalto()

        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("shashank"));
        vr.body("booking.lastname",Matchers.equalTo("Brown"));
        vr.body("booking.depositpaid",Matchers.equalTo(true));
        vr.body("booking.totalprice",Matchers.equalTo(111));

      //testng assertion
        bookingId = response.then().extract().path("bookingid");
        String Firstname =response.then().extract().path("booking.firstname");
       String Lastname =response.then().extract().path("booking.lastname");

       /* Assert.assertNotNull(bookingId);
        Assert.assertEquals(Firstname,"shashank");
        Assert.assertEquals(Lastname,"jain")*/

     // assert j

    assertThat(bookingId).isNotNull().isNotZero().isPositive();
    assertThat(Firstname).isEqualTo("shashank").isNotNull().isNotEmpty();





   }
}
