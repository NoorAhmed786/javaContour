package com.noor.the_noor_residency.config.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class BookingRequestDTO {
    private Long roomId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String paymentMethod;

    // ✅ Getters and Setters
    public Long getRoomId() { return roomId; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }

    public LocalDate getCheckIn() { return checkIn; }
    public void setCheckIn(LocalDate checkIn) { this.checkIn = checkIn; }

    public LocalDate getCheckOut() { return checkOut; }
    public void setCheckOut(LocalDate checkOut) { this.checkOut = checkOut; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}

