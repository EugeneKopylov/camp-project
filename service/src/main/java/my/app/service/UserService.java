package my.app.service;

import my.app.dto.UserDTO;
import my.app.mapper.UserMapper;
import my.app.model.User;
import my.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final static int PAGE_SIZE = 10;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public UserDTO getUserById(int id) {
        return UserMapper.toDTO(userRepository.findById(id).get());
    }

    @Transactional
    public List<UserDTO> getUsersWithPaginationWithTenUnits(int pageNumber) {
        return userRepository.findAll(PageRequest.of(pageNumber, PAGE_SIZE, Sort.by("email")))
                .stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
}
