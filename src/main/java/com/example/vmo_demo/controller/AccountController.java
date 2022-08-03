package com.example.vmo_demo.controller;

import com.example.vmo_demo.security.JwtUtils;
import com.example.vmo_demo.model.request.AccountDto;
import com.example.vmo_demo.mapper.AccountMapper;
import com.example.vmo_demo.model.entities.Account;
import com.example.vmo_demo.model.response.JwtResponse;
import com.example.vmo_demo.repository.RoleRepo;
import com.example.vmo_demo.service.AccountService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/auth")
public class AccountController {

  @Autowired
  private AccountService accountService;
  @Autowired
  private RoleRepo roleRepo;
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  JwtUtils jwtUtils;
  @Autowired
  private AccountMapper accountMapper;


  @PostMapping("/signIn")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody AccountDto accountDto) {
    Account account = accountMapper.toEntity(accountDto);
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(account.getUserName(),
            account.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    User userDetails = (User) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());
    AccountDto dto = accountMapper.toDto(account);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(new JwtResponse(jwt,dto.getUserName(),dto.getRole()));
  }

  @PostMapping("/signUp")
  public ResponseEntity<?> registerUser(@Valid @RequestBody AccountDto accountDto) {
    AccountDto user = accountService.createUser(accountDto);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
  }
}
