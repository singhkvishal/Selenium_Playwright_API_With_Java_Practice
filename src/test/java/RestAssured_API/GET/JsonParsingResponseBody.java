package RestAssured_API.GET;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matcher.*;

import static graphql.com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;


public class JsonParsingResponseBody {
    @Test
    public void Test1() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1/comments")
                .then()
                .statusCode(200)
                .header("Content-Type=","application/json; charset=utf-8")
                .body("$[1].email", (ResponseAwareMatcher<Response>) equalTo("Jayne_Kuhic@sydney.com"));
    }
    @Test
    public void Test2() {
      Response res=  given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1/comments");

        Assert.assertEquals( res.getStatusCode(),"200");
    }

    @Test
    public void Test3() {
        Response res=  given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1/comments");

        Assert.assertEquals( res.header("Content-Type"),"application/json; charset=utf-8");
    }
    @Test
    public void Test4() {
        Response res=  given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1/comments");

        Assert.assertEquals( res.jsonPath().getString("$[0].email"),"Eliseo@gardner.biz");
    }

}
