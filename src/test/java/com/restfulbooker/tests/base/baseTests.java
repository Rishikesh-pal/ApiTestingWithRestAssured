package com.restfulbooker.tests.base;

import com.restfulbooker.endpoints.API_Constants;
import com.restfulbooker.modules.Payloadmanager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.Assertion;

public class baseTests {
    public RequestSpecification requestSpecification;
    public Payloadmanager payloadmanager;
    public Response response;
    public JsonPath jsonPath;
    public ValidatableResponse validatableResponse;

    @BeforeMethod
    public void setupConfig(){
        payloadmanager = new Payloadmanager();
        requestSpecification =(RequestSpecification) new RequestSpecBuilder()
                .setBaseUri(API_Constants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build()
                .log().all();
    }

    public String getToken(){
        requestSpecification = RestAssured.given()
                .baseUri(API_Constants.BASE_URL)
                .basePath(API_Constants.AUTH_URL);

        return null;
    }

}
