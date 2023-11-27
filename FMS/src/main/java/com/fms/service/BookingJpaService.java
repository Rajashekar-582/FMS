package com.fms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.fms.entities.Airport;
import com.fms.entities.Booking;
import com.fms.repository.BookingJpaRepository;
import com.fms.repository.BookingRepository;
@Service
public class BookingJpaService implements BookingRepository {

	@Autowired
	public BookingJpaRepository bookJpaRepository;
	@Override
	public ArrayList<Booking> getBooking() {
		List<Booking> airportList=bookJpaRepository.findAll();
		ArrayList<Booking> admin=new ArrayList<>(airportList);
		return admin;
	}

	@Override
	public Booking getBookingById(int bookingId) {
		try
		{
		Booking admin= bookJpaRepository.findById( bookingId).get();
		return admin;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Booking addBooking(Booking booking) {
		bookJpaRepository.save(booking);
		 return booking;
	}

	@Override
	public Booking updateBooking(int bookingId, Booking booking) {
		try
		{
		Booking existingAdmin= bookJpaRepository.findById( bookingId).get();
		if(booking.getName()!=null)
		{
			existingAdmin.setName(booking.getName());
		}
		 bookJpaRepository.save(existingAdmin);
		return existingAdmin;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteBooking(int bookingId) {
		try
		{
		Booking admin= bookJpaRepository.findById(bookingId).get();
		if(admin!=null)
		{
			bookJpaRepository.deleteById(bookingId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
