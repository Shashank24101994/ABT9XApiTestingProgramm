package ex_05payLoadManagement;

import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Payload_STRINGMAP {
    @Test
    public void test_payload() {

        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap();
        jsonBodyUsingMap.put("firstname", "shashank");
        jsonBodyUsingMap.put("lastname", "jain");
        jsonBodyUsingMap.put("totalprice", 123);
        jsonBodyUsingMap.put("depositpaid", false);
        Map<String, Object> bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");
        System.out.println(jsonBodyUsingMap);
// Map -> JSON ? ( GSON, Jackson API)(USED GSON LIBARARY)

    }
}
