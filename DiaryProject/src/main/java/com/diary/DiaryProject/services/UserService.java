package com.diary.DiaryProject.services;

import com.diary.DiaryProject.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Service
public interface UserService extends UserDetailsService {

    public boolean registerUser(User user, boolean isAdmin) throws Exception;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    public User loadUserByUsernameEntity(String username);
}