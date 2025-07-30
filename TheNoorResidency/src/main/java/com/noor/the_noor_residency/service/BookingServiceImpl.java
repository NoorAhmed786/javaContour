package com.noor.the_noor_residency.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noor.the_noor_residency.config.dto.BookingRequestDTO;
import com.noor.the_noor_residency.entity.Booking;
import com.noor.the_noor_residency.entity.Room;
import com.noor.the_noor_residency.entity.User;
import com.noor.the_noor_residency.repository.BookingRepository;
import com.noor.the_noor_residency.repository.RoomRepository;
import com.noor.the_noor_residency.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired private RoomRepository roomRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private BookingRepository bookingRepo;

    @Override
    public Booking createBooking(BookingRequestDTO dto, String username) {
        Room room = roomRepo.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (!isRoomAvailable(room, dto.getCheckIn(), dto.getCheckOut())) {
            throw new RuntimeException("Room is not available for selected dates");
        }
        

        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        long nights = ChronoUnit.DAYS.between(dto.getCheckIn(), dto.getCheckOut());
        if (nights < 1) throw new RuntimeException("Check-out must be after check-in.");

        double discountedRate = room.getRatePerNight() * (1 - (room.getDiscount() / 100));
        double totalPrice = nights * discountedRate;

        if (dto.getPaymentMethod().equalsIgnoreCase("ACCOUNT")) {
            if (user.getAccountBalance() < totalPrice) {
                throw new RuntimeException("Insufficient account balance");
            }
            user.setAccountBalance(user.getAccountBalance() - totalPrice);
            userRepo.save(user);
        }
        

        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setUser(user);
        booking.setCheckIn(dto.getCheckIn()); // ✅ correct field
        booking.setCheckOut(dto.getCheckOut());
        booking.setTotalPrice(totalPrice);
        booking.setPaymentMethod(dto.getPaymentMethod());
        booking.setPaid(true);

        
        return bookingRepo.save(booking);
    }
    
  


    @Override
    public List<Booking> getUserBookings(String username) {
        User user = userRepo.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        return bookingRepo.findByUser(user);
    }
    // باقی methods پہلے جیسے ہیں...

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }



    @Override
    public boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
        List<Booking> bookings = bookingRepo.findByRoomAndCheckInLessThanEqualAndCheckOutGreaterThanEqual(
                room, checkOut.minusDays(1), checkIn.plusDays(1));
        return bookings.isEmpty();
    }

	
}

