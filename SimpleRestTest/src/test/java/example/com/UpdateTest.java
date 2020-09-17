package example.com;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * RESTAssured update tests
 *
 */
public class UpdateTest extends BaseTest {

    public UpdateTest() {
    }

    @Test
    public void testPutRequest() {
        JSONObject data = new JSONObject();
        data.put("name", "Hikaru Sulu");
        data.put("job", "Helmsman");

        given().contentType("application/json").body(data.toString())
                .when().put("/users/2").then()
                .body("name", equalTo("Hikaru Sulu"))
                .body("updatedAt", instanceOf(String.class))
                .statusCode(200);
    }

    @Test
    public void testPatchRequest() {
        JSONObject data = new JSONObject();
        data.put("name", "Nyota Uhura");
        data.put("job", "Communications Officer");

        given().contentType("application/json").body(data.toString())
                .when().patch("/users/2").then()
                .body("name", equalTo("Nyota Uhura"))
                .body("updatedAt", instanceOf(String.class))
                .statusCode(200);
    }

}
