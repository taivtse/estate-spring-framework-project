package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.RoleConverter;
import com.laptrinhjavaweb.dto.RoleDto;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.respository.RoleRepository;
import com.laptrinhjavaweb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractService<RoleDto, RoleEntity, Integer> implements RoleService {
    private RoleRepository userRepository;

    @Autowired
    public RoleServiceImpl(@Qualifier("roleConverter") RoleConverter roleConverter,
                           @Qualifier("roleRepository") RoleRepository roleRepository) {
        super(roleConverter, roleRepository);
        this.userRepository = roleRepository;
    }
}
