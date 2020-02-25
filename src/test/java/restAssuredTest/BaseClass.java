package restAssuredTest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    @BeforeClass
    public void setup() {
        RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");
        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
    }
}
