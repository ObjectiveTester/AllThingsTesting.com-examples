package example.com;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;

/**
 * RESTAssured delete test
 *
 */
public class DeleteTest extends BaseTest {

    public DeleteTest() {
    }

    @Test
    public void testDeleteRequest() {
        given().when().delete("/users/2").then()
                .statusCode(204);
    }

}
