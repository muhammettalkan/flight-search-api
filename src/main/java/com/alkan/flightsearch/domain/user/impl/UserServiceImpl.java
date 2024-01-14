package com.alkan.flightsearch.domain.user.impl;

import com.alkan.flightsearch.domain.user.api.UserDto;
import com.alkan.flightsearch.domain.user.api.UserService;
import com.alkan.flightsearch.library.exception.custom.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserById(String id) {
    User user = userRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(User.class.getSimpleName(), "id", id)
    );
        return toDto(user);
    }

    @Override
    public void deleteUserById(String id) {
        var user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(User.class.getSimpleName(), "id", id)
        );
        userRepository.delete(user);
    }
    @Override
    public List<UserDto> getAll(){
        return userRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setAuthority(user.getAuthority());
        userDto.setCreated(user.getCreated());
        userDto.setModified(user.getModified());
        return userDto;
    }
}
