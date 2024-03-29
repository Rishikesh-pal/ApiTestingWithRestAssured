package com.restfulbooker.modules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.restfulbooker.payloads.Booking;
import com.restfulbooker.payloads.Bookingdates;

public class Payloadmanager {
    ObjectMapper objectMapper;
//    Faker faker = new Faker();
    public String createPayload() throws JsonProcessingException {
        objectMapper=new ObjectMapper();
        Booking booking=new Booking();
//        booking.setFirstname(faker.name().firstName());
//        booking.setLastname(faker.name().lastName());
        booking.setFirstname("Raj");
        booking.setLastname("Paul");
        booking.setTotalprice(239);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Lunch,dinner,wine");
        Bookingdates bookingdates=new Bookingdates();
        bookingdates.setCheckin("23-07-23");
        bookingdates.setCheckout("29-07-23");
        booking.setBookingdates(bookingdates);
        String payload=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;
    }
    public String updatedPayload() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        Booking booking = new Booking();
//        booking.setFirstname(faker.name().firstName());
//        booking.setLastname(faker.name().lastName());
        booking.setFirstname("Babu");
        booking.setLastname("Bhat");
        booking.setTotalprice(199);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast, lunch");
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2022-10-01");
        bookingdates.setCheckout("2022-10-01");
        booking.setBookingdates(bookingdates);
        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;
    }

}
