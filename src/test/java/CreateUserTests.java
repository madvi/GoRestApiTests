import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

public class CreateUserTests {

    private UsersClient usersClient;

    @BeforeClass
    private void beforeClass()
    {
       usersClient = new UsersClient();
    }

    @Test
    public void ShouldCreateMaleUser() {
        //1.Arrange
        String email = String.format( "%s@gmail.com",UUID.randomUUID());
        String body = String.format("{\n" +
                "    \"name\": \"Mahadev\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}", email);

        usersClient
                .CreateUser(body)

        //2.Act
                .then()
                .log().body()

        //3.Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue());

    }

    @Test
    public void ShouldCreateFemaleUser() {
        //1.Arrange
        String email = String.format("%s@gmail.com",UUID.randomUUID());
        String body = String.format("{\n" +
                "    \"name\": \"Maadevi\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);

        usersClient
                .CreateUser(body)

        //2.Act
                .then()
                .log().body()

        //3.Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue());

    }

}
