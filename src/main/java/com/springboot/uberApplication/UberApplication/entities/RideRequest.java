package com.springboot.uberApplication.UberApplication.entities;

import com.springboot.uberApplication.UberApplication.entities.enums.PaymentMethod;
import com.springboot.uberApplication.UberApplication.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(name = "idx_ride_request_rider", columnList = "rider_id")
})
public class RideRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point pickUpLocation;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point dropOffLocation;

    @CreationTimestamp
    private LocalDateTime requestedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    @Enumerated(EnumType.STRING)
    private RideRequestStatus rideRequestStatus;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethods;

    private Double fare;
}