package example.com;

import io.restassured.*;
import org.junit.jupiter.api.BeforeAll;

/**
 * RESTAssured base class
 *
 */
public class BaseTest {

    public BaseTest() {
    }

    @BeforeAll
    public static void setUpAll() {
        //set up default host, base and port
        //this common class is extended by every test
        //overide the defaults with -Dserver.port=<port>, etc. 
       
        RestAssured.baseURI = System.getProperty("server.host") != null ? System.getProperty("server.host") : "https://reqres.in";
        RestAssured.basePath = System.getProperty("server.base") != null ? System.getProperty("server.base") : "/api";
        RestAssured.port = System.getProperty("server.port") != null ? Integer.valueOf(System.getProperty("server.port")) : 443;

        //System.out.println(RestAssured.baseURI);
        //System.out.println(RestAssured.basePath);
        //System.out.println(RestAssured.port);
    }
    
}
