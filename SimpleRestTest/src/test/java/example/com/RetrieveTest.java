package example.com;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

/**
 * RESTAssured retrieve tests
 *
 */
public class RetrieveTest extends BaseTest {

    public RetrieveTest() {
    }

    @Test
    public void testGetSingle() {
        given().when().get("/users/2").then()
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .statusCode(200);
    }

    @Test
    public void testGetFail() {
        given().when().get("/users/23").then()
                .statusCode(404);
    }

    @Test
    public void testGetList() {
        given().when().get("/users?page=1").then()
                .body("page", equalTo(1))
                .body("data.size()", is(6))
                .body("data[0].email", equalTo("george.bluth@reqres.in"))
                .statusCode(200);
    }
    
}
