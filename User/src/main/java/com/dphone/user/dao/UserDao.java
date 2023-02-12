package com.dphone.user.dao;
import com.dphone.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserDao extends JpaRepository<UserEntity,String> {

    Optional<UserEntity> findByUserName(String userName);


}
