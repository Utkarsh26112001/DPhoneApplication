package com.dphone.user.dao;
import com.dphone.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity,String> {

    Optional<UserEntity> findUserByUserName(String userName);


}
