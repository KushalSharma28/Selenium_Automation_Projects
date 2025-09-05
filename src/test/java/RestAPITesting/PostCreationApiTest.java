package RestAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class PostCreationApiTest {
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testCreateNewPost() {
        // Request body as a JSON string or map
        String requestBody = "{\n" +
                             "    \"title\": \"foo\",\n" +
                             "    \"body\": \"bar\",\n" +
                             "    \"userId\": 1\n" +
                             "}";

        Response response = RestAssured.given()
                                .contentType(ContentType.JSON) // Set Content-Type header
                                .body(requestBody)             // Set request body
                                .when()
                                .post("/posts");

        response.then()
                .statusCode(201) // Assert status code for creation
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1))
                .body("id", notNullValue()); // Assert that an ID is generated

        System.out.println("POST /posts - Status: " + response.statusCode());
        System.out.println("Request Body: " + requestBody);
        System.out.println("Response Body: " + response.asString());
    }
}
