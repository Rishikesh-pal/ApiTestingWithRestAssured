package com.restfulbooker.tests.integrationtests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restfulbooker.endpoints.API_Constants;
import com.restfulbooker.tests.base.baseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

//Create a Booking, Update the Booking Name, Get the Booking by Id and verify.
public class integrationTest1 extends baseTests {
    String token;
    @Test(groups = "integration")
    @Owner("Rishi")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that the Booking can be Created")
    public void testCreateBooking(ITestContext iTestContext) throws JsonProcessingException {
        requestSpecification.basePath(API_Constants.CREATE_BOOKING);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadmanager.createPayload()).post();
        validatableResponse = response.then().log().all();
        jsonPath = JsonPath.from(response.asString());
        validatableResponse.statusCode(200);
        iTestContext.setAttribute("bookingid",jsonPath.getString("bookingid"));
    }

    @Test(dependsOnMethods = "testCreateBooking", groups = "integration")
    @Owner("Rishi")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the Booking can be updated")
    public void testUpdateBooking(ITestContext iTestContext) throws JsonProcessingException {
        token=getToken();
        String bookingId = (String) iTestContext.getAttribute("bookingid");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.basePath(API_Constants.UPDATE_BOOKING + "/" + bookingId);
        response = RestAssured.given()
                .spec(requestSpecification)
                .cookie("token",token)
                .when()
                .body(payloadmanager.updatedPayload())
                .put();
        validatableResponse = response.then().log().all();
        jsonPath = JsonPath.from(response.asString());
        validatableResponse.statusCode(201);
        String firstname = jsonPath.getString("firstname");
        validatableResponse.body("firstname", Matchers.is("Lucky"));
    }

    @Test
    @Owner("Rishi")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the created Booking can be get")
    public void testGetBooking(ITestContext iTestContext){
        requestSpecification.basePath(API_Constants.UPDATE_BOOKING + "/" +
                (String) iTestContext.getAttribute("bookingid"))
                .cookie("token",token);
        validatableResponse = RestAssured.given()
                .spec(requestSpecification)
                .auth()
                .basic("admin", "password123")
                .when()
                .delete()
                .then().log().all();
        validatableResponse.statusCode(201);
    }
}
