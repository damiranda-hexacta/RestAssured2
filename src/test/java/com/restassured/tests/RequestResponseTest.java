package com.restassured.tests;
import com.restassured.automation.models.ValidationsData;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static com.restassured.automation.helpers.SpecialMethods.*;
import static io.restassured.RestAssured.given;


public class RequestResponseTest extends TestBase {

    ValidationsData validationsData = new ValidationsData();


    @Test
    public void testSingleUserGet(){
        given()
            .get(properties.getProperty("endpointGetSingleUser"))
            .then()
            .statusCode(HttpStatus.SC_OK)
            .body("data.first_name", equalTo(validationsData.getValidationGetName()))
            .body("data.last_name", equalTo(validationsData.getValidationGetLastName()))
            .body("data.id",equalTo(Integer.valueOf(validationsData.getValidationGetId())));
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
            .body("token", equalTo(validationsData.getValidationGetToken()));
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
           .body("job", equalTo(validationsData.getValidationPostJob()));
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
           .body("name",equalTo(validationsData.getValidationPatchName()));
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
           .body("job",equalTo(validationsData.getValidationPutJob()));
    }

}




