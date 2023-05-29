package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRestBaseUrl {

    protected RequestSpecification spec;  //protec yaptık inheritance olarak ulasabilmek icin. (extends)

    @Before
    public void setup() {
        spec = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v1/").build();


    }

}