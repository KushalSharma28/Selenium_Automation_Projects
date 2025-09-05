package RestAPITesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserCreationTest {
	private final String BASE_URI = "https://api.example.com"; // Replace with your actual base URI

    @Test
    public void testCreateAndVerifyUser() {
        RestAssured.baseURI = BASE_URI;

        // 1. Define Request Body
        String requestBody = "{ \"name\": \"John Doe\", \"email\": \"john.doe@example.com\", \"password\": \"password123\" }";

        // 2. Send POST Request
        Response postResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/users");

        // 3. Assert POST Response
        assertEquals(201, postResponse.getStatusCode(), "Expected status code 201 for user creation.");
        String userId = postResponse.jsonPath().getString("id"); // Assuming ID is returned in response
        assertNotNull(userId, "User ID should not be null after creation.");

        System.out.println("User created successfully with ID: " + userId);

        // 4. Send GET Request
        Response getResponse = RestAssured.given()
                .get("/users/" + userId);

        // 5. Assert GET Response
        assertEquals(200, getResponse.getStatusCode(), "Expected status code 200 for retrieving user.");
        assertEquals("John Doe", getResponse.jsonPath().getString("name"), "Retrieved user name should match.");
        assertEquals("john.doe@example.com", getResponse.jsonPath().getString("email"), "Retrieved user email should match.");

        System.out.println("User details verified successfully.");
    }
}
