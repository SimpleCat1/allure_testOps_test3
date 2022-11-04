package com.simbirsoft.tests;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    private static String baseUrl = "http://demowebshop.tricentis.com";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = baseUrl;
    }
}
