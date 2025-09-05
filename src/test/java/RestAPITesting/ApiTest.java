package RestAPITesting;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiTest {
    private static final String BASE_URL = "http://example.com/api";
    private static String authToken;

    private static void authenticateUser (String username, String password) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(BASE_URL + "/auth/login");
            String json = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);
            StringEntity entity = new StringEntity(json);
            post.setEntity(entity);
            post.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(post);
            String responseBody = EntityUtils.toString(response.getEntity());

            if (response.getStatusLine().getStatusCode() == 200) {
                // Extract token from response
                authToken = responseBody; // You would parse the JSON to get the token
                System.out.println("Authentication successful: " + authToken);
            } else {
                System.out.println("Authentication failed: " + responseBody);
            }
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testGetUsers() {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(BASE_URL + "/users");
            post.setHeader("Authorization", "Bearer " + authToken);

            HttpResponse response = client.execute(post);
            String responseBody = EntityUtils.toString(response.getEntity());

            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("Users retrieved successfully: " + responseBody);
            } else {
                System.out.println("Failed to retrieve users: " + responseBody);
            }
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testGetUsersWithoutAuth() {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(BASE_URL + "/users");

            HttpResponse response = client.execute(post);
            String responseBody = EntityUtils.toString(response.getEntity());

            if (response.getStatusLine().getStatusCode() == 401) {
                System.out.println("Access denied as expected: " + responseBody);
            } else {
                System.out.println("Unexpected response: " + responseBody);
            }
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testCreateUserWithMissingFields() 
    {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(BASE_URL + "/users");
            post.setHeader("Authorization", "Bearer " + authToken);
            String json = "{\"username\":\"newuser\"}"; // Missing password
            StringEntity entity = new StringEntity(json);
            post.setEntity(entity);
            post.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(post);
            String responseBody = EntityUtils.toString(response.getEntity());

            if (response.getStatusLine().getStatusCode() == 400) {
                System.out.println("Error for missing fields as expected: " + responseBody);
            } else {
                System.out.println("Unexpected response: " + responseBody);
            }
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testCreateUserWithDuplicateUsername() 
    {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(BASE_URL + "/users");
            post.setHeader("Authorization", "Bearer " + authToken);
            String json = "{\"username\":\"testuser\", \"password\":\"password123\"}"; // Duplicate username
            StringEntity entity = new StringEntity(json);
            post.setEntity(entity);
            post.setHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(post);
            String responseBody = EntityUtils.toString(response.getEntity());

            if (response.getStatusLine().getStatusCode() == 409) {
                System.out.println("Duplicate username error as expected: " + responseBody);
            } else {
                System.out.println("Unexpected response: " + responseBody);
            }
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Test authentication
        authenticateUser ("testuser", "password123");

        // Test accessing protected resource
        testGetUsers();

        // Test error handling: Accessing without authentication
        testGetUsersWithoutAuth();

        // Test edge cases: Create user with missing fields
        testCreateUserWithMissingFields();

        // Test edge cases: Create user with duplicate username
        testCreateUserWithDuplicateUsername();

        // Close the driver
        driver.quit();
    }
}
