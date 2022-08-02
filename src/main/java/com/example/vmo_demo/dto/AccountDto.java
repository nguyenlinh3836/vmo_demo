package com.example.vmo_demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
public class AccountDto {

  @JsonProperty("userName")
  private String userName;
  @JsonProperty("password")
  private String password;
  @JsonProperty("roles")
  private List<String> role;

  public AccountDto() {
  }

  public AccountDto(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public AccountDto(String userName, String password, List<String> role) {
    this.userName = userName;
    this.password = password;
    this.role = role;
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

  public List<String> getRole() {
    return role;
  }

  public void setRole(List<String> role) {
    this.role = role;
  }
}
