package RestAssured_API.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Reusability_Example {
    @BeforeSuite
    public void init(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        //RestAssured.port=12;
        RestAssured.basePath="/posts";
    }
    @DisplayName("Path Parameter Example : get the User ID")
    @Test
    public void Path_Parameters(){
        Response response=given()
                .when()
                .get("1");

        response.prettyPrint();

        ///Rest will reset the baseURI,basePath etc. hence it will display the error
        RestAssured.reset();
        Response response1=given()
                .when()
                .get("1");
    }
}
