package com.example.vmo_demo.model.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "Account")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userName;
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "account_roles",
      joinColumns = @JoinColumn(name = "account_id"),
      inverseJoinColumns = @JoinColumn(name = "roles_id"))
  @ToString.Exclude
  private Set<Role> roles = new HashSet<>();

  public Set<Role> getRoles() {
    return roles;
  }

  public Account() {
  }

  public Account(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public Account(Long id, String userName, String password, Set<Role> roles) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.roles = roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
