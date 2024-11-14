package com.springboot.uberApplication.UberApplication.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {
        @Index(name = "idx_rating_rider", columnList = "rider_Id"),
        @Index(name = "idx_rating_driver", columnList = "driver_Id")
})
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Ride ride;

    @ManyToOne
    private Rider rider;

    @ManyToOne
    private Driver driver;

    private Integer driverRating;
    private Integer riderRating;

}

