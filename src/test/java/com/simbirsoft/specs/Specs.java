package com.simbirsoft.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.with;

public class Specs {

    public static RequestSpecification methodRequest(String path, String contentType, String body) {
        return with()
                .baseUri(baseURI)
                .basePath(path)
                .body(body)
                .contentType(contentType)
                .log().all();
    }

    public static RequestSpecification methodRequest(String baseUrl, String path) {
        return with()
                .baseUri(baseUrl)
                .basePath(path)
                .log().all();
    }

    public static ResponseSpecification responseSpec(int statusCode) {
        return new ResponseSpecBuilder().expectStatusCode(statusCode).build();
    }
}
