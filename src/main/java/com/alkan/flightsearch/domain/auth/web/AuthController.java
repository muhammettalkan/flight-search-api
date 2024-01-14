package com.alkan.flightsearch.domain.auth.web;

import com.alkan.flightsearch.domain.auth.api.AuthService;
import com.alkan.flightsearch.library.rest.BaseController;
import com.alkan.flightsearch.library.rest.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController extends BaseController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping(value = {"/login", "/signin"})
    public Response<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return respond(service.login(loginRequest));
    }

    @PostMapping(value = {"/register", "/signup"})
    public Response<String> register(@RequestBody RegisterRequest registerRequest) {
        return respond(service.userRegister(registerRequest));
    }

    @PostMapping(value = {"/admin/register", "/admin/signup"})
    public Response<String> adminRegister(@RequestBody RegisterRequest registerRequest) {
        return respond(service.adminRegister(registerRequest));
    }
}
