package com.restfulbooker.actions;

import static org.testng.Assert.assertEquals;
import io.restassured.response.Response;


public class AssertActions {
    public void verifyStatusCode(Response response){
            assertEquals(String.valueOf(response.getStatusCode()).startsWith("20"),
                    true,
                    "value of status code is" + response.getStatusCode());
    }
}
