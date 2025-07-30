package com.pranjal.project.uber.uberApplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranjal.project.uber.uberApplication.Entites.RiderEntity;

@Repository
public interface RiderRepository extends JpaRepository<RiderEntity, Long>{

}
