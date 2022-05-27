package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class JobResourceTest {

//    @Test
//    public void testHelloEndpoint() {
//        given()
//                .when().get("/job")
//                .then()
//                .statusCode(200)
//                .body(is("[]"));
//
//        Job job = Job.builder()
//                .name("Name 1")
//                .vendorCode("code 1")
//                .build();
//        given()
//                .body(job)
//                .contentType("application/json")
//                .when().post("/job")
//                .then()
//                .body(is(""))
//                .statusCode(200);
//    }

    @Test
    public void testIt() {
        Job.builder().id(1).build();
    }

}