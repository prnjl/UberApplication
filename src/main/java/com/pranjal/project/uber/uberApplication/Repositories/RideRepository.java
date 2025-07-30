package com.pranjal.project.uber.uberApplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranjal.project.uber.uberApplication.Entites.RideEntity;

@Repository
public interface RideRepository extends JpaRepository<RideEntity, Long>{

}
