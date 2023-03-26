package my.app.controller;

import lombok.SneakyThrows;
import my.app.dto.UserDTO;
import my.app.mapper.UserMapper;
import my.app.model.User;
import my.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add-user")
public class AddUserController {

    @Autowired
    UserService userService;

    @SneakyThrows
    @PostMapping
    public ResponseEntity<UserDTO> addNewUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(UserMapper.fromDTO(userDTO));
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
}
