package getRequest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData2 {

    @Test
    public void testResponseCode() {
        Response response = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=2cfb6f5c72cbd929cae4de7f55df8a2b");

        int statusCode = response.getStatusCode();

        System.out.println("Status code is " + statusCode);

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void testBody() {
        Response response = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=2cfb6f5c72cbd929cae4de7f55df8a2b");

        String data = response.asString();

        System.out.println("Data is " + data);

        System.out.println("Response time: " +response.getTime());
    }
}
