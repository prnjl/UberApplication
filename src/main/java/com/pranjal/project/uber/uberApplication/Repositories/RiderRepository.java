package com.pranjal.project.uber.uberApplication.Repositories;

import com.pranjal.project.uber.uberApplication.Entites.RiderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<RiderEntity, Long>{

}
