package com.topia.epdms.service;
import com.topia.epdms.model.AuthRequest;
import com.topia.epdms.model.Users;
import com.topia.epdms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public Mono<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Mono<Users> save(Users user) {
        //user.setPassword(user.getPassword()); // Encrypt password before saving
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Mono<Users> findUserByUsername(AuthRequest authRequest) {
        return userRepository
                .findByUsername(authRequest.getUsername())
                .filter(user -> encoder.matches(authRequest.getPassword(),user.getPassword()));
    }
}