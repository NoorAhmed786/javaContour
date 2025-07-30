package com.noor.the_noor_residency.service;

import java.util.List;

import com.noor.the_noor_residency.entity.Room;

public interface RoomService {
    Room saveRoom(Room room);
    Room updateRoom(Long id, Room room);
    List<Room> getAllRooms();
    Room getRoomById(Long id);
    void deleteRoom(Long id);
    void toggleRoomAvailability(Long id);
}
