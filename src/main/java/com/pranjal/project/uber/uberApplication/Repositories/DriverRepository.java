package com.pranjal.project.uber.uberApplication.Repositories;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long>{

	@Query("SELECT d.* , ST_Distance(d.current_location, :pickupLocation)AS distance " +
	"FROM drivers AS d " +
			"where isAvailable =true AND ST_DWithin(d.current_location, :pickupLocation , 10000)" +
	"ORDER BY distance " +
	"LIMIT 10")
	List<DriverEntity> findTenNearestDriver(Point pickupLocation);

}
