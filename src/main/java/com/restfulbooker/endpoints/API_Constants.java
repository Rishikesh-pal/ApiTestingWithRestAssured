package com.restfulbooker.endpoints;

import com.restfulbooker.utils.FilloUtils;

public class API_Constants {
    public static String BASE_URL  = "https://restful-booker.herokuapp.com";
//    public static String Base_URL = FilloUtils.fetchDtaFromXLSX("sheet1","BaseUrl","value");
    public static String AUTH_URL = "/ping";
    public static String CREATE_BOOKING  = "/booking";
    public static String UPDATE_BOOKING  = "/booking";


    // Stage - URL 1 --> stage_td.xsls
    // Preprod - URL 2 --> preprod_td.xsls
    // Pord - URL 3 --> prod_td.xsls
    // Fetch data --> CSV,YAML,PROPERTIES.JSON,TXT
    // YAML --> (Key-Value pair - Preferred nowadays)
}
