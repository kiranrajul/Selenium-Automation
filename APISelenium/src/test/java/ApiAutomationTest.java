import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class ApiAutomationTest {

    public static void main(String[] args) {
        // Define the base URL also we can separate base url and end point if needed
        String baseUrl = "https://reqres.in/api/users/4";
        try {
            // Perform a GET request
            Response response = RestAssured.get(baseUrl);
            if (response != null) {
                // Print the response status code
                System.out.println("Status Code: " + response.getStatusCode());
                // Print the response body (data) as string
                System.out.println("Response Body: " + response.getBody().asString());
                // Validate the status code
                Assertions.assertEquals(200, response.getStatusCode(), "Expected status code is 200");
                System.out.println("Test Passed: The status code is 200");
            } else {
                System.out.println("Test Failed: No response received");
            }
        } catch (Exception e) {
            System.out.println("Test Failed: An error occurred");
            e.printStackTrace();
        }
    }
}


