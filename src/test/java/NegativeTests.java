import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreateUserErrorResponse;
import Users.UsersClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
    public void ShouldNotAllowToCreateUserWithInvalidEmail(){
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
        CreateUserErrorResponse errorResponse = usersClient.UserExpectingError(requestBody);

        //3.Assert
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("email","is invalid");
            /*.statusCode(422)
            .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
            .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));*/
    }

    @Test
    public void ShouldNotAllowToCreateUserWithGenderAndStatusBlank(){
        //1.Arrange
        String email = "mahadevi3@gmail.com";
        String name = "Mahadev";
        String gender = "";
        String status = "";

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
        CreateUserErrorResponse errorResponse = usersClient.UserExpectingError(requestBody);

        //3.Assert
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("gender","can't be blank, can be male of female");
        errorResponse.assertHasError("status","can't be blank");

    }


}
