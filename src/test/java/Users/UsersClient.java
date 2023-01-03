package Users;

import Users.Create.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public Response CreateUser(CreateUserRequestBody body) {
        return given()

                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 7f120bbebae7c79e6e536e658a0dc729127b618c79fd4f0e483d83f3e3bc2a40")
                .body(body)
                //2.Act
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }

    public static Response GetAllUsers() {
        return given()

                .when()
                .get("https://gorest.co.in/public/v1/users");
    }
}
