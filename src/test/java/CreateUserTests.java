import Users.Create.CreateUserRequestBody;
import Users.Create.Response.CreateUserResponse;
import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.Assert;
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
        String name = "Mahadev";
        String gender = "male";
        String status = "active";

        /*String body = String.format("{\n" +
                "    \"name\": \"Mahadev\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}", email);*/

        //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().email(email)
                                            .gender(gender).name(name).status(status).build();

        //2.Act
        CreateUserResponse createUserResponse = usersClient.CreateUser(requestBody);

        //3.Assert
        createUserResponse.assertUser(requestBody);


    }

    @Test
    public void ShouldCreateFemaleUser() {
        //1.Arrange
        String email = String.format("%s@gmail.com",UUID.randomUUID());
        String name = "Vinutha";
        String gender = "female";
        String status = "active";

        //CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().email(email)
                .gender(gender).name(name).status(status).build();

        //2.Act
        //createUser is now returning response as createUserResponse so taking it to  a variable
        CreateUserResponse createUserResponse = usersClient.CreateUser(requestBody);

        //3.Assert
        createUserResponse.assertUser(requestBody);

    }

}
