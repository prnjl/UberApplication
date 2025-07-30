package com.pranjal.project.uber.uberApplication.Entites;



import org.locationtech.jts.geom.Point;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "app_driver")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Boolean isAvaialble;
    
    private String vehicleId;

    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point currentLocation;

    // Getters and Setters (recommended for JPA)
}

