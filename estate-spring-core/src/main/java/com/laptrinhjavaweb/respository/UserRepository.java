package com.laptrinhjavaweb.respository;

import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findOneByUsernameAndPasswordAndStatus(String username, String password, Boolean status);
}
