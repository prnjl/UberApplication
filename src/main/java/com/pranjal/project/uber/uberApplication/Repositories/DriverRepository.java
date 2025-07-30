package com.pranjal.project.uber.uberApplication.Repositories;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long>{

	List<DriverEntity> findMatchingDriver(Point point, Point point2);

}
