package com.example.vmo_demo.mapper;

import com.example.vmo_demo.dto.RoleDto;
import com.example.vmo_demo.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDto, Role> {

}
