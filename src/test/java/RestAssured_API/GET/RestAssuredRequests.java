package RestAssured_API.GET;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

//https://httpbin.org/#/

public class RestAssuredRequests {

    @BeforeSuite
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    @Test
    public void whenMeasureResponseTime_thenOK() {
        Response response = RestAssured.get("/posts");
        long timeInMS = response.time();
        long timeInS = response.timeIn(TimeUnit.SECONDS);
        System.out.println("Response Time in Second:"+timeInS);
        assertEquals(timeInS, timeInMS/1000);
    }
    @Test
    public void getRequest() {
        Response response = given().contentType(ContentType.JSON)
                .when().get("/posts")
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());
        assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }
//Use @PathParam for API calls that are meant to fetch, update, delete, or interact with a specific resource.
// Use @QueryParam for APIs where parameters are used to sort, filter, or determine the format of the output
// without changing the resource itself

    //https://httpbin.org/#/HTTP_Methods/get_get
    @Test
    public void Using_queryParams(){
        /*Response response=given().queryParam("userId","1")
                .queryParam("id","1")
                .when()
                .get("https://jsonplaceholder.typicode.com/posts");
        response.prettyPrint();*/
        Response response=given().queryParams("userId","1","id","1")
                //.queryParam("id","1")
                .when()
                .get("https://jsonplaceholder.typicode.com/posts");
        response.prettyPrint();

    }
    @DisplayName("Query Parameter Example : get the User ID")
    @Test
    public void Using_queryParam_Using_HasMap(){
        HashMap<String,Object> parms=new HashMap<>();
        parms.put("userId","1");
        Response response=given().queryParams(parms)
                .queryParam("id","1")
                .when()
                .get("https://jsonplaceholder.typicode.com/posts");
        response.prettyPrint();
    }

    @DisplayName("Path Parameter Example : get the User ID")
    @Test
    public void Path_Parameters(){
        Response response=given()
                .pathParam("id","1")
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1");
        response.prettyPrint();
    }

    @DisplayName("Path Parameter Example : get the User ID")
    @Test
    public void Path_Parameters_Dynamic_Path(){
        Response response=given()
                .pathParam("id","1")
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/{id}");
        response.prettyPrint();
    }
}
