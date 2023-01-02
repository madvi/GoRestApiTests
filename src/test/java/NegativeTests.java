import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        String body = "\n" +
                "    \"name\": \"Maadevi\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"madhavigmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        //2.Act
        usersClient
                .CreateUser(body)
                .then()
                .log().body()

         //3.Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }


}
