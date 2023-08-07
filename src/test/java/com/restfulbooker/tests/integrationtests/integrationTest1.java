package com.restfulbooker.tests.integrationtests;

import com.restfulbooker.tests.base.baseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class integrationTest1 extends baseTests {

    @Test
    @Owner("Rishi")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Booking can be Created")
    public void testCreateBooking(){

    }

    @Test
    @Owner("Rishi")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the Booking can be updated")
    public void testUpdateBooking(){

    }

    @Test
    @Owner("Rishi")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the created Booking can be get")
    public void testGetBooking(){

    }
}
