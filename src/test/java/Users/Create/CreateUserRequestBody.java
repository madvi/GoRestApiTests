package Users.Create;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestBody {

    private String name;
    private String gender;
    private String email;
    private String status;

    //@Getter - to get rid of multiple getters if the body has may attributes
    //@Builder - to pass the parameter in CURB instead of creating a constructor

    /*public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public CreateUserRequestBody(String name, String gender, String email, String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;
    }*/
}
