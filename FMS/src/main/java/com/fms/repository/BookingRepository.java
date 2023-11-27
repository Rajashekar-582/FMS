package com.fms.repository;

import java.util.ArrayList;


import com.fms.entities.Booking;

public interface BookingRepository {

	ArrayList<Booking> getBooking();
	Booking getBookingById(int bookingId);
	Booking addBooking(Booking booking);
	Booking updateBooking(int bookingId, Booking booking);
	void deleteBooking(int bookingId);
}
