package com.alkan.flightsearch.domain.user.api;

import com.alkan.flightsearch.domain.user.impl.User;
import com.alkan.flightsearch.domain.user.web.UserResponse;

import java.util.List;

public interface UserService {
    UserDto getUserById(String id);

    void deleteUserById(String id);

    List<UserDto> getAll();

    static UserResponse toResponse(UserDto userDto) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userDto.getId());
        userResponse.setName(userDto.getName());
        userResponse.setUsername(userDto.getUsername());
        userResponse.setPassword(userDto.getPassword());
        userResponse.setAuthority(userDto.getAuthority());
        userResponse.setCreated(userDto.getCreated());
        userResponse.setModified(userDto.getModified());
        return userResponse;
    }
}
