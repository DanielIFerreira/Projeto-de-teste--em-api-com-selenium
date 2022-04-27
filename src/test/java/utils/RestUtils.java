package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    private static Response response;

    public Response getResponse() {
        return response;
    }

    public static void setBaseURI(){
        RestAssured.baseURI = "http://localhost:8080/";
    }
    public static String getBaseURI(){
        return RestAssured.baseURI;
    }

    public static Response get(Map<String, String> header, String endpoint) {
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .get(endpoint);

    }

    public static Response post(Object json, ContentType contentType, String endpoint){
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when()
                .post(endpoint)
                .thenReturn();

    }

}