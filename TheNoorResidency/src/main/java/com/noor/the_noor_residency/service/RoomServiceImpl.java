package com.noor.the_noor_residency.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noor.the_noor_residency.entity.Room;
import com.noor.the_noor_residency.repository.BookingRepository;
import com.noor.the_noor_residency.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Room not found"));

        existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
        existingRoom.setType(updatedRoom.getType());
        existingRoom.setOccupancy(updatedRoom.getOccupancy());
        existingRoom.setRatePerNight(updatedRoom.getRatePerNight());
        existingRoom.setDiscount(updatedRoom.getDiscount());
        existingRoom.setDescription(updatedRoom.getDescription());
        existingRoom.setAvailable(updatedRoom.isAvailable());

        return roomRepository.save(existingRoom);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void deleteRoom(Long id) {
        boolean hasBookings = !bookingRepository.findByRoomId(id).isEmpty();       
        if (hasBookings) {
            throw new IllegalStateException("Cannot delete room with active bookings.");
        }
        roomRepository.deleteById(id);
    }





    @Override
    public void toggleRoomAvailability(Long id) {
        Room room = getRoomById(id);
        room.setAvailable(!room.isAvailable());
        roomRepository.save(room);
    }
}
