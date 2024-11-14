package com.springboot.uberApplication.UberApplication.repositories;

import com.springboot.uberApplication.UberApplication.entities.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {
}
