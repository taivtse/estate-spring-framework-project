package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.constant.ApiConstant;
import com.laptrinhjavaweb.dto.AuthToken;
import com.laptrinhjavaweb.dto.CustomUserDetail;
import com.laptrinhjavaweb.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private final HttpServletRequest request;
    private final RestTemplate restTemplate;

    @Autowired
    public CustomUserDetailsService(HttpServletRequest request, RestTemplate restTemplate) {
        this.request = request;
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = request.getParameter("j_password");

        String token = this.getAuthToken(username, password);
        UserDto userDto = findByUserName(username, token);

        if (userDto == null) {
            throw new UsernameNotFoundException("User not found");
        }

//        set authority list of user
        List<GrantedAuthority> authorities = new ArrayList<>();
        userDto.getRoles().forEach(roleDto -> authorities.add(new SimpleGrantedAuthority(roleDto.getCode())));

//        put user info to spring security
        CustomUserDetail userDetail = new CustomUserDetail(userDto.getUsername(), userDto.getPassword(), authorities);
        BeanUtils.copyProperties(userDto, userDetail);
        userDetail.setToken(token);
        return userDetail;
    }

    private UserDto findByUserName(String username, String token) {
        if (token == null)
            return null;

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(ApiConstant.API_USER_END_POINT)
                .queryParam("username", username);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        ResponseEntity<UserDto> responseEntity = this.restTemplate
                .getForEntity(uriComponentsBuilder.toUriString(), UserDto.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        }
        return null;
    }

    private String getAuthToken(String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);

        HttpEntity<UserDto> httpEntity = new HttpEntity<>(userDto, headers);

        try {
            ResponseEntity<AuthToken> responseEntity = this.restTemplate
                    .postForEntity(ApiConstant.API_AUTH_END_POINT, httpEntity, AuthToken.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return Objects.requireNonNull(responseEntity.getBody()).getToken();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        return null;
    }
}
