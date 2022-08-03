package com.example.vmo_demo.service;

import com.example.vmo_demo.model.entities.Account;
import com.example.vmo_demo.model.entities.Role;
import com.example.vmo_demo.repository.AccountRepo;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
private AccountRepo accountRepo;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Account> user = accountRepo.findByUserName(username);
    if (!user.isPresent()){
      throw new UsernameNotFoundException("Username " + username + " not found");
    }
    return new User(username,user.get().getPassword(),mapRolesToAuthorities(user.get().getRoles()));
  }
  private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
  }


}
