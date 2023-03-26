package my.app.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class UserDTO {

    @Pattern(regexp = "([A-z])\\w+", message = "only latin characters are allowed")
    @Size(max = 20, message = "The maximum number of characters is 20")
    private String firstName;

    @Pattern(regexp = "([A-z])\\w+", message = "only latin characters are allowed")
    @Size(max = 40, message = "The maximum number of characters is 40")
    private String secondName;

    @Pattern(regexp = "([A-z])\\w+", message = "only latin characters are allowed")
    @Size(max = 40, message = "The maximum number of characters is 40")
    private String surname;

    @Email(message = "email is invalid")
    @Size(max = 50, message = "The maximum number of characters is 50")
    private String email;

    @Pattern(regexp = "Administrator|Sale User|Customer User|Secure API User", message = "invalid role, only Administrator, Sale User, Customer User, Secure API User are available")
    private String role;
}
