package ex_05payLoadManagement.gson_demo;


import com.google.gson.Gson;
import ex_05payLoadManagement.gson.Booking;
import ex_05payLoadManagement.gson.Bookingdates;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;


public class RestAssured_Payload_gson
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

    Gson gson = new Gson();
    String jsonstringBooking = gson.toJson(booking);
    System.out.println(jsonstringBooking);





        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body( jsonstringBooking).log().all();
        response=r.when().log().all().post();
     String jsonResponseString =response.asString();

        // Get Validatable response to perform validation
        vr= response.then().log().all();
        vr.statusCode(200);

    // Case1 - extract() - Direct Extraction
//    String firstname1 = response.then().extract().path("booking.firstname");
//    System.out.println(firstname1);
//
//    // Case 2 - jsonPath.getString("")  JSON Path Extraction
//
//    JsonPath jsonPath = new JsonPath(response.asString());
//    String bookingId = jsonPath.getString("bookingid");
//    String firstname = jsonPath.getString("booking.firstname");
//    System.out.println(bookingId);
//    System.out.println(firstname);


    BookingResponse bookingResponse = gson.fromJson(jsonResponseString, BookingResponse.class);
    System.out.println(bookingResponse.getBookingid());
    System.out.println(bookingResponse.getBooking().getFirstname());
    System.out.println(bookingResponse.getBooking().getLastname());



    assertThat(bookingResponse.getBookingid());
    assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("shashank");







}
}
