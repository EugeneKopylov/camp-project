package my.app.mapper;

import my.app.dto.UserDTO;
import my.app.model.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getFirstname(),
                user.getLastname(),
                user.getSurname(),
                user.getEmail(),
                user.getRole()
        );
    }
}
