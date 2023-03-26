package my.app.controller;

import my.app.dto.UserDTO;
import my.app.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class GetUsersWithPagination {

    private static final Logger LOGGER = LogManager.getLogger(GetUsersWithPagination.class);

    @Autowired
    UserService userService;

    @GetMapping("{page}")
    public List<UserDTO> getUsersWithPagination(@PathVariable int page) {
        LOGGER.info("get users from " + page + " page");
        return userService.getUsersWithPaginationWithTenUnits(page);
    }

}
