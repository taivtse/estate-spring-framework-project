package com.laptrinhjavaweb.respository;

import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findOneByUsernameAndStatus(String username, Boolean status);
}
