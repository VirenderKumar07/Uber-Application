package com.springboot.uberApplication.UberApplication.repositories;

import com.springboot.uberApplication.UberApplication.entities.Ride;
import com.springboot.uberApplication.UberApplication.entities.Rider;
import com.springboot.uberApplication.UberApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
    Optional<Rider> findByUser(User user);
}
