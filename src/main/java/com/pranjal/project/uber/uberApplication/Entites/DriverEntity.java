package com.pranjal.project.uber.uberApplication.Entites;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

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

