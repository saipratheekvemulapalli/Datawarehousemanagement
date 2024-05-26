package com.cg.ims.exception;
@SuppressWarnings("serial")
public class InvalidBookingException extends RuntimeException {
	public InvalidBookingException(String msg)
	{
		super(msg);
	}

}
