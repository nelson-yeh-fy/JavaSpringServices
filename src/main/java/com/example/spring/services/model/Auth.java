package com.example.spring.services.model;

public class Auth {

    private String loginName;
    private String pwd;
    private String token;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String user) {
        this.loginName = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}