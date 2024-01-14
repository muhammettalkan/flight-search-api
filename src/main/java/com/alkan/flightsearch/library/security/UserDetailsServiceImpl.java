package com.alkan.flightsearch.library.security;

import com.alkan.flightsearch.domain.user.impl.User;
import com.alkan.flightsearch.domain.user.impl.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                ()-> new UsernameNotFoundException("User not found with username: " + username)
        );
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getAuthority().name());
        grantedAuthorities.add(authority);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}
