package com.restfulbooker.tests.base;

import com.restfulbooker.modules.Payloadmanager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.Assertion;

public class baseTests {
    public RequestSpecification requestSpecification;
    public Payloadmanager payloadmanager;
    public Response response;

    @BeforeMethod
    public void setupConfig(){
        payloadmanager = new Payloadmanager();


    }

}
