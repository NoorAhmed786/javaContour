package com.noor.the_noor_residency.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noor.the_noor_residency.entity.Booking;
import com.noor.the_noor_residency.entity.Room;
import com.noor.the_noor_residency.entity.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRoomAndCheckInLessThanEqualAndCheckOutGreaterThanEqual(Room room, LocalDate end, LocalDate start);
    List<Booking> findByUser(User user);
    List<Booking> findByRoomId(Long roomId);
    
    // 👇 All bookings for admin
    List<Booking> findAll();


}

