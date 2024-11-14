package com.springboot.uberApplication.UberApplication.repositories;


import com.springboot.uberApplication.UberApplication.entities.Driver;
import com.springboot.uberApplication.UberApplication.entities.Rating;
import com.springboot.uberApplication.UberApplication.entities.Ride;
import com.springboot.uberApplication.UberApplication.entities.Rider;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long > {
    List<Rating> findByRider(Rider rider);
    List<Rating> findByDriver(Driver driver);

    Optional<Rating> findByRide(Ride ride);
}
