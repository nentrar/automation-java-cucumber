package stepdefs.api.restassured;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredDefinitions {

    static final Logger log = Logger.getLogger(RestAssuredDefinitions.class.getName());

    @Given("^JSON placeholder server is up$")
    public void json_placeholder_is_running() {
        given().when().get("https://jsonplaceholder.typicode.com/posts/").then().statusCode(200);
    }

    @And("^title on the post is equal to \\\"([^\\\"]*)\\\"$")
    public void check_title_equal(String title) {
        given().when().get("https://jsonplaceholder.typicode.com/posts/2").then()
                .body("title",equalTo(title));
    }

    @When("^new post is created with the following parameters")
    public void new_post_is_created(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);

        Map<String,String> post = new HashMap<>();
        post.put("title", list.get(0).get("Title"));
        post.put("body", list.get(0).get("Body"));
        post.put("userId", list.get(0).get("UserID"));

        given()
                .contentType("application/json")
                .body(post)
                .when().post("https://jsonplaceholder.typicode.com/posts").then()
                .statusCode(201);
    }

    @Then("^post title has been changed to \\\"([^\\\"]*)\\\"$")
    public void change_post_title(String title) {

        Map<String,String> update = new HashMap<>();
        update.put("title", title);


        given()
                .contentType("application/json")
                .body(update)
                .when().patch("https://jsonplaceholder.typicode.com/posts/1").then()
                .statusCode(200);
    }

    @And("^post is deleted$")
    public void delete_post() {
        given().when().delete("https://jsonplaceholder.typicode.com/posts/1").then().statusCode(200);
    }



}
