package com.pranjal.project.uber.uberApplication.Repositories;

import com.pranjal.project.uber.uberApplication.Entites.DriverEntity;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {


   /* ST_Distance(geom1, geom2)  --->
   returns the straight-line
    distance between two geometry or geography points.*/


    //ST_DWithin(geom1, geom2, distance) → returns true if two points are within the given distance.(10000)->10Kelometer)



    @Query(value = "SELECT d.* , ST_Distance(d.current_location, :pickupLocation)AS distance " +
            "FROM drivers d " +
            "WHERE d.is_avaialble =true AND ST_DWithin(d.current_location, :pickupLocation , 10000)" +
            "ORDER BY distance " +
            "LIMIT 10", nativeQuery = true)
    List<DriverEntity> findTenNearestDriver(@Param("pickupLocation") Point pickupLocation);


    @Query(value = "SELECT d.* " +
            "FROM app_driver d " +
            "WHERE d.is_avaialble = true AND ST_DWithin(d.current_location, :pickupLocation , 15000)" +
            "ORDER BY d.rating DESC " +
            "LIMIT 10",nativeQuery = true)
    List<DriverEntity> findNearByTopRetedDrivers(@Param("pickupLocation") Point pickupLocations);
}

