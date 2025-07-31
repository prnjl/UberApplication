package com.pranjal.project.uber.uberApplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranjal.project.uber.uberApplication.Entites.UserEntity;

import java.util.Optional;

@Repository
public interface USerRepository extends JpaRepository<UserEntity, Long> {

    Optional< UserEntity> findByEmail(String email);

}
