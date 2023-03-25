package my.app.controller;

import my.app.dto.UserDTO;
import my.app.model.User;
import my.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class GetRestController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable int id) {
        UserDTO userDTO = userService.getUserById(id);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }

}
