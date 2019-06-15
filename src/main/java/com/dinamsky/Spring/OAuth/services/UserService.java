package com.dinamsky.Spring.OAuth.services;

import com.dinamsky.Spring.OAuth.entities.User;
import com.dinamsky.Spring.OAuth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFindByUsername = userRepository.findByUsername(username);

        if (userFindByUsername!=null){
            return userFindByUsername;
        }
        return null;
    }


}
