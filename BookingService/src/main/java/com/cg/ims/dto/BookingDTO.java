package com.cg.ims.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
@Entity
@Table(name="BookingTable")
public class BookingDTO {
	@Id
	private int bookingId;
	private int productId;
	private int customerId;
	private float charges;
	private LocalDateTime dateTime;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public float getCharges() {
		return charges;
	}
	public void setCharges(float charges) {
		this.charges = charges;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
