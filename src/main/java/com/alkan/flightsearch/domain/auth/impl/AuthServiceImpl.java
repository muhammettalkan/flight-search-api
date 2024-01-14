package com.alkan.flightsearch.domain.auth.impl;

import com.alkan.flightsearch.domain.auth.api.AuthService;
import com.alkan.flightsearch.domain.auth.web.LoginRequest;
import com.alkan.flightsearch.domain.auth.web.LoginResponse;
import com.alkan.flightsearch.domain.auth.web.RegisterRequest;
import com.alkan.flightsearch.domain.user.impl.User;
import com.alkan.flightsearch.domain.user.impl.UserRepository;
import com.alkan.flightsearch.library.enums.Role;
import com.alkan.flightsearch.library.exception.custom.ResourceAlreadyExistException;
import com.alkan.flightsearch.library.exception.custom.ResourceNotFoundException;
import com.alkan.flightsearch.library.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = repository.findByUsername(loginRequest.username()).orElseThrow(
                () -> new ResourceNotFoundException("User", "username", loginRequest.username())
        );
        String token = jwtService.generateToken(user.getUsername());

        return new LoginResponse(token);

    }

    @Override
    public String userRegister(RegisterRequest registerRequest) {

        if (repository.existsByUsername(registerRequest.username())) {
            throw new ResourceAlreadyExistException(User.class.getSimpleName(), "username", registerRequest.username());
        }

        User user = new User();
        user.setName(registerRequest.name());
        user.setUsername(registerRequest.username());
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        user.setAuthority(Role.ROLE_USER);
        repository.save(user);

        return "User registered successfully";
    }

    public String adminRegister(RegisterRequest registerRequest) {

        if (repository.existsByUsername(registerRequest.username())) {
            throw new ResourceAlreadyExistException(User.class.getSimpleName(), "username", registerRequest.username());
        }

        User user = new User();
        user.setName(registerRequest.name());
        user.setUsername(registerRequest.username());
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        user.setAuthority(Role.ROLE_ADMIN);
        repository.save(user);

        return "Admin registered successfully";
    }
}
