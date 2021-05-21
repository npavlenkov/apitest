package company;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TaskPost extends BaseApi {
    String s = "https://reqres.in";

    @Test
    public void CREATE() throws IOException {
        JSONObject ob = getJson("src/test/resources/new1.json");
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(ob.toString())
                .post(s + "/api/users")
                .then()
                .statusCode(201)
                .log().all()
                .and();

    }

    @Test
    public void UPDATE() throws IOException {
        JSONObject ob = getJson("src/test/resources/2.json");
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(ob.toString())
                .put(s + "/api/users/2")
                .then()
                .statusCode(200)
                .log().all()
                .and();
    }

    @Test
    public void UPDATE_PATCH() throws IOException {
        JSONObject ob = getJson("src/test/resources/2.json");
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(ob.toString())
                .put(s + "/api/users/2")
                .then()
                .statusCode(200)
                .log().all()
                .and();
    }

    @Test
    public void DELETE() {

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete(s + "/api/users/2")
                .then()
                .statusCode(204)
                .log().all()
                .and();
    }

    @Test
    public void REGISTER_SUCCESSFUL() throws IOException {
        JSONObject ob = getJson("src/test/resources/3.json");
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(ob.toString())
                .post(s + "/api/register")
                .then()
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .statusCode(200)
                .log().all()
                .and();
    }

    @Test
    public void REGISTER_UNSUCCESSFUL() throws IOException {
        JSONObject ob = getJson("src/test/resources/4.json");
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(ob.toString())
                .post(s + "/api/register")
                .then()
                .statusCode(400)
                .log().all()
                .and();
    }
    @Test
    public void LOGIN_SUCCESSFUL() throws IOException {
        JSONObject ob = getJson("src/test/resources/5.json");
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(ob.toString())
                .post(s + "/api/login")
                .then()
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .statusCode(200)
                .log().all()
                .and();
    }
    @Test
    public void LOGIN_UNSUCCESSFUL() throws IOException {
        JSONObject ob = getJson("src/test/resources/6.json");
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(ob.toString())
                .post(s + "/api/login")
                .then()
                .statusCode(400)
                .log().all()
                .and();
    }

    @Test
    public void DELAYED_RESPONSE() {
        given()
                .log().all()
                .when()
                .get(s + "/api/users?delay=3")
                .then()
                .body("data.first_name[0]", equalTo("George"))
                .statusCode(200)
                .log().all();
    }

}
