package RestAssured_API.GET;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RestAssuredRequestsQueryParams {
    @BeforeSuite
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void getRequestWithQueryParam() {
        Response response = given().contentType(ContentType.JSON).param("postId", "2")
                .when().get("/comments")
                .then().extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
    }
    @Test
    public void GetTest() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Status Code =>" + response.getStatusCode());
        System.out.println("Time =>" + response.getTime());
        System.out.println("Body =>" + response.getBody().asString());
        System.out.println("Status Line =>" + response.getStatusLine());
        System.out.println("Header   =>" + response.getHeader("content-type"));
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
