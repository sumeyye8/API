package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get02b extends ReqresBaseUrl {


     /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void get02(){

        // Set the URL
        spec.pathParams("first","users","second",23); //extends yaptıgımız icin artık spec ile baslıyoruz.

        // Set the Expected Data

        //Send the Request and get the Response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        // HTTP Status code should be 404

        assertEquals(404,response.statusCode());

        // Status Line should be HTTP/1.1 404 Not Found
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());

        // Server is "cloudflare"
        assertEquals("cloudflare", response.header("Server"));

        // Response body should be empty
        assertEquals(2, response.asString().replaceAll("\\s","").length());  // 2 curly_braces dısındakileri siler,
                                                                                                                           // response body empty


    }
}
