package com.pranjal.project.uber.uberApplication.Repositories;

import com.pranjal.project.uber.uberApplication.Entites.RideRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideReqyestRepository extends JpaRepository<RideRequestEntity,Long> {

}
