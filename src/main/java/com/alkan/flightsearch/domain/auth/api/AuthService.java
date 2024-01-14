package com.alkan.flightsearch.domain.auth.api;

import com.alkan.flightsearch.domain.auth.web.LoginRequest;
import com.alkan.flightsearch.domain.auth.web.LoginResponse;
import com.alkan.flightsearch.domain.auth.web.RegisterRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    String userRegister(RegisterRequest registerRequest);
    String adminRegister(RegisterRequest registerRequest);
}
