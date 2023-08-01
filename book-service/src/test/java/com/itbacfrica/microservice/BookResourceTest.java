package com.itbacfrica.microservice;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class BookResourceTest {
  // Junit test for
  @Test
  public void shouldGetAllBooks() {
    given()
        .when()
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .get("/api/books")
        .then()
        .statusCode(200)
        .body("size()", is(2));
  }

  @Test
  public void shouldCountAllBooks() {
    given()
        .when()
        .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .get("/api/books/count")
        .then()
        .statusCode(200)
        .body(is("2"));
  }

  @Test
  public void shouldGetBokkById() {
    given()
        .when()
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .pathParam("id", 1)
        .get("/api/books/{id}")
        .then()
        .statusCode(200)
        .body("title", is("Understanding Quarkus"))
        .body("author", is("Antonio"))
        .body("yearOfPublication", is(2020));
  }
}
