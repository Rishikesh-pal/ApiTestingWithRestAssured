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

public class updateBooking extends baseTests {
    baseTests base = new baseTests();
    @Test(groups = {"p0","sanity"})
    @Owner("Rishi")
    @Severity(SeverityLevel.NORMAL)
    @Description("verify update booking working fine")
    public void testpdateBooking() throws JsonProcessingException {
        requestSpecification.baseUri(API_Constants.BASE_URL);
        requestSpecification.basePath(API_Constants.CREATE_BOOKING);
        requestSpecification.cookie("token",
                base.getToken());
        Response response = RestAssured.given().spec(requestSpecification)
                .when()
                .body(payloadmanager.createPayload())
                .post();
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        jsonPath = JsonPath.from(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        requestSpecification.baseUri(API_Constants.BASE_URL);
        requestSpecification.basePath(API_Constants.UPDATE_BOOKING+"/"+bookingId);
        response = RestAssured.given().spec(requestSpecification)
                .when()
                .body(payloadmanager.updatedPayload())
                .put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
    }
}

