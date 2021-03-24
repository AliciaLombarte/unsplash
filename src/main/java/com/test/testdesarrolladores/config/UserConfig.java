package com.test.testdesarrolladores.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Value("${user.access_token}")
    private String userAccessToken;
    @Value("${user.token_type}")
    private String userTokenType;
    @Value("${user.refresh_token}")
    private String userRefreshToken;
    @Value("${user.scope}")
    private String userScope;
    @Value("${user.created_at}")
    private int userCreatedAt;

    public String getUserAccessToken() {
        return userAccessToken;
    }

    public UserConfig setUserAccessToken(String userAccessToken) {
        this.userAccessToken = userAccessToken;
        return this;
    }

    public String getUserTokenType() {
        return userTokenType;
    }

    public UserConfig setUserTokenType(String userTokenType) {
        this.userTokenType = userTokenType;
        return this;
    }

    public String getUserRefreshToken() {
        return userRefreshToken;
    }

    public UserConfig setUserRefreshToken(String userRefreshToken) {
        this.userRefreshToken = userRefreshToken;
        return this;
    }

    public String getUserScope() {
        return userScope;
    }

    public UserConfig setUserScope(String userScope) {
        this.userScope = userScope;
        return this;
    }

    public int getUserCreatedAt() {
        return userCreatedAt;
    }

    public UserConfig setUserCreatedAt(int userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
        return this;
    }
}
