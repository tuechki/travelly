package com.sofia.uni.fmi.travelly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Map;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final Map<String, OAuth2UserService<OAuth2UserRequest, OAuth2User>> userServiceMap;

    @Autowired
    public CustomOAuth2UserService(Map<String, OAuth2UserService<OAuth2UserRequest, OAuth2User>> userServiceMap) {
        this.userServiceMap = userServiceMap;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2UserService<OAuth2UserRequest, OAuth2User> userService = this.userServiceMap.get(registrationId);
        Assert.notNull(userService, "userService cannot be null");
        return userService.loadUser(userRequest);
    }

    private static class OAuth2AuthenticationException extends AuthenticationException {
        public OAuth2AuthenticationException(String msg, Throwable t) {
            super(msg, t);
        }
    }
}

