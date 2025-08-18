package com.pranjal.project.uber.uberApplication.Entites;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "app_rider")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiderEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
