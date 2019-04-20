package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.CustomUserDetail;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.respository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUsernameAndStatus(username, SystemConstant.USER_ACTIVE);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

//        set authority list of user
        List<GrantedAuthority> authorities = new ArrayList<>();
        userEntity.getRoles().forEach(roleEntity -> authorities.add(new SimpleGrantedAuthority(roleEntity.getCode())));

//        put user info to spring security
        UserDetails userDetail = new CustomUserDetail(userEntity.getUsername(), userEntity.getPassword(), authorities);
        BeanUtils.copyProperties(userEntity, userDetail);
        return userDetail;
    }
}
