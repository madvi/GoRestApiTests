package Users;

import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreateUserErrorResponse;
import Users.Create.Response.CreateUserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public CreateUserResponse CreateUser(CreateUserRequestBody body) {
        Response response = create(body);
        //Asking RestAssured to return response of type CreateUserResponse
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());

        return createUserResponse;
    }

    public CreateUserErrorResponse UserExpectingError(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }
    //This method will return plain RestAssured response
    public static Response create(CreateUserRequestBody body) {
        Response response = given()

                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 7f120bbebae7c79e6e536e658a0dc729127b618c79fd4f0e483d83f3e3bc2a40")
                .body(body)
                //2.Act
                .when()
                .post("https://gorest.co.in/public/v1/users");

        response.then()
                .log().body();

        return
                response;
    }

    public static Response GetAllUsers() {
        return given()

                .when()
                .get("https://gorest.co.in/public/v1/users");
    }
}
