package com.example.vmo_demo.model.request;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

  @Id
  private long Id;
  private String rolename;
}
