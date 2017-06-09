package com.liting.cs504.userservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vagrant on 6/9/17.
 */
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
