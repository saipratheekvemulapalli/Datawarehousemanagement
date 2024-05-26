package com.cg.ims.exception;
@SuppressWarnings("serial")
public class InvalidCustomerIdException extends  RuntimeException{
	public InvalidCustomerIdException(String msg)
	{
		super(msg);
	}

}
