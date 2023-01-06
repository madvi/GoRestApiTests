import Users.GetAll.GetAllUsersResponse;
import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.Assert;
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
        GetAllUsersResponse getAllUsersResponse = usersClient.GetAllUsers();
        Assert.assertEquals(getAllUsersResponse.getStatusCode(),200);
        Assert.assertEquals(getAllUsersResponse.getDataList().size(),10);
        Assert.assertTrue(getAllUsersResponse.hasMaleUser());


        //3.Assert...



    }



}
