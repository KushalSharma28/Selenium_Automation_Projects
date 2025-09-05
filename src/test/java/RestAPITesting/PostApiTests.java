package RestAPITesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class PostApiTests {
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testGetPostById() {
        int postId = 1;

        Response response = RestAssured.given()
                                .pathParam("postId", postId)
                                .when()
                                .get("/posts/{postId}");

        response.then()
                .statusCode(200) // Assert status code
                .body("id", equalTo(postId)) // Assert 'id' field value
                .body("title", notNullValue()) // Assert 'title' field exists and is not null
                .body("body", notNullValue()); // Assert 'body' field exists and is not null

        System.out.println("GET /posts/" + postId + " - Status: " + response.statusCode());
        System.out.println("Response Body: " + response.asString());
    }
}
