import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GetUserTest {

    private UsersClient usersClient;

    @BeforeClass
    private void beforeClass()
    {
        usersClient = new UsersClient();
    }

    @Test
    public void ShouldGetAllUsers(){
        //1.Arrange
        usersClient.GetAllUsers()

        //2.Act
                .then()
                .log().body()

        //3.Assert...

                .statusCode(200)
                .body("data",Matchers.hasSize(10))
                .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")));


    }



}
