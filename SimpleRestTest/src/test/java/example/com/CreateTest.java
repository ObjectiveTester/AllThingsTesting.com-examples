package example.com;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * RESTAssured create tests
 *
 */
public class CreateTest extends BaseTest {

    public CreateTest() {
    }

    @Test
    public void testCreateUser() {
        JSONObject data = new JSONObject();
        data.put("name", "James Kirk");
        data.put("job", "Commanding Officer");

        given().contentType("application/json").body(data.toString())
                .when().post("/users").then()
                .body("name", equalTo("James Kirk"))
                .body("id", instanceOf(String.class))
                .statusCode(201);
    }

    @Test
    public void testLoginSuccess() {
        JSONObject data = new JSONObject();
        data.put("email", "eve.holt@reqres.in");
        data.put("password", "test");

        given().contentType("application/json").body(data.toString())
                .when().post("/login").then()
                .body("token", instanceOf(String.class))
                .statusCode(200);
    }

    @Test
    public void testLoginFailure() {
        JSONObject data = new JSONObject();
        data.put("email", "eve.holt@reqres.in");

        given().contentType("application/json").body(data.toString())
                .when().post("/login").then()
                .body("error", equalTo("Missing password"))
                .statusCode(400);
    }

}
