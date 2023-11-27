package com.fms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entities.Booking;
import com.fms.service.BookingJpaService;

@RestController
@RequestMapping("/api/user")
public class BookingController {
	
	@Autowired
	public BookingJpaService book;
	@GetMapping("/booking")
	ArrayList<Booking> getBooking()
	{
		return book.getBooking();
	}
	@GetMapping("/booking/{bookingId}")
	Booking getBookingById(int bookingId)
	{
		return book.getBookingById(bookingId);
	}
	@PostMapping("/booking/addnewbooking")
	Booking addBooking(Booking booking)
	{
		return book.addBooking(booking);
	}
	@PutMapping("/booking/{bookingId}")
	Booking updateBooking(int bookingId, Booking booking)
	{
		return book.updateBooking(bookingId, booking);
	}
	@DeleteMapping("/booking/{bookingId}")
	void deleteBooking(int bookingId)
	{
		book.deleteBooking(bookingId);
	}

}
