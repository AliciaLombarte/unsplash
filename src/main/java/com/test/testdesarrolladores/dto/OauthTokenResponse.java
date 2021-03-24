package com.test.testdesarrolladores.dto;

import java.io.Serializable;

public class OauthTokenResponse implements Serializable {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private String scope;
    private String created_at;

    public OauthTokenResponse() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public OauthTokenResponse setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getToken_type() {
        return token_type;
    }

    public OauthTokenResponse setToken_type(String token_type) {
        this.token_type = token_type;
        return this;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public OauthTokenResponse setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public OauthTokenResponse setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public String getCreated_at() {
        return created_at;
    }

    public OauthTokenResponse setCreated_at(String created_at) {
        this.created_at = created_at;
        return this;
    }
}
