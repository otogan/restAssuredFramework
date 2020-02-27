package oAuthDemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoopOAuth2 {

    @Test
    public String getAccessToken() {
        Response response = RestAssured.given()
                .formParam("client_id", "My Rest Assured App")
                .formParam("client_secret", "368fdbc4cc45877f4d6222c644bceb59")
                .formParam("grant_type", "client_credentials")
                .post("http://coop.apps.symfonycasts.com/token");

        Assert.assertEquals(response.getStatusCode(), 200);
        
        System.out.println(response.jsonPath().prettify());

        String accessToken = response.jsonPath().get("access_token");

        System.out.println(accessToken);

        return accessToken;
    }

    public int feedChicken(String accessToken) {
        Response response = RestAssured.given()
                .auth()
                .oauth2(accessToken)
                .post("http://coop.apps.symfonycasts.com/api/788/chickens-feed");

        System.out.println("Code " + response.getStatusCode());
        System.out.println("Code JSON\n" + response.getBody().asString());

        return response.getStatusCode();
    }

    @Test
    private void feedChickenTest() {
        int status = feedChicken(getAccessToken());
        Assert.assertEquals(status, 200);
    }
}
