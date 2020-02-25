package ru.vershinin.TKK_Portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vershinin.TKK_Portal.persist.entity.User;
import ru.vershinin.TKK_Portal.persist.repo.UserRepository;
import ru.vershinin.TKK_Portal.repr.UserRepr;

import javax.transaction.Transactional;
import java.util.Optional;

import static ru.vershinin.TKK_Portal.securiry.Utils.getCurrentUser;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(UserRepr userRepr) {
        User user = new User();
        user.setUsername(userRepr.getUsername());
        user.setPassword(passwordEncoder.encode(userRepr.getPassword()));
        userRepository.save(user);
    }
}

