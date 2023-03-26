package my.app.controller;

import my.app.dto.UserDTO;
import my.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class GetUsersWithPagination {

    @Autowired
    UserService userService;

    @GetMapping("{page}")
    public List<UserDTO> getUsersWithPagination(@PathVariable int page) {
        return userService.getUsersWithPaginationWithTenUnits(page);
    }

}
