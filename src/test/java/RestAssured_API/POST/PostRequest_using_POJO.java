package RestAssured_API.POST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequest_using_POJO {

    @Test
    public void postRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Info info=new Info();
        info.setTitle("foo");
        info.setBody("bar");
        info.setUserId("1");
        info.setId("101");

        Response response = given()
                .header("Content-type", "application/json")
                //.header(ContentType.JSON)
                .and().body(info)
                .when().post("/posts")
                .then()
                .extract().response();

        Assert.assertEquals(201, response.statusCode());
        Assert.assertEquals("foo", response.jsonPath().getString("title"));
        Assert.assertEquals("bar", response.jsonPath().getString("body"));
        Assert.assertEquals("1", response.jsonPath().getString("userId"));
        Assert.assertEquals("101", response.jsonPath().getString("id"));
    }
}

class Info {
    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    private String title;
    private String body;
    private String userId;
    private String Id;
}
