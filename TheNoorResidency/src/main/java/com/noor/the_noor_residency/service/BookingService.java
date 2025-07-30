package com.noor.the_noor_residency.service;

import java.time.LocalDate;
import java.util.List;

import com.noor.the_noor_residency.config.dto.BookingRequestDTO;
import com.noor.the_noor_residency.entity.Booking;
import com.noor.the_noor_residency.entity.Room;

public interface BookingService {
    Booking createBooking(BookingRequestDTO dto, String username);
    List<Booking> getUserBookings(String username);
    boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut);
    

    // 👇 For admin
    List<Booking> getAllBookings();
}

