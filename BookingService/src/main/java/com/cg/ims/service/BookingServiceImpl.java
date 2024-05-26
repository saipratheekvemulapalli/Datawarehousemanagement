package com.cg.ims.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.ims.dto.CustomerDTO;
import com.cg.ims.dto.ProductDTO;
import com.cg.ims.dto.ResponseDTO;
import com.cg.ims.entity.Booking;
import com.cg.ims.exception.BookingIdNotFoundException;
import com.cg.ims.exception.CustomerNotFoundException;
import com.cg.ims.exception.InvalidBookingException;
import com.cg.ims.exception.InvalidCustomerIdException;
import com.cg.ims.exception.InvalidProductIdException;
import com.cg.ims.exception.NoProductsBookedException;
import com.cg.ims.repository.IBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookingServiceImpl implements IBookingService {
	@Autowired
	IBookingRepository bookingRepo;

	@Autowired
	RestTemplate restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
	@Override
	public Booking addBooking(Booking booking) {
		Booking newBooking = new Booking();
		int productId = booking.getProductId();
		int customerId = booking.getCustomerId();

		try {
			ResponseEntity<ProductDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8089/ims/getproduct/" + productId, ProductDTO.class);
			ProductDTO productDto = responseEntity.getBody();

			if (productDto != null) {
				newBooking.setProductId(productDto.getProductId());
				newBooking.setCharges(productDto.getCharges());
				newBooking.setSize(productDto.getSize());
				newBooking.setName(productDto.getName());
			} else {
				throw new InvalidProductIdException("Product not found with the given Id");
			}
		} catch (HttpClientErrorException ex) {
			throw new InvalidProductIdException("Product not found with the given Id");
		}

		try {
			ResponseEntity<CustomerDTO> responseEntity2 = restTemplate
					.getForEntity("http://localhost:9090/inventory/getcustomerbyid/" + customerId, CustomerDTO.class);
			CustomerDTO customerDto = responseEntity2.getBody();

			if (customerDto != null) {
				newBooking.setCustomerId(customerDto.getCustomerId());
			} else {
				throw new CustomerNotFoundException("Customer not found with the given Id!");
			}
		} catch (HttpClientErrorException ex) {
			throw new CustomerNotFoundException("Customer not found with the given Id!");
		}

		newBooking.setDateTime(booking.getDateTime());
		newBooking = bookingRepo.save(newBooking);

		return newBooking;
	}

	// method to get the bookingDetails
	@Override
	public ResponseDTO getBookingById(int bookingId) {

		Optional<Booking> opt = bookingRepo.findById(bookingId);
		ResponseDTO responseDto = new ResponseDTO();
		if (opt.isPresent()) {
			Booking b = opt.get();

			try {
				// Make a request to the product repository microservice
				ResponseEntity<ProductDTO> responseEntity = restTemplate
						.getForEntity("http://localhost:8089/ims/getproduct/" + b.getProductId(), ProductDTO.class);
				ProductDTO productDto = responseEntity.getBody();
				responseDto.setProduct(productDto);
			} catch (InvalidProductIdException ex) {
				logger.info("Invalid product ID");

			}

			try {
				// Make a request to the customer repository microservice
				ResponseEntity<CustomerDTO> responseEntity2 = restTemplate
						.getForEntity("http://localhost:9090/inventory/getcustomerbyid/" + b.getCustomerId(), CustomerDTO.class);

				CustomerDTO customerDto = responseEntity2.getBody();

				responseDto.setCustomer(customerDto);

			} catch (InvalidCustomerIdException ex) {
				logger.info("Invalid customer ID");
			}
			return responseDto;
		}

		 else {
			throw new BookingIdNotFoundException("Booking Id not found");

		}

	}
	

	@Override
	public String deleteById(int productId, int customerId) {

		// Check if productId and customerId are valid or not

		try {

			ResponseEntity<ProductDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8089/ims/getproduct/" + productId, ProductDTO.class);
		}

		catch (HttpClientErrorException ex) {

			throw new InvalidProductIdException("Invalid Product Id");

		}

		try {
			// Make a request to the customer repository microservice
			ResponseEntity<CustomerDTO> responseEntity2 = restTemplate
					.getForEntity("http://localhost:9090/inventory/getcustomerbyid/" + customerId, CustomerDTO.class);
		} catch (HttpClientErrorException ex) {

			throw new InvalidCustomerIdException("Customer Id Not Found");

		}

		Iterable<Booking> bookings = bookingRepo.findAll();
		for (Booking booking : bookings) {
			if (booking.getProductId() == productId && booking.getCustomerId() == customerId) {
				bookingRepo.delete(booking);
				return "Booking deleted successfully";
			}
		}

		throw new InvalidBookingException("Booking not found");

	}

	@Override
	public Booking updateBooking(int bookingId, Booking updatedBooking) {
		Booking existingBooking = bookingRepo.findById(bookingId)
				.orElseThrow(() -> new BookingIdNotFoundException("Booking not found with the given ID"));

		int productId = updatedBooking.getProductId();
		int customerId = updatedBooking.getCustomerId();

		try {
			ResponseEntity<ProductDTO> responseEntity = restTemplate
					.getForEntity("http://localhost:8089/ims/getproduct/" + productId, ProductDTO.class);
			ProductDTO productDto = responseEntity.getBody();

			if (productDto != null) {
				existingBooking.setProductId(productDto.getProductId());
				existingBooking.setCharges(productDto.getCharges());
			} else {
				throw new InvalidProductIdException("Product not found with the given ID");
			}
		} catch (HttpClientErrorException ex) {
			throw new InvalidProductIdException("Product not found with the given ID");
		}

		try {
			ResponseEntity<CustomerDTO> responseEntity2 = restTemplate
					.getForEntity("http://localhost:9090/inventory/getcustomerbyid/" + customerId, CustomerDTO.class);
			CustomerDTO customerDto = responseEntity2.getBody();

			if (customerDto != null) {
				existingBooking.setCustomerId(customerDto.getCustomerId());
			} else {
				throw new CustomerNotFoundException("Customer not found with the given ID");
			}
		} catch (HttpClientErrorException ex) {
			throw new CustomerNotFoundException("Customer not found with the given ID");
		}

		existingBooking.setDateTime(updatedBooking.getDateTime());

		existingBooking = bookingRepo.save(existingBooking);

		return existingBooking;
	}

	//@Override
	//public double calculateBill(int customerId) {

		//List<Booking> bookings = bookingRepo.findAllByCustomerId(customerId);

		//if (bookings.isEmpty()) {
			//throw new NoProductsBookedException("You have not booked any product");
		//}

		//double sum = 0;

		//for (Booking b : bookings) {

			//sum = sum + b.getCharges();

		//}
		
		// calculating tax
		//double cgst = sum * 0.025; // 2.5% CGST
		//double sgst = sum * 0.025; // 2.5% SGST

		//sum = (cgst + sgst + sum);
		//return sum;

		
		
	//}

	@Override
	public List<Booking> getBooking() {
		
		return (List<Booking>) bookingRepo.findAll();
	}


	

}

	
	

