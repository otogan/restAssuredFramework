package oAuthDemo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TwitterDemo {

    public void postTweet(String message) {
        Response response = RestAssured.given()
                .auth()
                .oauth("dpASeiByDHymU1hbenPRRxomS",
                        "8K27DSnq4V2nJF44kkQrQP1oXk8FKfUFnfFDzxXPQXwducrGvt",
                        "1608955346-PQCX9y5jjHDE9OJLFuSq0lRG1ne1L6spIrl6Vmp",
                        "ARPr2QV7f1jwuHeqBg3IS0H0PEmLFx5HIA4qNr8A94ibR")
                .post("https://api.twitter.com/1.1/statuses/update.json?status=" + message);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().jsonPath().prettify());

        JsonPath json = response.jsonPath();
        String tweetId = json.get("id_str");

        System.out.println("My Tweet Id is " + tweetId);
    }

    @Test
    private void postTweetTest() {
        postTweet("Hello World from my API app.");
    }

    public void destroyTweet(String id) {
        Response response = RestAssured.given()
                .auth()
                .oauth("dpASeiByDHymU1hbenPRRxomS",
                        "8K27DSnq4V2nJF44kkQrQP1oXk8FKfUFnfFDzxXPQXwducrGvt",
                        "1608955346-PQCX9y5jjHDE9OJLFuSq0lRG1ne1L6spIrl6Vmp",
                        "ARPr2QV7f1jwuHeqBg3IS0H0PEmLFx5HIA4qNr8A94ibR")
                .post("https://api.twitter.com/1.1/statuses/destroy/" + id + ".json");

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().jsonPath().prettify());

        JsonPath json = response.jsonPath();
        String tweetId = json.get("id_str");

        System.out.println("My Tweet with the Id " + tweetId + " is deleted.");
    }

    @Test
    private void destroyTweetTest() {
        destroyTweet("1232708652231987200");
    }
}
