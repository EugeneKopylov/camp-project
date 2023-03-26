package my.app.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {
    private String firstName;
    private String secondName;
    private String surname;
    private String email;
    private String role;
}
