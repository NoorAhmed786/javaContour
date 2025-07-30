package com.noor.the_noor_residency.entity;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Room room;


    private LocalDate checkIn;
    private LocalDate checkOut;

    private double totalPrice;
    private String paymentMethod; // "CARD", "ACCOUNT"
    private boolean paid;
	public void setRoom(Room room2) {
		// TODO Auto-generated method stub
		this.room=room2;
	}
	public void setCheckIn(LocalDate checkIn2) {
		// TODO Auto-generated method stub
		this.checkIn=checkIn2;
	}
	public void setCheckOut(LocalDate checkOut2) {
		// TODO Auto-generated method stub
		this.checkOut=checkOut2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Room getRoom() {
		return room;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setTotalPrice(double totalPrice2) {
		// TODO Auto-generated method stub
		this.totalPrice=totalPrice2;
	}
	public void setPaymentMethod(String paymentMethod2) {
		// TODO Auto-generated method stub
		this.paymentMethod=paymentMethod2;
	}
	public void setPaid(boolean b) {
		// TODO Auto-generated method stub
		this.paid=b;
	}
	public User getUser() {
		// TODO Auto-generated method stub
		return user;
	}
	public void setUser(User user2) {
		// TODO Auto-generated method stub
		this.user=user2;
	}
    
    
}
