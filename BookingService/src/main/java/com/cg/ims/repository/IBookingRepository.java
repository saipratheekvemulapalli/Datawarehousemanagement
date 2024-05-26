package com.cg.ims.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.ims.entity.Booking;

public interface IBookingRepository extends CrudRepository<Booking, Integer> {

	List<Booking> findAllByCustomerId(int customerId);

}
