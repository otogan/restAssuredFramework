package restAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostDeletePutExample {

    @Test
    public void testPost() {
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        json.put("id", "22");
        json.put("title", "test title 22");
        json.put("author", "someone 22");

        System.out.println(json.toJSONString());

        request.body(json.toJSONString());

        Response response = request.post("http://localhost:3000/posts");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 201);
    }

    @Test
    public void testDelete() {
        RequestSpecification request = RestAssured.given();

        Response response = request.delete("http://localhost:3000/posts/22");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void testPut() {
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        json.put("id", "25");
        json.put("title", "this is a new title for 21");
        json.put("author", "somebody 21");

        request.body(json.toJSONString());

        Response response = request.put("http://localhost:3000/posts/25");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }
}
