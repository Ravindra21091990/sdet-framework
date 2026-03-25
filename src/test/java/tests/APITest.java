package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.TestListener.class)
public class APITest {

    @Test
    public void getUsersTest() {

        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1");

        System.out.println(response.getBody().asString());
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
