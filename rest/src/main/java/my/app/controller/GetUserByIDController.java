package my.app.controller;

import my.app.dto.UserDTO;
import my.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get-one")
public class GetUserByIDController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable int id) {
        return new ResponseEntity<UserDTO>(userService.getUserById(id), HttpStatus.OK);
    }

}
