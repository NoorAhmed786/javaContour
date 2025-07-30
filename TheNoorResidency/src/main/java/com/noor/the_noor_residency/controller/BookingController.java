package com.noor.the_noor_residency.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noor.the_noor_residency.config.dto.BookingRequestDTO;
import com.noor.the_noor_residency.entity.Room;
import com.noor.the_noor_residency.repository.RoomRepository;
import com.noor.the_noor_residency.service.BookingService;
import org.springframework.ui.Model; // ✅ Correct Model



@Controller
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/search")
    public String showRoomSearchForm(Model model) {
        model.addAttribute("dto", new BookingRequestDTO());
        model.addAttribute("rooms", roomRepo.findAll().stream().filter(Room::isAvailable).toList());
        return "booking/search";
    }
    
   

    @PostMapping("/confirm")
    public String confirmBooking(@ModelAttribute BookingRequestDTO dto,
                                 Principal principal, Model model) {
        try {
            bookingService.createBooking(dto, principal.getName());
            return "redirect:/book/my";   // <-- یہ کریں
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return showRoomSearchForm(model);
        }
    }


    @GetMapping("/my")
    public String viewMyBookings(Model model, Principal principal) {
        model.addAttribute("bookings", bookingService.getUserBookings(principal.getName()));
        return "booking/my-bookings";
    }
}

