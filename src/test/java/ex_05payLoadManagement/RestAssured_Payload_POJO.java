package ex_05payLoadManagement;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class RestAssured_Payload_POJO
{
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    Integer bookingId;
@Test
    public void test_post (){

//     String playload_post ="{\n" +
//             "    \"firstname\" : \"shashank\",\n" +
//             "    \"lastname\" : \"Brown\",\n" +
//             "    \"totalprice\" : 111,\n" +
//             "    \"Location\":\"nainpur\",\n" +
//             "    \"depositpaid\" : true,\n" +
//             "    \"bookingdates\" : {\n" +
//             "        \"checkin\" : \"2018-01-01\",\n" +
//             "        \"checkout\" : \"2019-01-01\"\n" +
//             "    },\n" +
//             "    \"additionalneeds\" : \"Breakfast\"\n" +
//             "}";

//    Map<String,Object> jsonBodyUsingMap=new LinkedHashMap();
//    jsonBodyUsingMap.put("firstname","shashank");
//    jsonBodyUsingMap.put("lastname","jain");
//    jsonBodyUsingMap.put("totalprice",123);
//    jsonBodyUsingMap.put("depositpaid",false);
//    Map<String,Object> bookingDatesMap = new LinkedHashMap();
//    bookingDatesMap.put("checkin","2018-01-01");
//    bookingDatesMap.put("checkout","2019-01-01");
//
//    jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
//    jsonBodyUsingMap.put("additionalneeds", "Breakfast");
//    System.out.println(jsonBodyUsingMap);

     //pojo
    Booking booking=new Booking();
    booking.setFirstname("shashank");
    booking.setLastname("jain");
    booking.setTotalprice(123);
    booking.setDepositpaid(false);

    Bookingdates bookingdates = new Bookingdates();
    bookingdates.setCheckin("2024-02-01");
    bookingdates.setCheckout("2024-02-01");
    booking.setBookingdates(bookingdates);
    booking.setAdditionalneeds("Breakfast");
    System.out.println(booking);


        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body( booking).log().all();
        response=r.when().log().all().post();

        // Get Validatable response to perform validation
        vr= response.then().log().all();
        vr.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers;
        // Matchers.equalto()

        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("shashank"));
        vr.body("booking.lastname",Matchers.equalTo("jain"));
        vr.body("booking.depositpaid",Matchers.equalTo(false));
        vr.body("booking.totalprice",Matchers.equalTo(123));

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
