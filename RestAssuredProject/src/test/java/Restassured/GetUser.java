package Restassured;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetUser {
    @Test
    public void GetAllUsers ()
    {
        given()
                .baseUri("https://655d11ad25b76d9884fe5b6b.mockapi.io")
        .when()
                .get("Database")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void GetSpecificUser()
    {
        given()
                .baseUri("https://655d11ad25b76d9884fe5b6b.mockapi.io")
        .when()
                .get("Database/5")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void GetSpecificUser2()
    {
        given()
                .baseUri("https://655d11ad25b76d9884fe5b6b.mockapi.io")
                .queryParam("country", "Italy")
        .when()
                .get("Database")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void GetSpecificUser3()
    {
        given()
                .baseUri("https://655d11ad25b76d9884fe5b6b.mockapi.io")
                .queryParams("country","England", "lname", "Murphy")
        .when()
                .get("Database")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void GetSpecificUser4() {
        HashMap<String,String> Queries = new HashMap<>();
        Queries.put("country", "England");
        Queries.put("lname","Murphy");
        given()
                .baseUri("https://655d11ad25b76d9884fe5b6b.mockapi.io")
                .queryParams(Queries)
        .when()
                .get("Database")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}