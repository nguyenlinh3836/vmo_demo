package com.example.vmo_demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignInDto {
  @JsonProperty("userName")
  private String userName;
  @JsonProperty("password")
  private String password;

  public SignInDto() {
  }

  public SignInDto(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
