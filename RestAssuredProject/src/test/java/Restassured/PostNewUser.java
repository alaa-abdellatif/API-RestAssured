package Restassured;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostNewUser {
    @Test
    public void AddNewUser()
    {
        String body = "{\n" +
                "    \"fname\": \"Alaa\",\n" +
                "    \"lname\": \"Abdellatif\",\n" +
                "    \"country\": \"Egypt\",\n" +
                "    \"id\": \"?\"\n" +
                "}";
        given()
                .baseUri("https://655d11ad25b76d9884fe5b6b.mockapi.io")
                .contentType(ContentType.JSON)
                .body(body)
        .when()
                .post("Database")
        .then()
                .log().all()
                .assertThat().statusCode(201);
    }
    @Test
    public void AddNewUser2()
    {
        File body = new File("src/test/resources/body.json");
        given()
                .baseUri("https://655d11ad25b76d9884fe5b6b.mockapi.io")
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
        .when()
                .post("Database")
        .then()
                .log().all()
                .assertThat().statusCode(201);
    }
    @Test
    public void AddNewUser3()
    {
        HashMap<String,String> body = new HashMap<>();
        body.put("fname", "Esraa");
        body.put("lname", "Abdellatif");
        body.put("country", "Egypt");
        body.put("id", "?");

        given()
                .baseUri("https://655d11ad25b76d9884fe5b6b.mockapi.io/")
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
        .when()
                .post("Database")
        .then()
                .log().all()
                .assertThat().statusCode(201);
    }
}