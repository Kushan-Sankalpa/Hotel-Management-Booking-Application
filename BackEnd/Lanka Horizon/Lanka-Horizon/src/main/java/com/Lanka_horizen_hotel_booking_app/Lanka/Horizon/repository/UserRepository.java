package com.Lanka_horizen_hotel_booking_app.Lanka.Horizon.repository;

import com.Lanka_horizen_hotel_booking_app.Lanka.Horizon.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   boolean existByEmail(String email);
   
   Optional<User> findByEmail(String email);


}
