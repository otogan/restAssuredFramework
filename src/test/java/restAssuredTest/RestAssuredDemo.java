package restAssuredTest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RestAssuredDemo extends BaseClass{

    @Test
    public void test1() {
        int code = RestAssured.given()
//                .auth().preemptive()
//                .basic("ToolsQA", "TestPassword")
//                .when()
//                .get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
                .get()
                .getStatusCode();

        System.out.println("Response Code from server is " + code);
    }
}
