package com.topia.epdms.controller;

import com.topia.epdms.model.AuthRequest;
import com.topia.epdms.model.AuthResponse;
import com.topia.epdms.model.Users;
import com.topia.epdms.service.UserService;
import com.topia.epdms.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest authRequest) {
        return userService.findUserByUsername(authRequest)
                .map(user ->  ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(new AuthResponse(jwtUtil.generateToken(authRequest.getUsername()))))
                .switchIfEmpty(Mono.error(new BadCredentialsException("Invalid username or password")));
    }
    @PostMapping("/signup")
    public Mono<ResponseEntity<String>> signup(@RequestBody Users user) {
        return userService.save(user)
                .map(savedUser -> ResponseEntity.ok("User signed up successfully"));
    }
    @GetMapping("/protected")
    public Mono<ResponseEntity<String>> protectedEndpoint() {
        return Mono.just(ResponseEntity.ok("You have accessed a protected endpoint!"));
    }
}