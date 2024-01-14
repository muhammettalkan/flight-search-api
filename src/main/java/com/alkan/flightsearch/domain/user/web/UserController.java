package com.alkan.flightsearch.domain.user.web;

import com.alkan.flightsearch.domain.user.api.UserService;
import com.alkan.flightsearch.library.rest.BaseController;
import com.alkan.flightsearch.library.rest.DataResponse;
import com.alkan.flightsearch.library.rest.MetaResponse;
import com.alkan.flightsearch.library.rest.Response;
import com.alkan.flightsearch.library.security.JwtService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<Void> deleteUserById(String id) {
        service.deleteUserById(id);
        return new Response<>(MetaResponse.success());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<UserResponse> getUserById(String id) {
        return null;
    }
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<DataResponse<UserResponse>> getAll(){
        return respond(service.getAll().stream().map(UserService::toResponse).collect(Collectors.toList()));
    }


}
