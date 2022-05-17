package com.restassured.tests;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static com.restassured.automation.helpers.SpecialMethods.*;
import static io.restassured.RestAssured.given;


public class RequestResponseTest extends TestBase {


    @Test
    public void testSingleUserGet(){
        given()
            .get(properties.getProperty("endpointGetSingleUser"))
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("data.first_name", equalTo(validationGetName))
            .body("data.last_name", equalTo(validationGetLastName))
            .body("data.id",equalTo(Integer.valueOf(validationGetId)));
    }


    @Test
    public void testLoginPost(){
        given()
            .body("{\n" +
                    "    \"email\": \"eve.holt@reqres.in\",\n" +
                    "    \"password\": \"cityslicka\"\n" +
                    "}")
            .post(properties.getProperty("endpointPostLogin"))
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("token", equalTo(validationGetToken));
    }


    @Test
    public void testCreateUserPost(){
       given()
           .body("{\n" +
                   "    \"name\": \"morpheus\",\n" +
                   "    \"job\": \"Senior Test Automation\"\n" +
                   "}")
           .post(properties.getProperty("createUserPath"))
           .then()
           .statusCode(HttpStatus.SC_CREATED)
           .body("job", equalTo(validationPostJob));
    }


    @Test
    public void testUserDelete(){
        given()
            .delete(properties.getProperty("endpointGetSingleUser"))
            .then()
            .statusCode(HttpStatus.SC_NO_CONTENT);
    }


    @Test
    public void testUpdateUserPatch(){
       given()
           .body("{\n" +
                   "    \"name\": \"Daniel\"}")
           .patch(properties.getProperty("endpointGetSingleUser"))
           .then()
           .statusCode(HttpStatus.SC_OK)
           .body("name",equalTo(validationPatchName));
    }


    @Test
    public void testUpdateUserPut(){
       given()
           .body("{\n" +
                   "    \"name\": \"morpheus\",\n" +
                   "    \"job\": \"engineer\"\n" +
                   "}")
           .put(properties.getProperty("endpointGetSingleUser"))
           .then()
           .statusCode(HttpStatus.SC_OK)
           .body("job",equalTo(validationPutJob));
    }

}




