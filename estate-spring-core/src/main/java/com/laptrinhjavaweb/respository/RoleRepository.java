package com.laptrinhjavaweb.respository;

import com.laptrinhjavaweb.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

}
