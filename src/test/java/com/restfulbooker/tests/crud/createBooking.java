package com.restfulbooker.tests.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restfulbooker.endpoints.API_Constants;
import com.restfulbooker.tests.base.baseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class createBooking extends baseTests {
//    private static final Logger log = LogManager.getLogger(CreateBookingTest.class);
    @Test(groups = {"po","sanity"})
    @Owner("Rishi")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Booking can be Created")
    public void testCreateBooking() throws JsonProcessingException {
        requestSpecification.basePath(API_Constants.CREATE_BOOKING);
        Response response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadmanager.createPayload()).post();
        ValidatableResponse validatableResponse = response.then().log().all();
        jsonPath = JsonPath.from(response.asString());
        System.out.println("Booking Id :" + jsonPath.getString("bookingid"));
        validatableResponse.statusCode(200);
        String bookingId = jsonPath.getString("bookingid");
        assertThat(bookingId).isNotNull().isNotEmpty();
    }
}
