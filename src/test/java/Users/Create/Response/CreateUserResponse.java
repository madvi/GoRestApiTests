package Users.Create.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserResponse {

    @Setter
    private int statusCode;

    private String meta;
    private Data data;
}
