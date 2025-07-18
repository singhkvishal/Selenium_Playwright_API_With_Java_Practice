package RestAssured_API;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAssured_Auth {
    @Test
    public void Basic_Auth() {
        //RestAssured.proxy("Host",31231);
        /*
        -Basic authentication helps you access the secured APIs and perform actions on the resources.
        -Rest assured has four types of authentication schemes. They are basic, digest, form, and OAuth authentication.
        -By default, rest assured uses a challenge-response mechanism. But, a preemptive directive sends the credentials without waiting for the server.
        -OAuth has two types - OAuth1.0 or OAuth2.0.
         */
        //1- Basic Auth
        //RequestSpecification httpRequest = RestAssured.given().auth().basic("postman", "password");
        //2-preemptive Auth
        //RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic("postman", "password");
        //3-digest Auth
        //RequestSpecification httpRequest = RestAssured.given().auth().digest("postman", "password");
        //4-Form Authentication
        //RequestSpecification httpRequest = RestAssured.given().auth().form("postman", "password");
        //5- OAuth Authentication-OAuth 1.0
        //RequestSpecification httpRequest = RestAssured.given().auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret);
        //6- OAuth Authentication-OAuth 2.0
        //RequestSpecification httpRequest = RestAssured.given().auth().oauth2(consumerKey, consumerSecret, accessToken, tokenSecret);

        RequestSpecification httpRequest = RestAssured.given().auth().basic("postman", "password");
        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- " + rbdy);
    }
}