package com.example.vmo_demo.service;

import com.example.vmo_demo.model.request.AccountDto;
import com.example.vmo_demo.mapper.AccountMapper;
import com.example.vmo_demo.model.entities.Account;
import com.example.vmo_demo.common.enums.ERole;
import com.example.vmo_demo.model.entities.Role;
import com.example.vmo_demo.repository.AccountRepo;
import com.example.vmo_demo.repository.RoleRepo;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountRepo accountRepo;
  @Autowired
  private RoleRepo roleRepo;
  @Autowired
  private AccountMapper accountMapper;

  @Override
  public AccountDto createUser(AccountDto accountDto) {
    Account account = accountMapper.toEntity(accountDto);
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String passEncode = encoder.encode(account.getPassword());
    account.setPassword(passEncode);
    if (accountRepo.existsByUserName(account.getUserName())) {
      throw new RuntimeException("Error: Username is already taken!");
    }
    // Create new user's account
    Set<Role> strRoles = account.getRoles();
    Set<Role> roles = new HashSet<>();
    if (strRoles == null) {
      Role userRole = roleRepo.findByRoleName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    }
    account.setRoles(roles);
    accountRepo.save(account);
    return accountMapper.toDto(account);
  }

  @Override
  public Optional<AccountDto> findByUsername(String username) {
    return Optional.empty();
  }

}
