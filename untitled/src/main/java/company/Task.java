package company;


import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Task {

    String site = "https://reqres.in";

    @Test
    public void first_test() {
        given()
                .log().all()
                .when()
                .get(site + "/api/users?page=2")
                .then()
                .body("data.avatar[1]", equalTo("https://reqres.in/img/faces/8-image.jpg"))
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test2() {
        given()
                .log().all()
                .when()
                .get(site + "/api/users/2")
                .then()
                //    .body("data.first_name",equalTo("Janet"))
                .body("data.first_name", equalTo("Janet"))
                .statusCode(200)
                .log().all()
                .and();
    }

    @Test
    public void SINGLE_USER_NOT_FOUND_3() {
        given()
                .log().all()
                .when()
                .get(site + "/api/users/23")
                .then()
                .statusCode(404)
                .log().all()
                .and();
    }

    @Test
    public void LIST_RESOURCE() {
        given()
                .log().all()
                .when()
                .get(site + "/api/unknown")
                .then()
                .statusCode(200)
                //      .body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
                .body("data.name[4]", equalTo("tigerlily"))
                .log().all()
                .and();
    }

    @Test
    public void SINGLE_RESOURCE() {
        given()
                .log().all()
                .when()
                .get(site + "/api/unknown/2")
                .then()
                .statusCode(200)
                .body("data.year", equalTo(2001))
                .log().all()
                .and();
    }

    @Test
    public void SINGLE_RESOURCE_NOT_FOUND() {
        given()
                .log().all()
                .when()
                .get(site + "/api/unknown/23")
                .then()
                .statusCode(404)
                .log().all()
                .and();

    }


}
