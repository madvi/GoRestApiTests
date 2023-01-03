import Users.Create.CreateUserRequestBody;
import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

public class NegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    private void beforeClass()
    {
       usersClient = new UsersClient();
    }

    @Test
    public void ShouldNotAllowToCreateUser(){
        //1.Arrange
        String email = "mahadevi3gmail.com";
        String name = "Mahadev";
        String gender = "male";
        String status = "active";

        /*String body = "\n" +
                "    \"name\": \"Maadevi\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"madhavigmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";*/

        //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().email(email)
                .gender(gender).name(name).status(status).build();

        //2.Act
        usersClient
                .CreateUser(requestBody)
                .then()
                .log().body()

         //3.Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }


}
