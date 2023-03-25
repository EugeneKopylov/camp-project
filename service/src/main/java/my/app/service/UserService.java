package my.app.service;

import my.app.dto.UserDTO;
import my.app.mapper.UserMapper;
import my.app.model.User;
import my.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

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
}
