package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.repositories.UserRepository;

import java.util.Collections;

@Service
public class UserBusinessService implements UserDetailsService {

    private final UserRepository usersRepository;

    public UserBusinessService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = usersRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
}
