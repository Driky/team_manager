package com.gmail.driktheviking.modules.user.db.repositories;


import com.gmail.driktheviking.modules.user.db.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    UserEntity findByUsernameAndPasswordHash(String username, String passwordHash);
}