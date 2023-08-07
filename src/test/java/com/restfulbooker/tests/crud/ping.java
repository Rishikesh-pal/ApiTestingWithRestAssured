package com.restfulbooker.tests.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restfulbooker.endpoints.API_Constants;
import com.restfulbooker.tests.base.baseTests;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class ping extends baseTests {
    @Owner("Rishi")
    @Description("Verify ping is working fine")
    @Severity(SeverityLevel.BLOCKER)
    @Test(groups = {"po","sanity"})
    public void pingRequest() throws JsonProcessingException {
        requestSpecification.basePath(API_Constants.AUTH_URL);
        response = RestAssured.given()
                .spec(requestSpecification)
                .when()
                .body(payloadmanager.createPayload())
                .get();
        validatableResponse = response.then().log().all();
        jsonPath = JsonPath.from(response.asString());
        validatableResponse.statusCode(201);
    }
}
