package com.cg.ims.service;

import java.util.List;

import com.cg.ims.dto.BookingDTO;
import com.cg.ims.dto.ResponseDTO;
import com.cg.ims.entity.Booking;
import com.cg.ims.exception.BookingException;

public interface IBookingService {

	// method to get the bookingId to book the products
	public Booking addBooking(Booking booking);

	// method to get the booking details
	public ResponseDTO getBookingById(int bookingId);

    //method to delete the booking
	public String deleteById(int productId, int customerId);
	
	//public BookingDTO deleteBooking(Integer bookingId)throws BookingException;
	
	// method to update the booking
	public Booking updateBooking(int bookingId, Booking updatedBooking);

	// method to calculate the entire bill of the product
	//public double calculateBill(int bookingId);
	
	
	public List<Booking> getBooking();

	

}
