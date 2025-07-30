package com.noor.the_noor_residency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.noor.the_noor_residency.entity.Room;
import com.noor.the_noor_residency.service.BookingService;
import com.noor.the_noor_residency.service.RoomService;

@Controller
@RequestMapping("/admin/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "admin/rooms"; // templates/admin/rooms.html
    }

    @GetMapping("/add")
    public String showAddRoomForm(Model model) {
        model.addAttribute("room", new Room());
        return "admin/add-room"; // templates/admin/add-room.html
    }

    @PostMapping("/add")
    public String saveRoom(@ModelAttribute("room") Room room) {
        roomService.saveRoom(room);
        return "redirect:/admin/rooms";
    }

    @GetMapping("/edit/{id}")
    public String showEditRoomForm(@PathVariable Long id, Model model) {
        model.addAttribute("room", roomService.getRoomById(id));
        return "admin/edit-room";
    }

    @PostMapping("/update/{id}")
    public String updateRoom(@PathVariable Long id, @ModelAttribute Room room) {
        roomService.updateRoom(id, room);
        return "redirect:/admin/rooms";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return "redirect:/admin/rooms";
    }

    @GetMapping("/toggle/{id}")
    public String toggleRoomAvailability(@PathVariable Long id) {
        roomService.toggleRoomAvailability(id);
        return "redirect:/admin/rooms";
    }

    // ✅ New Mapping for All Bookings
    @GetMapping("/all")
    public String listAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "admin/all-bookings"; // templates/admin/all-bookings.html
    }
}
