package RestAssured_API.GET;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

public class GetDataFromRequest {
    int id ;
    @Test
    public void CreateUser() {
        HashMap tdata = new HashMap();
        tdata.put("title", "Vishal");
        tdata.put("body", "Eng");

         id = given()
                 .header("Accept", "application/json")
                 .header("Content-Type", "application/json")
                .body(tdata)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts/1")
                .jsonPath().getInt("id");
        System.out.println("New ID" + id);
    }

    @Test(dependsOnMethods = {"GetDataFromRequest"})
    public void UpdateUser() {
        HashMap tdata = new HashMap();
        tdata.put("name", "Vishal");
        tdata.put("job", "Tester");

       given()
                .contentType("application/json")
                .body(tdata)
                .when()
                .put("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(201).log().all();

       // System.out.println("New ID" + id);

    }
    @Test
    public void JsonPathExample(){
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
        JsonPath jsonPathEvaluator = response.jsonPath();

        String title = jsonPathEvaluator.getString("title");
        System.out.println("Title received from Response: " + title);
        Assert.assertEquals(title, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "Correct title received");

        int userId = jsonPathEvaluator.getInt("userId");
        System.out.println("User ID received from Response: " + userId);

    }

    @Test
    public void PathAndQueryParm(){
        //https://reqres.in/api/users?page=2&id=5
        given().pathParams("mypath","users")
                .queryParam("page",2)
                .queryParam("id",5)

                .when()
                .get("https://reqres.in/api/api{mypath}")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void HandlingCooks() {
        Response res = given().when().get("https://www.google.com/");
        System.out.println( res.getCookie("AEC"));
        Map<String,String> cookies=res.getCookies();
        for(String k:cookies.keySet()){
            System.out.println(k +"    "+res.getCookie(k));
        }

    }

    @Test
    public void TestHeaders() {
        Response res = given().when().get("https://www.google.com/");
        System.out.println( res.getHeader("Content-Type"));
        Headers headers=res.getHeaders();
        for(Header h:headers){
            System.out.println(h.getName() +" =>  "+h.getValue());
        }
    }
    @Test
    public void LogginDemo() {
       given().when().get("https://www.google.com/").then().log().cookies();


        given().when().get("https://www.google.com/").then().log().headers();
        given().when().get("https://www.google.com/").then().log().all();

    }




}
